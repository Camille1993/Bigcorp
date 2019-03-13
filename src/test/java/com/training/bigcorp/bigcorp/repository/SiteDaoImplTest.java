package com.training.bigcorp.bigcorp.repository;


import com.training.bigcorp.bigcorp.model.Site;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

@RunWith(SpringRunner.class)
@JdbcTest
@ComponentScan
public class SiteDaoImplTest {

    @Autowired
    private SiteDao siteDao;

    @Test
    public void create() {
        Assertions.assertThat(siteDao.findAll()).hasSize(1);
        siteDao.persist(new Site("New site"));
        Assertions.assertThat(siteDao.findAll())
                .hasSize(2)
                .extracting(Site::getName)
                .contains("Bigcorp Lyon", "New site");
    }

    @Test
    public void findAll() {
        List<Site> sites = siteDao.findAll();
        Assertions.assertThat(sites)
                .hasSize(1)
                .extracting("id", "name")
                .contains(Tuple.tuple("site1", "Bigcorp Lyon"));

    }


    @Test
    public void update() {
        Site site = siteDao.findById("site1");
        Assertions.assertThat(site.getName()).isEqualTo("Bigcorp Lyon");
        site.setName("site updated");
        siteDao.persist(site);
        site = siteDao.findById("site1");
        Assertions.assertThat(site.getName()).isEqualTo("site updated");
    }

    @Test
    public void findById() {
        Site site = siteDao.findById("site1");
        Assertions.assertThat(site.getName()).isEqualTo("Bigcorp Lyon");
    }

    @Test
    public void findByIdShouldReturnNullWhenIdUnknown() {
        Site site = siteDao.findById("unknown");
        Assertions.assertThat(site).isNull();
    }

    @Test
    public void delete() {
        Site newsite = new Site("New site");
        siteDao.persist(newsite);
        Assertions.assertThat(siteDao.findById(newsite.getId())).isNotNull();
        siteDao.delete(newsite);
        Assertions.assertThat(siteDao.findById(newsite.getId())).isNull();
    }

    @Autowired
    private EntityManager entityManager;
    @Test
    public void deleteByIdShouldThrowExceptionWhenIdIsUsedAsForeignKey() {
        Site site = siteDao.findById("c1");
        Assertions
                .assertThatThrownBy(() -> {
                    siteDao.delete(site);
                    entityManager.flush();
                })
                .isExactlyInstanceOf(PersistenceException.class)
                .hasCauseExactlyInstanceOf(ConstraintViolationException.class);
    }
}



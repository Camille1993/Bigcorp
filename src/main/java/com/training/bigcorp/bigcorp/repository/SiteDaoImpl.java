package com.training.bigcorp.bigcorp.repository;



import com.training.bigcorp.bigcorp.model.Captor;
import com.training.bigcorp.bigcorp.model.Site;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
@Transactional
public class SiteDaoImpl implements SiteDao{


    private NamedParameterJdbcTemplate jdbcTemplate;

    public SiteDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Site site) {
    jdbcTemplate.update("insert into SITE(id, name) values (:id ,:name)", new MapSqlParameterSource().addValue("id", site.getId()).addValue("name", site.getName()));
    }

    public void update(Site site) {
        jdbcTemplate.update("update SITE set name = :name where id =:id",
                new MapSqlParameterSource()
                        .addValue("id", site.getId())
                        .addValue("name", site.getName()));
    }

    @Override
    public Site findById(String s) {
        try {
            return jdbcTemplate.queryForObject("Select id, name from SITE where id = :id", new MapSqlParameterSource("id", s), this::siteMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Site> findAll() {
        try {
            return jdbcTemplate.query("select id, name from SITE", this::siteMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    private Site siteMapper(ResultSet rs, int rowNum) throws SQLException {
        Site site = new Site(rs.getString("name"));
        site.setId(rs.getString("id"));
        return site;
    }

    @Override
    public void deleteById(String s) {
        jdbcTemplate.update("DELETE from SITE where id =:id", new MapSqlParameterSource().addValue("id", s));
    }
}


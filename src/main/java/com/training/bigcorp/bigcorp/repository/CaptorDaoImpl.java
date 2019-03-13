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
public class CaptorDaoImpl implements CaptorDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CaptorDaoImpl(org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Captor captor) {
        jdbcTemplate.update("insert into CAPTOR(id, name, site_id) values (:id ,:name, :site_id)",
                new MapSqlParameterSource()
                        .addValue("id", captor.getId())
                        .addValue("name", captor.getName())
                        .addValue("site_id", captor.getSite().getId()));
    }

    public void update(Captor captor) {
        jdbcTemplate.update("update CAPTOR set name = :name where id =:id",
                new MapSqlParameterSource()
                        .addValue("id", captor.getId())
                        .addValue("name", captor.getName()));
    }

    private static String SELECT_WITH_JOIN =
            "SELECT c.id, c.name, c.site_id, s.name as site_name " +
                    "FROM Captor c inner join Site s on c.site_id = s.id ";


    public List<Captor> findAll() {
        try {
            return jdbcTemplate.query(SELECT_WITH_JOIN, this::captorMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Captor findById(String s) {
        try {
            return jdbcTemplate.queryForObject(SELECT_WITH_JOIN +" where c.id = :id", new MapSqlParameterSource("id", s), this::captorMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Captor> findBySiteId(String s) {
        return jdbcTemplate.query("select id, name from CAPTOR where id = :id", new MapSqlParameterSource("id", s), this::captorMapper);

    }

    @Override
    public void deleteById(String s) {
        jdbcTemplate.update("DELETE from CAPTOR where id =:id", new MapSqlParameterSource().addValue("id", s));

    }

    private Captor captorMapper(ResultSet rs, int rowNum) throws SQLException {
        Site site = new Site(rs.getString("site_name"));
        site.setId(rs.getString("site_id"));

        Captor captor = new Captor(rs.getString("name"), site);
        captor.setId(rs.getString("id"));
        return captor;
    }
}

package com.dao;

import com.client.Department;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-store-application.xml")
public class BaseMethodsTest {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void cleanTable(String tableName) {
        String query = "delete from " + tableName;
        namedParameterJdbcTemplate.getJdbcOperations().update(query);
    }

    public int getIdByName (String departmentName) {
        String query = "select * from departments where name = :p_name";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("p_name", departmentName);
        Department department = namedParameterJdbcTemplate.queryForObject(query, sqlParameterSource, new RowMapper<Department>() {
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                Department department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                return department;
            }
        });
        return department.getId();
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }
}
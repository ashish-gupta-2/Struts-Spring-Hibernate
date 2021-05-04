package com.example.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/spring")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/testdb")
    public String testdb() {
        return  jdbcTemplate.query("Select 1 DATA from dual ", new TestRowMapper()).get(0);
    }

}

class TestRowMapper implements RowMapper<String> {

    @Override
    public String mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString("DATA");
    }
}

package com.moetazz.springbootapp.RepositoryLayer;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.moetazz.springbootapp.Model.Alien;

@Repository
public class AlleinDataRepo {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return this.template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien allein) {
        String sql = "INSERT INTO alien (id, name, tech) VALUES (?, ?, ?)";
        int rows = template.update(sql, allein.getId(), allein.getName(), allein.getTech());
        System.out.println(rows + " row/s affected");
    }

    //return actual data
    public List<Alien> findAll() {
        String sql = "SELECT id, name, tech FROM alien";
        
        // RowMapper to map the result set to Alien objects
        RowMapper<Alien> rowMapper = (rs, rowNum) -> {
            Alien alien = new Alien();
            alien.setId(rs.getInt("id"));
            alien.setName(rs.getString("name"));
            alien.setTech(rs.getString("tech"));
            return alien;
        };

        return template.query(sql, rowMapper);
    }

    
}
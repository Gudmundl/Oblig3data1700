package com.example.oblig3data1700;

import com.example.oblig3data1700.BilettLagring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class BilettRepository {

    @Autowired
    private JdbcTemplate db;


    public void lagreBillett(BilettLagring ticketItem) {
        String sql = "INSERT INTO ticketItem (email, phone,  firstName,  lastName,  quantity, film) VALUES(?,?,?,?,?,?)";
        db.update(sql, ticketItem.getEmail(),ticketItem.getPhone(),ticketItem.getFirstName(),ticketItem.getLastName(),ticketItem.getQuantity(),ticketItem.getFilm());
    }

    public List<BilettLagring> hentAlleBilletter(){
        String sql = "SELECT * FROM ticketItem ORDER BY id DESC";
        return db.query(sql, new BeanPropertyRowMapper<>(BilettLagring.class));
    }

    public  void slettAlleBilletter(){
        String sql = "DELETE FROM ticketItem";
        db.update(sql);
    }


}

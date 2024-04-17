package com.example.oblig3data1700;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class bilettRepository {

    @Autowired
    private JdbcTemplate db;


    public void saveTicket(bilettLagring ticketItem) {
        String sql = "INSERT INTO ticketItem (firstName, lastName,  film,  email,  phone, quantity) VALUES(?,?,?,?,?,?)";
        db.update(sql, ticketItem.getFilm(),ticketItem.getEmail(),ticketItem.getFirstName(),ticketItem.getPhone(),ticketItem.getLastName(),ticketItem.getQuantity());
    }

    public List<bilettLagring> hentAlleBilletter(){
        String sql = "SELECT * FROM billett ORDER BY etternavn DESC";
        return db.query(sql, new BeanPropertyRowMapper<>(bilettLagring.class));
    }

    public  void clearAllTickets(){
        String sql = "DELETE FROM bilett";
        db.update(sql);
    }


}

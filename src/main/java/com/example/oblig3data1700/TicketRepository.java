package com.example.oblig3data1700;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;


    public void saveTickets(TicketSaving ticketItem) {
        String sql = "INSERT INTO ticketItem (email, phone,  firstName,  lastName,  quantity, film) VALUES(?,?,?,?,?,?)";
        db.update(sql, ticketItem.getEmail(),ticketItem.getPhone(),ticketItem.getFirstName(),ticketItem.getLastName(),ticketItem.getQuantity(),ticketItem.getFilm());
    }

    public List<TicketSaving>getAllTickets(){
        String sql = "SELECT * FROM ticketItem ORDER BY lastName ASC ";
        return db.query(sql, new BeanPropertyRowMapper<>(TicketSaving.class));
    }

    public  void deleteAllTickets(){
        String sql = "DELETE FROM ticketItem";
        db.update(sql);
    }
    public  void deleteOneTicket(TicketSaving idForDelete){
        String sql = "DELETE FROM ticketItem WHERE id = ?";
        db.update(sql, idForDelete.getId());
    }


}

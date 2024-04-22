package com.example.oblig3data1700;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    TicketRepository rep;

    @PostMapping("/saveTicket")
    public void save(TicketSaving ticketItem)
    {rep.saveTickets(ticketItem);}

    @GetMapping("/getTicketsDB")
    public List<TicketSaving> getTicketList() {
        return  rep.getAllTickets();
    }
    @PostMapping("/deleteAll")
    public void clearTicketList(){rep.deleteAllTickets();}

    @PostMapping("/deleteOne")
    public void deleteOneTicket(TicketSaving idForDelete)
    {rep.deleteOneTicket(idForDelete);}


}

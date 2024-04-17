package com.example.oblig3data1700;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class controller {

    @Autowired
    bilettRepository rep;

    @PostMapping("/lagre")
    public void save(bilettLagring ticketItem)
    {rep.saveTicket(ticketItem);}

    @GetMapping("/hentBiletter")
    public List<bilettLagring> getBilettliste() {
        return  rep.hentAlleBilletter();
    }
    @PostMapping("/slett")
    public void clearForm(){rep.clearAllTickets();}



}

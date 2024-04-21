package com.example.oblig3data1700;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class Controller {

    @Autowired
    BilettRepository rep;

    @PostMapping("/lagre")
    public void save(BilettLagring ticketItem)
    {rep.lagreBillett(ticketItem);}

    @GetMapping("/hentBiletter")
    public List<BilettLagring> getBilettliste() {
        return  rep.hentAlleBilletter();
    }
    @PostMapping("/slett")
    public void clearForm(){rep.slettAlleBilletter();}



}

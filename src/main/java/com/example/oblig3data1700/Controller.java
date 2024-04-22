package com.example.oblig3data1700;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    BilettRepository rep;

    @PostMapping("/lagre")
    public void save(BilettLagring ticketItem)
    {rep.lagreBillett(ticketItem);}

    @GetMapping("/hentBilletter")
    public List<BilettLagring> getBilettliste() {
        return  rep.hentAlleBilletter();
    }
    @PostMapping("/slett")
    public void clearForm(){rep.slettAlleBilletter();}

    @PostMapping("/deleteOne")
    public void deleteStudent(BilettLagring idForDelete)
    {rep.deleteOneTicket(idForDelete);}


}

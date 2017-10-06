package com.bananas.bananas.controllers;

import com.bananas.bananas.application.impl.BananaBoxFacade;
import com.bananas.bananas.domain.model.BananaBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BananaBoxEndPoint {

    private BananaBoxFacade service;

    @Autowired
    public BananaBoxEndPoint(BananaBoxFacade service) {
        this.service = service;
    }

    @GetMapping(value = "/bananabox/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BananaBox findBy(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping(value = "/bananabox", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BananaBox save(@RequestBody BananaBox box) {
        service.save(box);
        System.out.println("Adicionado nova caixa" + box.toString());
        return box;
    }

    @PutMapping(value = "/bananabox/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAll(@RequestBody BananaBox box,
                          @PathVariable String id) {
        service.updateAll(box, id);
    }

    @DeleteMapping(value = "/bananabox/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

package com.test1.demo.clients.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test1.demo.clients.entitys.Factures;
import com.test1.demo.clients.service.ClientsService;


@RestController
@RequestMapping("/facture")
public class ClientsController {
    
    @Autowired
    private ClientsService client;

    @GetMapping("/all")
    public Iterable<Factures> getAll() {
        return client.getAll();
    }

    @PostMapping("/")
    public Factures saveClient(@RequestBody Factures cli) {
        System.out.println(cli);
        return client.saveFactures(cli);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delFacture(@PathVariable final Long id) {
        HttpStatus status = HttpStatus.OK;
        try {
            client.deleteById(id);
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
        }
        return status;
    }

}

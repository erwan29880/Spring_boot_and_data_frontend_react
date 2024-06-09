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

import com.test1.demo.clients.entitys.Clients;
import com.test1.demo.clients.service.ClientsService;


@RestController
@RequestMapping("/facture")
public class ClientsController {
    
    @Autowired
    private ClientsService client;

    @GetMapping("/all")
    public Iterable<Clients> getAll() {
        System.out.println("API : REQUETE GET");
        return client.getAll();
    }

    @PostMapping("/")
    public Clients saveClient(@RequestBody Clients cli) {
        System.out.println("API : REQUETE POST");
        return client.saveClients(cli);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delFacture(@PathVariable final Long id) {
        System.out.println("API : REQUETE DELETE");
        HttpStatus status = HttpStatus.OK;
        try {
            client.deleClients(id);
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
        }
        return status;
    }

}

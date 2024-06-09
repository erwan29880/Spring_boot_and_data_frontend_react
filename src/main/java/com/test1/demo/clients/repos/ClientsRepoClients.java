package com.test1.demo.clients.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test1.demo.clients.entitys.Clients;

/**
 * interface pour gérer les clients
 */
@Repository
public interface ClientsRepoClients extends CrudRepository<Clients, Long> {
}

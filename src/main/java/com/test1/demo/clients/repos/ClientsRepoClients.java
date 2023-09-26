package com.test1.demo.clients.repos;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test1.demo.clients.entitys.Clients;

/**
 * interface pour gérer les clients
 */
@Repository
public interface ClientsRepoClients extends CrudRepository<Clients, Long> {
    Optional<Clients> findByNom(String nom);
    Clients findByClientId(Long id);
    Clients findByNomAndPrenom(String nom, String prenom);
}

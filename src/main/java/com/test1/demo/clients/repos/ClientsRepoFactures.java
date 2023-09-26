package com.test1.demo.clients.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test1.demo.clients.entitys.FacturesWithoutClients;

/**
 * interface pour supprimer une entrée de la table orders sans toucher à la table clients
 */
@Repository
public interface ClientsRepoFactures extends CrudRepository<FacturesWithoutClients, Long> {
}

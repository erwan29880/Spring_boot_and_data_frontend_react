package com.test1.demo.clients.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test1.demo.clients.entitys.Factures;

/**
 * interface facture - client many to one
 * pour les traitements en cascades
 */
@Repository
public interface ClientsRepoFacturesClients extends CrudRepository<Factures, Long> {
}


package com.test1.demo.clients.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="clients")
public class Clients {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="client_id")
    private Long clientId;
    
    private String nom;
    private String prenom;

    public Clients() {}

    public Clients(Long id, String nom, String prenom) {
        this.clientId = id;
        this.nom = nom;
        this.prenom = prenom;
    }


    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
 


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



}

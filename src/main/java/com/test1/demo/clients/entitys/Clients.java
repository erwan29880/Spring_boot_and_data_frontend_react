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
    @Column(name="facture")
    private Long id;
    
    private String nom;
    private String prenom;

    public Clients() {}

    public Clients(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long clientId) {
        this.id = clientId;
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


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            "}";
    }

}

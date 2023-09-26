package com.test1.demo.clients.entitys;

import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;

/**
 * classe pour le relationnel orders - clients
 */
@Entity 
@Table(name="orders")
public class Factures {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long ordersId;

    private String numero;
 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private Clients client3;

    @Transient  
    private String erreur;

    
    public Factures () {}
    
    public Factures (Long id, String numero, Clients client) {
        this.ordersId = id;
        this.numero = numero;
        this.client3 = client;
    }
    
    public Factures(String err) {
        this.erreur = err;
    }
    
    public Clients getClient3() {
        return this.client3;
    }
    
    public void setClient3(Clients client3) {
        this.client3 = client3;
    }
    
    public Long getOrdersId() {
        return this.ordersId;
    }
    
    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }
    
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getErreur() {
        return this.erreur;
    }

    public void setErreur(String erreur) {
        this.erreur = erreur;
    }

    @Override
    public String toString() {
        String st = this.numero + " - "  + this.client3.getNom() + " - " + this.client3.getPrenom() + " - " + this.client3.getClientId();
        return st;
    }

}

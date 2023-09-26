package com.test1.demo.clients.entitys;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;

/**
 * Classe pour supprimer une entrée facture sans toucher à la table clients
 */
@Entity 
@Table(name="orders")
public class FacturesWithoutClients {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long ordersId;

    private String numero;

    @Transient  
    private String erreur;

    
    public FacturesWithoutClients () {}
    
    public FacturesWithoutClients (Long id, String numero) {
        this.ordersId = id;
        this.numero = numero;
    }
    
    public FacturesWithoutClients(String err) {
        this.erreur = err;
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
        return this.numero;
    }

}

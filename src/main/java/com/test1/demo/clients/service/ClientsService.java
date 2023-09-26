package com.test1.demo.clients.service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.demo.clients.entitys.Clients;
import com.test1.demo.clients.entitys.Factures;
import com.test1.demo.clients.repos.ClientsRepoClients;
import com.test1.demo.clients.repos.ClientsRepoFactures;
import com.test1.demo.clients.repos.ClientsRepoFacturesClients;
import com.test1.demo.erreurs.CaracterException;
import com.test1.demo.erreurs.LengthException;

@Service
public class ClientsService {
     
    @Autowired
    private ClientsRepoFacturesClients repo;

    @Autowired
    private ClientsRepoClients repo31;

    @Autowired
    private ClientsRepoFactures repo32;

    public Iterable<Factures> getAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo32.deleteById(id);
    }

    /**
     * Enregistrement en base de donnée d'une nouvelle facture et éventuellement un nouveau client
     * @param client un objet Facture
     * @return un objet facture avec soit l'objet enregistré en bdd, ou l'objet avec une erreur
     */
    public Factures saveFactures(Factures client) {
        Factures fac = null;
        boolean erreurForm = false;

        try {
            // voir si le client renseigné dans le formulaire existe en bdd
            Clients prov = repo31.findByNomAndPrenom(client.getClient3().getNom(), client.getClient3().getPrenom());
            
            // si le client existe déjà dans la table client, on set le client de facture avec ce client
            // sinon cela enregistre une entrée dupliquée dans client
            if (prov != null) {
                client.setClient3(prov);
            }            

            // vérifications length nom et prénom
            // vérifications caractères spéciaux
            checkLength(client.getClient3().getNom());
            checkLength(client.getClient3().getPrenom());
            checkCaracters(client.getClient3().getNom());
            checkCaracters(client.getClient3().getPrenom());
            
            // vérification que la facture est uniquement numérique
            try {
                Integer.parseInt(client.getNumero());
            } catch (Exception e) {
                fac = new Factures("Le format de la facture doit être uniquement numérique");
                erreurForm = true;    
            }

        } catch (LengthException e) {
            fac = new Factures(e.getMessage());
            erreurForm = true;
        } catch (CaracterException e) {
            fac = new Factures(e.getMessage());
            erreurForm = true;
        } catch (Exception e) {
            fac = new Factures("Problème serveur");
            erreurForm = true;
        }

        // si il n'y a pas d'exception levée, enregistrement en base
        if (erreurForm == false) fac = repo.save(client);
        return fac;
    }

    /**
     * Evalue si le chaîne de caractère à une lenght inférieure à 50 caractères
     * @param str 
     * @throws LengthException
     */
    private void checkLength (String str) throws LengthException {
        if (str.length() > 50) {
            throw new LengthException("La longueur du prénom ou du nom doit être inférieure à 50 caractères");
        }
        if (str == "") {
            throw new LengthException("Le nom et le prénom doivent être renseignés");
        }
    }

    /**
     * Evalue la présence de caractères spéciaux dans la chaîne de caractère venant du front-end
     * @param str
     * @throws CaracterException
     */
    private void checkCaracters (String str) throws CaracterException {
        Pattern p = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher m = p.matcher(str);
        boolean b = m.find();
        if (b) throw new CaracterException("Le prénom ou le nom ne doit pas contenir de caractères spéciaux");
    }

}

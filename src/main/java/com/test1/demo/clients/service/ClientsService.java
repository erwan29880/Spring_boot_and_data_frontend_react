package com.test1.demo.clients.service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.demo.clients.entitys.Clients;
import com.test1.demo.clients.repos.ClientsRepoClients;

@Service
public class ClientsService {
   

    @Autowired
    private ClientsRepoClients repo;

    public Iterable<Clients> getAll() {
        return repo.findAll();
    }

    public Clients saveClients(Clients client) {
        Clients c = new Clients();
        
        String nom = client.getNom();
        String prenom = client.getPrenom();

        nom = nullString(nom);
        prenom = nullString(prenom);
        nom = checkLength(nom);
        prenom = checkLength(prenom);
        nom = checkCaracters(nom);
        prenom = checkCaracters(prenom);

        c.setNom(nom);
        c.setPrenom(prenom);

        return repo.save(c);
    }

    
    public boolean deleClients(long id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Evalue si le chaîne de caractère à une lenght inférieure à 50 caractères
     * @param str la chaîne d'entrée
     * @return la chaîne de caractère traitée
     */
    private String checkLength (String str) {
        if (str.length() > 50) {
            return str.substring(0, 50);
        }
        if (str == "") {
            return "XXXXXX";
        }
        return str;
    }

    /**
     * replace les valeurs nulles
     * @param str la chaîne d'entrée
     * @return la chaine de caractères traitée
     */
    private String nullString (String str) {
        return str == null ? "XXXXXX" : str;
    }

    /**
     * Evalue la présence de caractères spéciaux dans la chaîne de caractère venant du front-end
     * @param str la chaîne d'entrée
     * @return la chaîne sans caractères spéciaux
     */
    private String checkCaracters (String str) {
        Pattern p = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

}

package com.test1.demo.erreurs;

/**
 * exception pour les caractères spéciaux dans une chaîne de caractère
 */
public class CaracterException extends Exception {
    public CaracterException(String err) {
        super(err);
    }
}

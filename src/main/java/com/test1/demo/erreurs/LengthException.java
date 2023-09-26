package com.test1.demo.erreurs;

/**
 * exception pour les chaines de caractères trop courtes/longues
 */
public class LengthException extends Exception {
    public LengthException(String err) {
        super(err);
    }
}

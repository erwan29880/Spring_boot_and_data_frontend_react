package com.test1.demo.erreurs;

/**
 * exception controller mysqlUsers
 */
public class NonPresentError extends Exception{
    public NonPresentError(String err) {
        super(err);
    }
}

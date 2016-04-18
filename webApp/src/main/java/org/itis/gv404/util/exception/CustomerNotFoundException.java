package org.itis.gv404.util.exception;


public class CustomerNotFoundException extends BaseException{
    public CustomerNotFoundException(){
        super("Customer not found or delete");
        this.statusCode = 404;
    }
}

package org.itis.gv404.util.exception;

public class OrderNotFoundException extends BaseException{
    public OrderNotFoundException() {
        super("Order not found or delete");
        this.statusCode = 404;
    }
}

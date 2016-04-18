package org.itis.gv404.util.exception;


abstract class BaseException extends Exception{
    int statusCode = 400;

    BaseException(String message){
        super(message);
    }
}

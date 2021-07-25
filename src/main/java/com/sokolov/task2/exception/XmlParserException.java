package com.sokolov.task2.exception;

public class XmlParserException extends Exception{
    public XmlParserException(){

    }

    public XmlParserException(String message){
        super(message);
    }

    public XmlParserException(String message, Throwable cause){
        super(message,cause);
    }

    public XmlParserException(Throwable cause){
        super(cause);
    }
}

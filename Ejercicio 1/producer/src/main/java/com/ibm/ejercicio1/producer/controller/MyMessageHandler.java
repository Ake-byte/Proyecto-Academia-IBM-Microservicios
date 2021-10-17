package com.ibm.ejercicio1.producer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class MyMessageHandler extends RuntimeException{
	public MyMessageHandler(String message) {
        super(message);
    }
}
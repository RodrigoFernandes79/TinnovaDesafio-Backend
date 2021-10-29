package com.tinnova.ex05controleDeVeiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);

	}

}

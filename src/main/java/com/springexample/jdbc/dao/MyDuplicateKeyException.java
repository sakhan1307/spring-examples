package com.springexample.jdbc.dao;

import org.springframework.dao.DataIntegrityViolationException;


public class MyDuplicateKeyException extends DataIntegrityViolationException {

	private static final long serialVersionUID = 1L;

	public MyDuplicateKeyException(String msg) {
        super(msg);
    }

    public MyDuplicateKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

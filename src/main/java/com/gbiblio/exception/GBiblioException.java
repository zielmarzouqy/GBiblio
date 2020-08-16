package com.gbiblio.exception;

public class GBiblioException extends Exception {
	
	public GBiblioException() {
		
	}
	
	public GBiblioException(String msg) {
		super(msg);
	}
	
	public GBiblioException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}

package com.santosh.web.model;

public class Greeting {

    private int id;
    private String message;

    public Greeting() {

    }

    public int getId() {
	return this.id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public String getMessage() {
	return this.message;
    }

    public void setMessage(final String message) {
	this.message = message;
    }

}

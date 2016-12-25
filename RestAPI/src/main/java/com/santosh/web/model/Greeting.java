package com.santosh.web.model;

public class Greeting {

    private Integer id;
    private String message;

    public Greeting() {

    }

    public Integer getId() {
	return this.id;
    }

    public void setId(final Integer id) {
	this.id = id;
    }

    public String getMessage() {
	return this.message;
    }

    public void setMessage(final String message) {
	this.message = message;
    }

}

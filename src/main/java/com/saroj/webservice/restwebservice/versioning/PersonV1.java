package com.saroj.webservice.restwebservice.versioning;

public class PersonV1 {
	public String getName() {
		return name;
	}

	public PersonV1() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	private String name;
	

}

package com.saroj.webservice.restwebservice.versioning;

public class PersonV2 {
	
	public PersonV2() {
		super();
	}
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}



	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	private Name name;
}

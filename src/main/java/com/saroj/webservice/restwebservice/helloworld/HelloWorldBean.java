package com.saroj.webservice.restwebservice.helloworld;

public class HelloWorldBean {
	private String massage;
	public String getMassage() {
		return massage;
	}

	public HelloWorldBean(String massage) {
		this.massage=massage;
	}
	
	@Override
	public String toString() {
		return "HelloWorldBean [massage=" + massage + "]";
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}



}

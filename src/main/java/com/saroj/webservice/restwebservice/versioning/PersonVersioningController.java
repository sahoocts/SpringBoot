package com.saroj.webservice.restwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob charle");
	}

	@GetMapping("v2/person")//URI
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "charle"));
	}
	
	@GetMapping(value="person/param",params="version=1")//Versinong with request parameter
	public PersonV1 paramV1() {
		return new PersonV1("Bob charle");
	}
	
	@GetMapping(value="person/param",params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "charle"));
	}
	
	@GetMapping(value="person/header",headers="X-API-VERSIONING=1")//Versinong with headers parameter
	public PersonV1 headerV1() {
		return new PersonV1("Bob charle");
	}
	
	@GetMapping(value="person/header",headers="X-API-VERSIONING=2")
	public PersonV2 pheaderV2() {
		return new PersonV2(new Name("Bob", "charle"));
	}
	
	@GetMapping(value="person/produces",produces="application/vnd.company.app-v1+json")//Versinong with produces(Accept header Versinong)
	public PersonV1 producesV1() {
		return new PersonV1("Bob charle");
	}
	
	@GetMapping(value="person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "charle"));
	}
}



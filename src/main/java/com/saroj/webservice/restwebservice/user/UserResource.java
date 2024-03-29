package com.saroj.webservice.restwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> getRetrival(){
		return service.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> RetrivelOne(@PathVariable int id) {
		User user= service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		EntityModel<User> entityModel=EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers=linkTo(methodOn(this.getClass()).getRetrival());
		entityModel.add(linkToUsers.withRel("all-users"));
		return entityModel;
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user= service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		//return user;
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createuser(@Valid @RequestBody User user) {
		User savedUser=	service.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()
				).toUri();
		//its return the uri location,if your client asking the location of the 
		//uri then easily you can give 
		return ResponseEntity.created(location).build();
		
	}
}

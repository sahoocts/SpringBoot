package com.saroj.webservice.restwebservice.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;




//@ApiModel(description="NAME SHOULD HAVE 2 CHARACTER ")
//@Table(name="user")
//@Table(name="[user]")


@Entity
@Table(name="userTable")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message="NAME SHOULD HAVE 2 CHARACTER")
	//@ApiModelProperty(notes="NAME SHOULD HAVE 2 CHARACTER ")
	private String name;
	//@Past
	private Date birthDate;
	
	protected User() {
		
	}
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}

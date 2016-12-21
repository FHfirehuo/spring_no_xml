package com.eiecc.fire.spring_4_no_xml.mvc.domain;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Person extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3763538677218067454L;

	private String name;
	
	private int age;
	
	private String email;
	
	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String address;

	public Person() {
		this(null);
	}

	/**
	 * Creates a new user instance.
	 */
	public Person(Long id) {
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

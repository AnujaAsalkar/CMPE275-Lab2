package com.lab2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	@Id
	@Column
	private String id;
	@Column
    private String firstname;
	@Column
    private String lastname;
	@Column
    private String email;
	@Column
    private String address;
	@Column
    private String organization;
	@Column
    private String aboutMyself;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
		
	public Profile(String id, String firstname, String lastname, String email, String address, String organization,
			String aboutMyself) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.organization = organization;
		this.aboutMyself = aboutMyself;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getAboutMyself() {
		return aboutMyself;
	}
	public void setAboutMyself(String aboutMyself) {
		this.aboutMyself = aboutMyself;
	}
	
	


}

package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userInfo")
public class UserInfo {
	
	private ObjectId _id;
	private String email;
	private String name;
	private String password;
	private String contact;
	/**
	 * 
	 */
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param _id
	 * @param email
	 * @param name
	 * @param password
	 * @param contact
	 */
	public UserInfo(ObjectId _id, String email, String name, String password, String contact) {
		super();
		this._id = _id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.contact = contact;
	}
	/**
	 * @return the _id
	 */
	public ObjectId get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

}

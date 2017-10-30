package com.bkhn.model;

public class User {
	String name;
	String pass;
	boolean admin;
	
	public User() {
		admin = false;
	}
	
	public User(String name, String pass, boolean admin) {
		super();
		this.name = name;
		this.pass = pass;
		this.admin = admin;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String toString() {
		return "user:\t"+name + "\t" + pass + "\t" + admin;
	}
}

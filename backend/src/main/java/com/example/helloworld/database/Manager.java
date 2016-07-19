package com.example.helloworld.database;

public class Manager {
	private Integer id;
	private String name;
	private String email;
	private String password;

	/*
	 * public Manager() {
	 * 
	 * }
	 * 
	 * public Manager(String name, String email, String password) { super();
	 * this.name = name; this.email = email; this.password = password; }
	 * 
	 * public Manager(String name, String email) { super(); this.name = name;
	 * this.email = email; }
	 */

	public Manager(Integer id) {
		super();
		this.id = id;
	}

	public Manager(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Manager(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Manager(Integer id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Integer getId() { return id; }
	 * 
	 * 
	 * public void setId(Integer id) { this.id=id; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email=email; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

}

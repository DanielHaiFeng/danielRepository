package com.xa.dt.springboot.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -8717435274177842841L;
	
	private int id;
	
	private String name;
	
	private String password;
	
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + "]";
	}
}

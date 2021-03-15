package com.rbc.demo2.model;

import java.io.Serializable;

// import java.io.Serializable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "user")
public class User implements Serializable{
	// private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id", length = 25)
	private Integer id;

	// @Column(name = "username", length = 50)
	private String userName;

	// @Column(name = "password", length = 800)
	private String password;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public User() {
	}


}


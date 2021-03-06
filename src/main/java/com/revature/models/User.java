package com.revature.models;

import java.util.Objects;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="u_id")
	private int u_id;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="pword", nullable=false)
	private String pword;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	public User() {
		super();
	}

	public User(String userName, String password, String email) {
		super();
		this.username = userName;
		this.pword = password;
		this.email = email;
	}

	public User(int id, String userName, String password, String email) {
		super();
		this.u_id = id;
		this.username = userName;
		this.pword = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + u_id + ", username=" + username + ", pword=" + pword + ", email=" + email + "]";
	}

	public int getId() {
		return u_id;
	}

	public void setId(int id) {
		this.u_id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, u_id, pword, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && u_id == other.u_id && Objects.equals(pword, other.pword)
				&& Objects.equals(username, other.username);
	}
	
	
	
}

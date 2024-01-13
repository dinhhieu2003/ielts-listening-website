package com.listening_ielts.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 454678833526883812L;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private int role;
	
	@OneToMany(mappedBy = "User", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ChiTietBaiLam> listChiTietBaiLam;

	public User(String username, String password, String email, int role, List<ChiTietBaiLam> listChiTietBaiLam) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.listChiTietBaiLam = listChiTietBaiLam;
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<ChiTietBaiLam> getListChiTietBaiLam() {
		return listChiTietBaiLam;
	}

	public void setListChiTietBaiLam(List<ChiTietBaiLam> listChiTietBaiLam) {
		this.listChiTietBaiLam = listChiTietBaiLam;
	}

	
}

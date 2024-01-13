package com.listening_ielts.entity;

import java.io.Serializable;
import java.util.Objects;


public class ChiTietBaiLamID implements Serializable{

	private static final long serialVersionUID = 1L;

	private String User;

	private int DeThi;

	public ChiTietBaiLamID(String user, int deThi) {
		super();
		User = user;
		DeThi = deThi;
	}

	public ChiTietBaiLamID() {
		super();
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public int getDeThi() {
		return DeThi;
	}

	public void setDeThi(int deThi) {
		DeThi = deThi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DeThi, User);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietBaiLamID other = (ChiTietBaiLamID) obj;
		return DeThi == other.DeThi && Objects.equals(User, other.User);
	}

	
	
}

package com.listening_ielts.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chitietlambai")
@IdClass (ChiTietBaiLamID.class)
public class ChiTietBaiLam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date NgayLam;
	private Time ThoiGianLam;
	private int KetQua;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private User User;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "MaDeThi")
	private DeThi DeThi;

	public ChiTietBaiLam(Date ngayLam, Time thoiGianLam, int ketQua, com.listening_ielts.entity.User user,
			com.listening_ielts.entity.DeThi deThi) {
		super();
		NgayLam = ngayLam;
		ThoiGianLam = thoiGianLam;
		KetQua = ketQua;
		User = user;
		DeThi = deThi;
	}

	public ChiTietBaiLam() {
		super();
	}

	public Date getNgayLam() {
		return NgayLam;
	}

	public void setNgayLam(Date ngayLam) {
		NgayLam = ngayLam;
	}

	public Time getThoiGianLam() {
		return ThoiGianLam;
	}

	public void setThoiGianLam(Time thoiGianLam) {
		ThoiGianLam = thoiGianLam;
	}

	public int getKetQua() {
		return KetQua;
	}

	public void setKetQua(int ketQua) {
		KetQua = ketQua;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public DeThi getDeThi() {
		return DeThi;
	}

	public void setDeThi(DeThi deThi) {
		DeThi = deThi;
	}

	
}

package com.listening_ielts.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "loaicauhoi")
public class LoaiCauHoi implements Serializable{

	private static final long serialVersionUID = -888879007029769765L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaLoai")
	private int MaLoai;
	
	@Column(name = "TenLoai")
	private String TenLoai;
	
	@OneToMany(mappedBy = "LoaiCauHoi", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CauHoi> listCauHoi;

	public LoaiCauHoi(int maLoai, String tenLoai, List<CauHoi> listCauHoi) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
		this.listCauHoi = listCauHoi;
	}

	public LoaiCauHoi() {
		super();
	}

	public int getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(int maLoai) {
		MaLoai = maLoai;
	}

	public String getTenLoai() {
		return TenLoai;
	}

	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

	public List<CauHoi> getListCauHoi() {
		return listCauHoi;
	}

	public void setListCauHoi(List<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}

	
}

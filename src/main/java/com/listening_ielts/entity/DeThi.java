package com.listening_ielts.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dethi")
public class DeThi implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaDeThi;
	
	@Column(columnDefinition = "varchar(255)")
	private String TenDeThi;

	@ManyToOne
	@JoinColumn(name = "MaBoDe")
	private BoDe BoDe;
	
	@OneToMany(mappedBy = "DeThi",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Part> listPart;
	
	@OneToMany(mappedBy = "DeThi",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CauHoi> listCauHoi;

	public DeThi(int maDeThi, String tenDeThi, com.listening_ielts.entity.BoDe boDe, List<Part> listPart,
			List<CauHoi> listCauHoi) {
		super();
		MaDeThi = maDeThi;
		TenDeThi = tenDeThi;
		BoDe = boDe;
		this.listPart = listPart;
		this.listCauHoi = listCauHoi;
	}

	public DeThi() {
		super();
	}

	public int getMaDeThi() {
		return MaDeThi;
	}

	public void setMaDeThi(int maDeThi) {
		MaDeThi = maDeThi;
	}

	public String getTenDeThi() {
		return TenDeThi;
	}

	public void setTenDeThi(String tenDeThi) {
		TenDeThi = tenDeThi;
	}

	public BoDe getBoDe() {
		return BoDe;
	}

	public void setBoDe(BoDe boDe) {
		BoDe = boDe;
	}

	public List<Part> getListPart() {
		return listPart;
	}

	public void setListPart(List<Part> listPart) {
		this.listPart = listPart;
	}

	public List<CauHoi> getListCauHoi() {
		return listCauHoi;
	}

	public void setListCauHoi(List<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}
	
	
	
}

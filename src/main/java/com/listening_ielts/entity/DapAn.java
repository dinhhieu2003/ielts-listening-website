package com.listening_ielts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dapan")
public class DapAn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaDapAn;
	
	@Column(columnDefinition = "varchar(2000)")
	private String NoiDungDapAn;
	
	@ManyToOne
	@JoinColumn(name = "MaCauHoi")
	private CauHoi CauHoi;
	
	private Boolean ChanTri;

	public DapAn(int maDapAn, String noiDungDapAn, com.listening_ielts.entity.CauHoi cauHoi, Boolean chanTri) {
		super();
		MaDapAn = maDapAn;
		NoiDungDapAn = noiDungDapAn;
		CauHoi = cauHoi;
		ChanTri = chanTri;
	}

	public DapAn() {
		super();
	}

	public int getMaDapAn() {
		return MaDapAn;
	}

	public void setMaDapAn(int maDapAn) {
		MaDapAn = maDapAn;
	}

	public String getNoiDungDapAn() {
		return NoiDungDapAn;
	}

	public void setNoiDungDapAn(String noiDungDapAn) {
		NoiDungDapAn = noiDungDapAn;
	}

	public CauHoi getCauHoi() {
		return CauHoi;
	}

	public void setCauHoi(CauHoi cauHoi) {
		CauHoi = cauHoi;
	}

	public Boolean getChanTri() {
		return ChanTri;
	}

	public void setChanTri(Boolean chanTri) {
		ChanTri = chanTri;
	}
	
	
}

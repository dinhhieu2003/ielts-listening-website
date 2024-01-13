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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bode")
public class BoDe implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaBoDe;
	
	@Column(columnDefinition = "varchar(1000)")
	private String TenBoDe;
	
	@OneToMany(mappedBy = "BoDe",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DeThi> listDeThi;

	public BoDe(int maBoDe, String tenBoDe, List<DeThi> listDeThi) {
		super();
		MaBoDe = maBoDe;
		TenBoDe = tenBoDe;
		this.listDeThi = listDeThi;
	}

	public BoDe() {
		super();
	}

	public int getMaBoDe() {
		return MaBoDe;
	}

	public void setMaBoDe(int maBoDe) {
		MaBoDe = maBoDe;
	}

	public String getTenBoDe() {
		return TenBoDe;
	}

	public void setTenBoDe(String tenBoDe) {
		TenBoDe = tenBoDe;
	}

	public List<DeThi> getListDeThi() {
		return listDeThi;
	}

	public void setListDeThi(List<DeThi> listDeThi) {
		this.listDeThi = listDeThi;
	}
	
	
}

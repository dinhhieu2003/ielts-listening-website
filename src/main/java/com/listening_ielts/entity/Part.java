package com.listening_ielts.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "part")
public class Part implements Serializable{

	private static final long serialVersionUID = -1010295708056443137L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaPart")
	private int MaPart;
	
	@Column(name = "SoHieuPart")
	private int SoHieuPart;
	
	@Column(name = "SoCauHoi")
	private int SoCauHoi;
	
	@Column(name = "Audio")
	private String Audio;
	
	@OneToMany(mappedBy = "Part", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CauHoi> listCauHoi;
	
	@ManyToOne
	@JoinColumn(name = "MaDeThi")
	private DeThi DeThi;

	public Part(int maPart, int soHieuPart, int soCauHoi, String audio, List<CauHoi> listCauHoi,
			com.listening_ielts.entity.DeThi deThi) {
		super();
		MaPart = maPart;
		SoHieuPart = soHieuPart;
		SoCauHoi = soCauHoi;
		Audio = audio;
		this.listCauHoi = listCauHoi;
		DeThi = deThi;
	}

	public Part() {
		super();
	}

	public int getMaPart() {
		return MaPart;
	}

	public void setMaPart(int maPart) {
		MaPart = maPart;
	}

	public int getSoHieuPart() {
		return SoHieuPart;
	}

	public void setSoHieuPart(int soHieuPart) {
		SoHieuPart = soHieuPart;
	}

	public int getSoCauHoi() {
		return SoCauHoi;
	}

	public void setSoCauHoi(int soCauHoi) {
		SoCauHoi = soCauHoi;
	}

	public String getAudio() {
		return Audio;
	}

	public void setAudio(String audio) {
		Audio = audio;
	}

	public List<CauHoi> getListCauHoi() {
		return listCauHoi;
	}

	public void setListCauHoi(List<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}

	public DeThi getDeThi() {
		return DeThi;
	}

	public void setDeThi(DeThi deThi) {
		DeThi = deThi;
	}

	
	
}

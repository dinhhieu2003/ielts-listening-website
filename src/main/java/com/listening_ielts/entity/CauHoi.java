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
@Table(name="cauhoi")
public class CauHoi implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaCauHoi;
	
	@Column(columnDefinition = "varchar(2000)")
	private String NoiDungCauHoi;
	
	@Column(columnDefinition = "varchar(2000)")
	private String AnhCauHoi;
	
	@ManyToOne
	@JoinColumn(name = "MaDeThi")
	private DeThi DeThi;
	
	@Column(columnDefinition = "varchar(3000)")
	private String GiaiThich;
	
	@ManyToOne
	@JoinColumn(name = "MaPart")
	private Part Part;
	
	@ManyToOne
	@JoinColumn(name = "MaLoaiCauHoi")
	private LoaiCauHoi LoaiCauHoi;
	
	@OneToMany(mappedBy = "CauHoi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DapAn> listDapAn;

	public CauHoi(int maCauHoi, String noiDungCauHoi, String anhCauHoi, com.listening_ielts.entity.DeThi deThi,
			String giaiThich, com.listening_ielts.entity.Part part, com.listening_ielts.entity.LoaiCauHoi loaiCauHoi,
			List<DapAn> listDapAn) {
		super();
		MaCauHoi = maCauHoi;
		NoiDungCauHoi = noiDungCauHoi;
		AnhCauHoi = anhCauHoi;
		DeThi = deThi;
		GiaiThich = giaiThich;
		Part = part;
		LoaiCauHoi = loaiCauHoi;
		this.listDapAn = listDapAn;
	}

	public CauHoi() {
		super();
	}

	public int getMaCauHoi() {
		return MaCauHoi;
	}

	public void setMaCauHoi(int maCauHoi) {
		MaCauHoi = maCauHoi;
	}

	public String getNoiDungCauHoi() {
		return NoiDungCauHoi;
	}

	public void setNoiDungCauHoi(String noiDungCauHoi) {
		NoiDungCauHoi = noiDungCauHoi;
	}

	public DeThi getDeThi() {
		return DeThi;
	}

	public void setDeThi(DeThi deThi) {
		DeThi = deThi;
	}

	public String getGiaiThich() {
		return GiaiThich;
	}

	public void setGiaiThich(String giaiThich) {
		GiaiThich = giaiThich;
	}

	public String getAnhCauHoi() {
		return AnhCauHoi;
	}

	public void setAnhCauHoi(String anhCauHoi) {
		AnhCauHoi = anhCauHoi;
	}

	public Part getPart() {
		return Part;
	}

	public void setPart(Part part) {
		Part = part;
	}

	public LoaiCauHoi getLoaiCauHoi() {
		return LoaiCauHoi;
	}

	public void setLoaiCauHoi(LoaiCauHoi loaiCauHoi) {
		LoaiCauHoi = loaiCauHoi;
	}

	public List<DapAn> getListDapAn() {
		return listDapAn;
	}

	public void setListDapAn(List<DapAn> listDapAn) {
		this.listDapAn = listDapAn;
	}

	
}

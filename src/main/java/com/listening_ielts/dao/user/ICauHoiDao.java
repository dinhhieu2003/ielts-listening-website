package com.listening_ielts.dao.user;

import java.util.List;

import com.listening_ielts.entity.CauHoi;

public interface ICauHoiDao {

	List <CauHoi> findCauHoiByMaDeThi(int madethi);
	List <CauHoi> findCauHoiByLoaiCauHoiAndMaDeThi(int loaicauhoi, int madethi);
	List <CauHoi> findCauHoiByMaPartAndMaDeThi(int mapart, int madethi);
	void insertCauHoi (CauHoi cauhoi);
	void modifyCauHoi (CauHoi cauhoi);
	void deleteCauHoi (int macauhoi) throws Exception;
}

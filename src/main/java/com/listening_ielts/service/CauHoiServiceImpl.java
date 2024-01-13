package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.dao.user.CauHoiDaoImpl;
import com.listening_ielts.dao.user.ICauHoiDao;
import com.listening_ielts.entity.CauHoi;

public class CauHoiServiceImpl implements ICauHoiService{

	ICauHoiDao cauhoiDao = new CauHoiDaoImpl();
	@Override
	public List<CauHoi> findCauHoiByMaDeThi(int madethi) {
		return cauhoiDao.findCauHoiByMaDeThi(madethi);
	}

	@Override
	public List<CauHoi> findCauHoiByLoaiCauHoiAndMaDeThi(int loaicauhoi, int madethi) {
		return cauhoiDao.findCauHoiByLoaiCauHoiAndMaDeThi(loaicauhoi, madethi);
	}

	@Override
	public List<CauHoi> findCauHoiByMaPartAndMaDeThi(int mapart, int madethi) {
		return cauhoiDao.findCauHoiByMaPartAndMaDeThi(mapart, madethi);
	}

	@Override
	public void insertCauHoi(CauHoi cauhoi) {
		cauhoiDao.insertCauHoi(cauhoi);
	}

	@Override
	public void modifyCauHoi(CauHoi cauhoi) {
		cauhoiDao.modifyCauHoi(cauhoi);
	}

	@Override
	public void deleteCauHoi(int macauhoi) throws Exception {
		cauhoiDao.deleteCauHoi(macauhoi);
	}

}

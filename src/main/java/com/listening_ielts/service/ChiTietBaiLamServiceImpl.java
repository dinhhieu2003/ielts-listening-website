package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.dao.user.ChiTietBaiLamDaoImpl;
import com.listening_ielts.dao.user.IChiTietBaiLamDao;
import com.listening_ielts.entity.ChiTietBaiLam;

public class ChiTietBaiLamServiceImpl implements IChiTietBaiLamService{

	IChiTietBaiLamDao chitietbailamDao = new ChiTietBaiLamDaoImpl();
	@Override
	public void insertChiTietBaiLam(ChiTietBaiLam chitietbailam) {
		chitietbailamDao.insertChiTietBaiLam(chitietbailam);
	}

	@Override
	public void modifyChiTietBaiLam(ChiTietBaiLam chitietbailam) {
		chitietbailamDao.modifyChiTietBaiLam(chitietbailam);
	}

	@Override
	public void deleteChiTietBaiLam(int idchitietbailam) throws Exception {
		chitietbailamDao.deleteChiTietBaiLam(idchitietbailam);
	}

	@Override
	public List<ChiTietBaiLam> findChiTietBaiLamTheoUsername(String username) {
		return chitietbailamDao.findChiTietBaiLamTheoUsername(username);
	}

	@Override
	public ChiTietBaiLam findChiTietBaiLamTheoUsernameVaMaDeThi(String username, int madethi) {
		return chitietbailamDao.findChiTietBaiLamTheoUsernameVaMaDeThi(username, madethi);
	}

}

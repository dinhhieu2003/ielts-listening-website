package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.dao.user.DapAnDaoImpl;
import com.listening_ielts.dao.user.IDapAnDao;
import com.listening_ielts.entity.DapAn;

public class DapAnServiceImpl implements IDapAnService{

	IDapAnDao dapanDao = new DapAnDaoImpl();
	@Override
	public List<DapAn> findDapAnTheoMaCauHoi(int macauhoi) {
		return dapanDao.findDapAnTheoMaCauHoi(macauhoi);
	}

	@Override
	public void insertDapAn(DapAn dapan) {
		dapanDao.insertDapAn(dapan);
	}

	@Override
	public void modifyDapAn(DapAn dapan) {
		dapanDao.modifyDapAn(dapan);
		
	}

	@Override
	public void deleteDapAn(int madapan) throws Exception {
		dapanDao.deleteDapAn(madapan);
	}

}

package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.dao.user.DeThiDaoImpl;
import com.listening_ielts.dao.user.IDeThiDao;
import com.listening_ielts.entity.DeThi;

public class DeThiServiceImpl implements IDeThiService{

	IDeThiDao dethiDao = new DeThiDaoImpl();
	@Override
	public List<DeThi> findAllDeThi() {
		return dethiDao.findAllDeThi();
	}

	@Override
	public List<DeThi> findDeThiTheoMaBoDe(int mabode) {
		return dethiDao.findDeThiTheoMaBoDe(mabode);
	}

	@Override
	public boolean insertDeThi(DeThi dethi) {
		return dethiDao.insertDeThi(dethi);
	}

	@Override
	public void modifyDeThi(DeThi dethi) {
		dethiDao.modifyDeThi(dethi);
	}

	@Override
	public boolean deleteDeThi(int madethi) throws Exception {
		return dethiDao.deleteDeThi(madethi);
	}

	@Override
	public DeThi getLastDeThi() {
		return dethiDao.getLastDeThi();
	}

}

package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.dao.user.BoDeDaoImpl;
import com.listening_ielts.dao.user.IBoDeDao;
import com.listening_ielts.entity.BoDe;

public class BoDeServiceImpl implements IBoDeService{

	IBoDeDao bodeDao = new BoDeDaoImpl();
	@Override
	public List<BoDe> findAllBoDe() {
		return bodeDao.findAllBoDe();
	}

	@Override
	public List<BoDe> findBoDeTheoTrang(int page, int pagesize) {
		return bodeDao.findBoDeTheoTrang(page, pagesize);
	}

	@Override
	public boolean insertBoDe(BoDe bode) {
		return bodeDao.insertBoDe(bode);
	}

	@Override
	public boolean modifyBoDe(BoDe bode) {
		return bodeDao.modifyBoDe(bode);
	}

	@Override
	public boolean deleteBoDe(int mabode) throws Exception {
		return bodeDao.deleteBoDe(mabode);
	}

	@Override
	public BoDe findBoDeTheoMaBoDe(int maBoDe) {
		return bodeDao.findBoDeTheoMaBoDe(maBoDe);
	}

}

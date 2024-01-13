package com.listening_ielts.service;

import com.listening_ielts.dao.user.IPartDao;
import com.listening_ielts.dao.user.PartDaoImpl;
import com.listening_ielts.entity.Part;

public class PartService implements IPartService{

	IPartDao partDao = new PartDaoImpl();
	@Override
	public boolean insertPart(Part part) {
		return partDao.insertPart(part);
	}
	@Override
	public Part findMaPart(int maDeThi, int partNum) {
		return partDao.findMaPart(maDeThi, partNum);
	}

}

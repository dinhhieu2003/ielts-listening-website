package com.listening_ielts.dao.user;

import java.util.List;

import com.listening_ielts.entity.DeThi;

public interface IDeThiDao {
	List <DeThi> findAllDeThi();
	List <DeThi> findDeThiTheoMaBoDe(int mabode);
	boolean insertDeThi(DeThi dethi);
	void modifyDeThi(DeThi dethi);
	boolean deleteDeThi(int madethi) throws Exception;
	DeThi getLastDeThi();
}

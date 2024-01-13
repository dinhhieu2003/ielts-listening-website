package com.listening_ielts.dao.user;

import java.util.List;

import com.listening_ielts.entity.DapAn;

public interface IDapAnDao {
	List<DapAn> findDapAnTheoMaCauHoi(int macauhoi);
	void insertDapAn(DapAn dapan);
	void modifyDapAn(DapAn dapan);
	void deleteDapAn(int madapan) throws Exception;
}

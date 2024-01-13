package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.entity.DapAn;

public interface IDapAnService {
	List<DapAn> findDapAnTheoMaCauHoi(int macauhoi);
	void insertDapAn(DapAn dapan);
	void modifyDapAn(DapAn dapan);
	void deleteDapAn(int madapan) throws Exception;
}

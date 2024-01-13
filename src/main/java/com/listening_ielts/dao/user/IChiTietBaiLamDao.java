package com.listening_ielts.dao.user;

import java.util.List;

import com.listening_ielts.entity.ChiTietBaiLam;

public interface IChiTietBaiLamDao {
	void insertChiTietBaiLam (ChiTietBaiLam chitietbailam);
	void modifyChiTietBaiLam (ChiTietBaiLam chitietbailam);
	void deleteChiTietBaiLam (int idchitietbailam) throws Exception;
	List<ChiTietBaiLam> findChiTietBaiLamTheoUsername(String username);
	ChiTietBaiLam findChiTietBaiLamTheoUsernameVaMaDeThi (String username, int madethi);
}

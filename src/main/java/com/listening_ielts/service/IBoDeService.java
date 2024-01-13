package com.listening_ielts.service;

import java.util.List;

import com.listening_ielts.entity.BoDe;

public interface IBoDeService {
	List <BoDe> findAllBoDe();
	List <BoDe> findBoDeTheoTrang(int page, int pagesize);
	boolean insertBoDe(BoDe bode);
	boolean modifyBoDe(BoDe bode);
	boolean deleteBoDe(int mabode) throws Exception;
	BoDe findBoDeTheoMaBoDe(int maBoDe);
}

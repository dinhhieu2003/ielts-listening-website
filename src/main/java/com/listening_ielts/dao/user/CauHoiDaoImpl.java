package com.listening_ielts.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.listening_ielts.entity.CauHoi;
import com.listening_ielts.entity.ChiTietBaiLam;


public class CauHoiDaoImpl implements ICauHoiDao{

	@Override
	public List<CauHoi> findCauHoiByMaDeThi(int madethi) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM CauHoi c WHERE c.DeThi.MaDeThi = :madethi";

		TypedQuery<CauHoi> query= enma.createQuery(jpql, CauHoi.class);
		query.setParameter("madethi", madethi);
		return query.getResultList();
	}

	@Override
	public List<CauHoi> findCauHoiByLoaiCauHoiAndMaDeThi(int loaicauhoi, int madethi) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM CauHoi c WHERE c.DeThi.MaDeThi = :madethi AND c.LoaiCauHoi.MaLoaiCauHoi = :loaicauhoi";

		TypedQuery<CauHoi> query= enma.createQuery(jpql, CauHoi.class);
		query.setParameter("madethi", madethi);
		query.setParameter("loaicauhoi", loaicauhoi);
		return query.getResultList();
	}

	@Override
	public List<CauHoi> findCauHoiByMaPartAndMaDeThi(int mapart, int madethi) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM CauHoi c WHERE c.DeThi.MaDeThi = :madethi AND c.Part.MaPart = :mapart";

		TypedQuery<CauHoi> query= enma.createQuery(jpql, CauHoi.class);
		query.setParameter("madethi", madethi);
		query.setParameter("mapart", mapart);
		return query.getResultList();
	}

	@Override
	public void insertCauHoi(CauHoi cauhoi) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			enma.persist(cauhoi);
			trans.commit();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
			throw e;
		} 
		finally 
		{
			enma.close();
		}
	}

	@Override
	public void modifyCauHoi(CauHoi cauhoi) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			enma.merge(cauhoi);
			trans.commit();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally 
		{
			enma.close();
		}
	}

	@Override
	public void deleteCauHoi(int macauhoi) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			CauHoi cauhoi = enma.find(CauHoi.class, macauhoi);
			if(cauhoi != null) 
			{
				enma.remove(cauhoi);
			} 
			else 
			{
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally 
		{
			enma.close();
		}
	}

}

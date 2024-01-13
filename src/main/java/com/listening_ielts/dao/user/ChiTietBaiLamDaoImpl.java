package com.listening_ielts.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.listening_ielts.entity.ChiTietBaiLam;


public class ChiTietBaiLamDaoImpl implements IChiTietBaiLamDao{

	@Override
	public void insertChiTietBaiLam(ChiTietBaiLam chitietbailam) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			enma.persist(chitietbailam);
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
	public void modifyChiTietBaiLam(ChiTietBaiLam chitietbailam) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			enma.merge(chitietbailam);
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
	public void deleteChiTietBaiLam(int idchitietbailam) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			ChiTietBaiLam chitietbailam = enma.find(ChiTietBaiLam.class, idchitietbailam);
			if(chitietbailam != null) 
			{
				enma.remove(chitietbailam);
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

	@Override
	public List<ChiTietBaiLam> findChiTietBaiLamTheoUsername(String username) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM ChiTietBaiLam c WHERE c.username = :username";

		TypedQuery<ChiTietBaiLam> query= enma.createQuery(jpql, ChiTietBaiLam.class);		
		query.setParameter("username", username);
		
		return query.getResultList();
	}

	@Override
	public ChiTietBaiLam findChiTietBaiLamTheoUsernameVaMaDeThi(String username, int madethi) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM ChiTietBaiLam c WHERE c.username = :username AND c.MaDeThi = :madethi";
		
		TypedQuery<ChiTietBaiLam> query = enma.createQuery(jpql, ChiTietBaiLam.class);
	    query.setParameter("username", username);
	    query.setParameter("madethi", madethi);
	    
	    List<ChiTietBaiLam> resultList = query.getResultList();

	    return resultList.isEmpty() ? null : resultList.get(0);

	}

}

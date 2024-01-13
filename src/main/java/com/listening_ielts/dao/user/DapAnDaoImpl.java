package com.listening_ielts.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.listening_ielts.entity.DapAn;

public class DapAnDaoImpl implements IDapAnDao{

	@Override
	public List<DapAn> findDapAnTheoMaCauHoi(int macauhoi) 
	{
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM DapAn c WHERE c.CauHoi.MaCauHoi = :macauhoi";

		TypedQuery<DapAn> query= enma.createQuery(jpql, DapAn.class);
		query.setParameter("macauhoi", macauhoi);
		
		return query.getResultList();
	}

	@Override
	public void insertDapAn(DapAn dapan) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			enma.persist(dapan);
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
	public void modifyDapAn(DapAn dapan) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			enma.merge(dapan);
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
	public void deleteDapAn(int madapan) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			DapAn dapan = enma.find(DapAn.class, madapan);
			if(dapan != null) 
			{
				enma.remove(dapan);
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

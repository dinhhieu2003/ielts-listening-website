package com.listening_ielts.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.listening_ielts.entity.DeThi;

public class DeThiDaoImpl implements IDeThiDao{

	@Override
	public List<DeThi> findAllDeThi() {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM DeThi c";

		TypedQuery<DeThi> query= enma.createQuery(jpql, DeThi.class);
		return query.getResultList();
	}

	@Override
	public List<DeThi> findDeThiTheoMaBoDe(int mabode) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM DeThi c WHERE c.BoDe.MaBoDe = :mabode";

		TypedQuery<DeThi> query= enma.createQuery(jpql, DeThi.class);
		query.setParameter("mabode", mabode);
		return query.getResultList();
	}

	@Override
	public boolean insertDeThi(DeThi dethi) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		boolean res = false;
		try 
		{
			trans.begin();
			enma.persist(dethi);
			trans.commit();
			res = true;
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
		return res;
	}

	@Override
	public void modifyDeThi(DeThi dethi) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try 
		{
			trans.begin();
			enma.merge(dethi);
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
	public boolean deleteDeThi(int madethi) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		boolean res = false;
		try 
		{
			trans.begin();
			DeThi dethi = enma.find(DeThi.class, madethi);
			if(dethi != null) 
			{
				enma.remove(dethi);
				res = true;
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
		return res;
	}

	@Override
	public DeThi getLastDeThi() {
		EntityManager em = JPAConfig.getEntityManager();
		DeThi res = null;
		try {
			String jpql = "select d from DeThi d order by d.MaDeThi desc";
			TypedQuery<DeThi> query = em.createQuery(jpql, DeThi.class);
			query.setMaxResults(1);
			List<DeThi> resultList = query.getResultList();
	        if (!resultList.isEmpty()) {
	        	res = resultList.get(0);
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return res;	
	}
}

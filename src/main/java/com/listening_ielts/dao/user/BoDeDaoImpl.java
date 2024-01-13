package com.listening_ielts.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.listening_ielts.entity.BoDe;

public class BoDeDaoImpl implements IBoDeDao{

	@Override
	public List<BoDe> findAllBoDe() {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM BoDe c";

		TypedQuery<BoDe> query= enma.createQuery(jpql, BoDe.class);
		return query.getResultList();
	}
	
	@Override
	public List<BoDe> findBoDeTheoTrang(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM BoDe c";

		TypedQuery<BoDe> query= enma.createQuery(jpql, BoDe.class);

		query.setFirstResult(page*pagesize);

		query.setMaxResults(pagesize);

		return query.getResultList();
	}

	@Override
	public boolean insertBoDe(BoDe bode) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		boolean res = false;
		try 
		{
			trans.begin();
			enma.persist(bode);
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
	public boolean modifyBoDe(BoDe bode) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		boolean res = false;
		try 
		{
			trans.begin();
			enma.merge(bode);
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
	public boolean deleteBoDe(int mabode) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		boolean res = false;
		try 
		{
			trans.begin();
			BoDe bode = enma.find(BoDe.class, mabode);
			if(bode != null) 
			{
				enma.remove(bode);				
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
	public BoDe findBoDeTheoMaBoDe(int maBoDe) {
		EntityManager em = JPAConfig.getEntityManager();
		BoDe res = null;
		try {
			
			res = em.find(BoDe.class, maBoDe);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return res;
	}
}

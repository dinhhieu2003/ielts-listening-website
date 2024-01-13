package com.listening_ielts.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.listening_ielts.entity.Part;

public class PartDaoImpl implements IPartDao{

	@Override
	public boolean insertPart(Part part) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		boolean res = false;
		try 
		{
			trans.begin();
			enma.persist(part);
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
	public Part findMaPart(int maDeThi, int partNum) {
		Part res = null;
		EntityManager em = JPAConfig.getEntityManager();
		try {
			String jpql = "select p from Part p where p.SoHieuPart = :partNum and p.DeThi.MaDeThi = :maDeThi";
			TypedQuery<Part> query = em.createQuery(jpql, Part.class);
	        query.setParameter("partNum", partNum);
	        query.setParameter("maDeThi", maDeThi);

	        List<Part> resultList = query.getResultList();

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

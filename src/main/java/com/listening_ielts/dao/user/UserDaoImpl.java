package com.listening_ielts.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;

import com.listening_ielts.entity.DeThi;
import com.listening_ielts.entity.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public List<User> findAllUser() {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM User c";

		TypedQuery<User> query = enma.createQuery(jpql, User.class);
		return query.getResultList();
	}

	@Override
	public void insertUser(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void modifyUser(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(user);
			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void deleteUser(int username) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User user = enma.find(User.class, username);
			if (user != null) {
				enma.remove(user);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public User checkUser(String username, String password) {
		EntityManager em = JPAConfig.getEntityManager();
		List<User> users = null;
		User user = null;
		try {
			// Create query
			String sqlString = "select u from User u where u.username = :username and u.password = :password";

			TypedQuery<User> query = em.createQuery(sqlString, User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);

			users = query.getResultList();
			if (!users.isEmpty()) {
				user = users.get(0);
				System.out.println(user.getEmail());
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	public boolean isExistEmail(String email) {
		EntityManager em = JPAConfig.getEntityManager();
		List<String> emails = null;
		try {
			// Create query
			String sqlString = "select u.email from User u where u.email = :email";

			TypedQuery<String> query = em.createQuery(sqlString, String.class);
			query.setParameter("email", email);

			emails = query.getResultList();
			if (!emails.isEmpty()) {
				System.out.println("Exist email");
				return true;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public boolean isExistUserName(String username) {
		EntityManager em = JPAConfig.getEntityManager();
		List<String> usernames = null;
		try {
			// Create query
			String sqlString = "select u.username from User u where u.username = :username";
			TypedQuery<String> query = em.createQuery(sqlString, String.class);
			query.setParameter("username", username);
			usernames = query.getResultList();
			if (!usernames.isEmpty()) {
				System.out.println("Exist username");
				return true;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public int countUser() {
		EntityManager em = JPAConfig.getEntityManager();
		int count = 0;
		try {
			String sqlString = "select count(u) from User u where u.role = 0";
			Query query = (Query) em.createQuery(sqlString);
			Long res = (Long) query.getSingleResult();
			count = res.intValue();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return count;
	}

	@Override
	public List<User> getListUserPage(int start, int count) {
		--start;
		EntityManager em = JPAConfig.getEntityManager();
		List<User> users = null;
		try {
			String jpqlString = "SELECT u FROM User u WHERE u.role = 0";
			TypedQuery<User> query = em.createQuery(jpqlString, User.class);
			query.setFirstResult(start);
			query.setMaxResults(count);
			users = query.getResultList();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return users;
	}

	@Override
	public boolean banUser(String username) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean res = false;
		try {
			trans.begin();
			String quString = "update User u set u.role = 5 where u.username = :username";
			Query query = (Query) em.createQuery(quString);
			query.setParameter("username", username);
			int countUpdated = query.executeUpdate();
			System.out.println("Count: " + countUpdated);
			if (countUpdated != 0) {
				res = true;
			}
			trans.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			em.close();
		}
		return res;
	}

	@Override
	public List<User> getListUser_ban(int start, int count) {
		--start;
		EntityManager em = JPAConfig.getEntityManager();
		List<User> users = null;
		try {
			String jpqlString = "SELECT u FROM User u WHERE u.role = 5";
			TypedQuery<User> query = em.createQuery(jpqlString, User.class);
			query.setFirstResult(start);
			query.setMaxResults(count);
			users = query.getResultList();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return users;
	}

	@Override
	public boolean unbanUser(String username) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean res = false;
		try {
			trans.begin();
			String quString = "update User u set u.role = 0 where u.username = :username";
			Query query = (Query) em.createQuery(quString);
			query.setParameter("username", username);
			int countUpdated = query.executeUpdate();
			System.out.println("Count: " + countUpdated);
			if (countUpdated != 0) {
				res = true;
			}
			trans.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			em.close();
		}
		return res;
	}

}

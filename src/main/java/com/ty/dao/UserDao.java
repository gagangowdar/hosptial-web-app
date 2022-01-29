package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branch;
import com.ty.dto.User;

public class UserDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	HospitalDao hospitalDao = new HospitalDao();

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public void createUser(int brachId,User user) {
		BranchDao branchDao=new BranchDao();
		Branch branch = branchDao.getBranchById(brachId);

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		user.setBranch(branch);
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public User validateUser(String mail,String password) {
		entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE mail=?1 AND password=?2");
		query.setParameter(1, mail);
		query.setParameter(2, password);

		List<User> users = query.getResultList();
		if(users != null && users.size()>0) {

			return users.get(0);

		} else {
			return null;
		}
	}
}

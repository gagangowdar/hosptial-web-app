package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Adress;
import com.ty.dto.Branch;
import com.ty.dto.Orders;

public class AdressDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}
	
	public void addAddres(int branchId,Adress adress) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class,branchId);
		entityTransaction.begin();
		adress.setBranch(branch);
		entityManager.persist(adress);
		entityTransaction.commit();
	}
	public Adress getAdressById(int id) {
		entityManager = getEntityManager();
		
		
		Adress adress= entityManager.find(Adress.class, id);
	
		return adress;
	}
	
	public List<Adress> getAllAdress() {
		entityManager = getEntityManager();	
		Query query = entityManager.createQuery("select x from Adress x ");
		return query.getResultList();

	}
	
	public List<Adress> getAdressList(int branchId) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		if(new BranchDao().getBranch(branchId) != null) {
		Query query = entityManager.createQuery("select x from Adress x where branch=1");
		List<Adress> list = query.getResultList();
		entityTransaction.commit();
		return list;
		}
		return null;
	}
}

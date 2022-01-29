package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Encounter;
import com.ty.dto.Orders;

public class OrderDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public void saveOrder(int encounterId, Orders orders ) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, encounterId);
		entityTransaction.begin();
		orders.setEncounter(encounter);
		entityManager.persist(orders);
		entityTransaction.commit();
	}
	public List<Orders> getAllOrder() {
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("select x from Orders x ");
		return query.getResultList();

	}
	
	public List<Orders> getOrderByEncounterId(int encounterId){
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("select x from Orders x Where x.encounter.id = ?1 ");
		query.setParameter(1, encounterId);
		return query.getResultList();
	}
	
	public List<Orders> getOrdersList(int encounterId) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Orders x where x.encounter="+encounterId);
		List<Orders> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}

}

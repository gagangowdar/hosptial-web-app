package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Adress;
import com.ty.dto.Encounter;
import com.ty.dto.Items;
import com.ty.dto.Orders;

public class ItemDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}
	
	public void saveItem(int orderId,Items item) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Orders orders = entityManager.find(Orders.class,orderId);
		entityTransaction.begin();
		item.setOrders(orders);
		entityManager.persist(item);
		entityTransaction.commit();
	}
	
	public List<Items> getAllItem() {
		entityManager = getEntityManager();	
		Query query = entityManager.createQuery("select x from Items x ");
		return query.getResultList();

	}
	
	public List<Items> getItemList(int orderid) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Items x where x.orders="+orderid);
		List<Items> list = query.getResultList();
		entityTransaction.commit();
		return list;
	} 
}

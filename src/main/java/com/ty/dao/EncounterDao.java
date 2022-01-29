package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branch;
import com.ty.dto.Encounter;
import com.ty.dto.Hospital;
import com.ty.dto.Person;

public class EncounterDao {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public boolean createEncounter(int branchid,int personid, Encounter encounter) 
	{
		PersonDao personDao = new PersonDao();
		BranchDao branchDao = new BranchDao();
		Branch branch = branchDao.getBranchById(branchid);
		Person person = personDao.getPersonById(personid);
		if(person != null) 
		{
			entityManager = getEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			encounter.setPerson(person);
			encounter.setBranch(branch);
			entityManager.persist(encounter);
			entityTransaction.commit();
			System.out.println("encounter Saved");
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public List<Encounter> getAllEncounter() {
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("select x from Encounter x ");
		return query.getResultList();

	}
	
	public List<Encounter> getEncountersByPersonId(int personId){
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Encounter e Where e.person.id = ?1 ");
		query.setParameter(1, personId);
		return query.getResultList();
	}
}

package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Adress;
import com.ty.dto.Branch;
import com.ty.dto.Encounter;
import com.ty.dto.Hospital;

public class BranchDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	HospitalDao hospitalDao = new HospitalDao();
	AdressDao adressDao = new AdressDao();

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}
	

	public boolean creatBranch(int hospitalId,Branch branch) {
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
		if (hospital != null) {

			entityManager = getEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			branch.setHospital(hospital);
			entityManager.persist(branch);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}

	}
	
	public Branch getBranchById(int id) {
		
		
		entityManager = getEntityManager();		
		Branch branch= entityManager.find(Branch.class, id);
	
		return branch;
	}
	
	
	
	public List<Branch> getAllBranch() {
		entityManager = getEntityManager();	
		Query query = entityManager.createQuery("select x from Branch x ");
		return query.getResultList();

	}
	
	public List<Branch> getBranchList(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Branch x where x.hospital="+id);
		List<Branch> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}
	
	
	public Branch getBranch(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Branch branch = entityManager.find(Branch.class, id);
		entityTransaction.commit();
		return branch;
	}
	
//	public List<Branch> getAllBranchesByHospital(int hospitalId){
//		
//		
//		return entityManager.find(null, entityManager);
//	}
	
	public boolean deleateBranch(int branchId) {
		return false;
	}
	
	
	
	
	
}

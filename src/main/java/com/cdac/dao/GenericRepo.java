package com.cdac.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepo {
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	public List findAllPassangers(Integer id) {
		return entityManager
				.createQuery("Select p,f from PassangerInfo p join p.user u join p.flightInfo f where u.userId == :i").setParameter("i", id)
				.getResultList();
	}
}

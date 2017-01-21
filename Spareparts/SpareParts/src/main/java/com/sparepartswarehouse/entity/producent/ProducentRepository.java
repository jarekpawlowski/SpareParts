package com.sparepartswarehouse.entity.producent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("producentRepository")
public class ProducentRepository {

	@Autowired
	Producent producent;
	@PersistenceContext
	EntityManager entityManager;
	 @Transactional
	    public Producent findProducent(int Prod_ID) {
		 Producent prod =  entityManager.find(Producent.class, Prod_ID);
		 return prod;
	    }
	 
	 @Transactional
	    public Producent createProducent(String prodName) {
		 Producent producent = new Producent();
		 producent.setProducentNazwa(prodName);
		 entityManager.merge(producent);
		 return producent;
	    }
	 
	 @Transactional
	    public Producent createProducentPersist(String prodName) {
		 Producent producent = new Producent();
		 producent.setProducentNazwa(prodName);
		 entityManager.persist(producent);
		 return producent;
	    }
	
}

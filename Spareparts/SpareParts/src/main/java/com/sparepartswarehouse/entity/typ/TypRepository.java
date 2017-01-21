package com.sparepartswarehouse.entity.typ;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sparepartswarehouse.entity.producent.Producent;

@Repository("typRepository")
public class TypRepository {

	@Autowired
	Typ typ;

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public Typ createTyp(String typNazwa, String rodzaj, String info, Producent producent) {
		Typ typ = new Typ();
		typ.setTypNazwa(typNazwa);
		typ.setRodzaj(rodzaj);
		typ.setInfoDodatkowe(info);
		typ.setProducent(producent);
		entityManager.persist(typ);
		return typ;

	}
	
	public List listTyp() {
		String query = "SELECT t FROM Typ t";
		return entityManager.createQuery(query).getResultList();
		}

}
package com.sparepartswarehouse.entity.create;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sparepartswarehouse.entity.model.Model;
import com.sparepartswarehouse.entity.producent.Producent;
import com.sparepartswarehouse.entity.typ.Typ;

@Repository("createRepository")
public class CreateRepository {

	@Autowired
	Typ typ;
	@Autowired
	Producent producent;
	@Autowired
	Model model;

	@PersistenceContext
	EntityManager entityManager;

	public List listTypHql() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT t.Typ_ID, t.typNazwa, t.rodzaj, t.infoDodatkowe, t.producentNazwa FROM Typ as t INNER JOIN Producent as pr WHERE pr.Producent_ID = t.Producent";
		Query query = session.createQuery(hql);
		List results = query.list();
		return results;
	}

	public List listTyp() {
		String query = "SELECT t.Typ_ID, t.TypNazwa, t.rodzaj, t.infoDodatkowe, pr.producentNazwa FROM Typ as t, Producent as pr WHERE pr.Producent_ID = t.Producent";
		return entityManager.createQuery(query).getResultList();
	}
	
	public List listModel(String typId) {
		Typ typ = new Typ();
		typ.setId(Integer.parseInt(typId));
		String query = "SELECT m.modelNazwa, m.obudowa, m.info FROM Model m WHERE m.Typ = :Typ_ID";
		return entityManager.createQuery(query).setParameter("Typ_ID", typ).getResultList();
		}
	
/*	public List insertAction() {
		//Model m1 = new Model();
		
		//Producent producent1 = producentRepository.createProducentPersist("Sensopart");
		//Typ typ1 = typRepository.createTyp("Czujnik", "optyczny", "24V", producent1);
		//Model m1 = modelRepository.createModel("FMS", "fi22", "24V", typ1);
		
		String query = "SELECT t.Typ_ID, t.TypNazwa, t.rodzaj, t.infoDodatkowe, pr.producentNazwa FROM Typ as t, Producent as pr WHERE pr.Producent_ID = t.Producent";
		return entityManager.createQuery(query).getResultList();
	}*/
	
}

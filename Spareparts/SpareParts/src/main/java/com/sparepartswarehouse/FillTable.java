package com.sparepartswarehouse;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sparepartswarehouse.entity.model.Model;
import com.sparepartswarehouse.entity.producent.Producent;
import com.sparepartswarehouse.entity.producent.ProducentRepository;
import com.sparepartswarehouse.entity.typ.Typ;

public class FillTable {
	private static SessionFactory factory;

	public static void main(String[] args) {
		factory = new Configuration().configure().buildSessionFactory();
		FillTable FT = new FillTable();
		Producent producent1 = FT.addProducent("Siemens");
		Typ typ1 = FT.addTyp("Silnik", "asynchroniczyny", "230V", producent1);
		Model model1 = FT.addModel("Czujnik", "DIN", "24V", typ1);
		Model model2 = FT.addModel("Czujnik", "DIN", "24V", typ1);
		Model model3 = FT.addModel("Czujnik", "DIN", "24V", typ1);
		Typ typ2 = FT.addTyp("Silnik", "asynchroniczyny", "230V", producent1);
		Producent producent2 = FT.addProducent("Keyence");
		Producent producent3 = FT.addProducent("Festo");

		//factory.close();

	}

	public Producent addProducent(String producent_nazwa) {
		Session session = factory.openSession();
		session.beginTransaction();

		Producent prod = new Producent();
		prod.setProducentNazwa(producent_nazwa);

		session.save(prod);
		session.getTransaction().commit();
		session.close();
		return prod;
	}

	public Typ addTyp(String typNazwa, String wytwornia, String dataWydania, Producent producent) {
		Session session = factory.openSession();
		session.beginTransaction();

		Typ typ = new Typ(typNazwa, wytwornia, dataWydania);
		typ.setProducent(producent);

		session.save(typ);
		session.getTransaction().commit();
		session.close();
		return typ;
	}

	public Model addModel(String modelNazwa, String obudowa, String info, Typ typ) {

		Session session = factory.openSession();
		session.beginTransaction();

		Model model = new Model();
		model.setModelNazwa(modelNazwa);
		model.setObudowa(obudowa);
		model.setInfo(info);
		model.setTyp(typ);

		session.save(model);
		session.getTransaction().commit();
		session.close();
		return model;
	}
	


}

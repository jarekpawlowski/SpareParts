package com.sparepartswarehouse.entity.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sparepartswarehouse.entity.producent.Producent;
import com.sparepartswarehouse.entity.typ.Typ;

@Repository("modelRepository")
public class ModelRepository {

	@Autowired
	Model model;
	@PersistenceContext
	EntityManager entityManager;
	 
	 @Transactional
	    public Model createModel(String modelNazwa, String obudowa, String info, Typ typ) {
		 Model model = new Model();
		 model.setModelNazwa(modelNazwa);
		 model.setObudowa(obudowa);
		 model.setInfo(info);
		 model.setTyp(typ);
		 entityManager.persist(model);
		 return model;
	    }
	 

	
}

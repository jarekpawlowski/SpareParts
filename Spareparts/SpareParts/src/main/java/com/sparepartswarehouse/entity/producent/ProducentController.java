package com.sparepartswarehouse.entity.producent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sparepartswarehouse.entity.producent.Producent;

@Controller
public class ProducentController {

	@Autowired
	ProducentRepository prodRepository;
	
	@RequestMapping(value = "/producentFindTest", method = RequestMethod.GET)
	public String findTest(ModelMap model) {
		Producent prod =prodRepository.findProducent(1);
		model.addAttribute("message", prod.getProducentNazwa());
		return "index";
	}
	
	@RequestMapping(value = "/addProducent", method = RequestMethod.GET)
	public String addAutorTest(ModelMap model) {
		Producent prod = prodRepository.createProducentPersist("Siemens");
		model.addAttribute("message", prod.getProducentNazwa());
		return "index";
	}
}

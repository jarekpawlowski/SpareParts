package com.sparepartswarehouse.entity.create;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sparepartswarehouse.entity.model.Model;
import com.sparepartswarehouse.entity.model.ModelRepository;
import com.sparepartswarehouse.entity.producent.Producent;
import com.sparepartswarehouse.entity.producent.ProducentRepository;
import com.sparepartswarehouse.entity.typ.Typ;
import com.sparepartswarehouse.entity.typ.TypRepository;


@Controller
public class CreateController {

	@Autowired
	ProducentRepository producentRepository;
	@Autowired
	TypRepository typRepository;
	@Autowired
	ModelRepository modelRepository;
	@Autowired
	CreateRepository createRepository;
	
	@RequestMapping(value = "/createTables", method = RequestMethod.GET)
	public String createTables(ModelMap model) {
		Producent producent1 = producentRepository.createProducentPersist("Siemens");
		Producent producent2 = producentRepository.createProducent("Keyence");
		Producent producent3 = producentRepository.createProducent("Rexroth");
		
		Typ typ1 = typRepository.createTyp("Silnik", "Asynchroniczny", "230V", producent1);
		Typ typ2 = typRepository.createTyp("Czujnik", "Optyczny", "Prosty", producent1);
		
		Model model1 = modelRepository.createModel("1LA7106-4AA10", "z kolnierzem", "230V", typ1);
		Model model2 = modelRepository.createModel("1LA7106-4AA10-Z", "na łapach", "230V", typ1);
		Model model3 = modelRepository.createModel("FS-V21RP", "DIN", "24V", typ2);


		model.addAttribute("message", "Wprowadzono nowy modele części");
		return "index";
	}
	
	@RequestMapping(value = "/listTyp", method = RequestMethod.GET)
	public String printTypTable(ModelMap model) {
		List result = createRepository.listTyp();
		model.addAttribute("result", result);
		return "index";
	}
	
/*	@RequestMapping(value = "/listTypTest", method = RequestMethod.GET)
	public String printAlbumTest(ModelMap model) {
		List result = typRepository.listTyp();
		model.addAttribute("result", result);
		return "index";
	}*/
	
	
	@RequestMapping(value = "/modelList", method = RequestMethod.GET)
	public String findUtwor(ModelMap model, @RequestParam("typId") String typId) {
	
		List result = createRepository.listModel(typId);
		model.addAttribute("model", result);
		return "model";
		
	}
	
	@RequestMapping(value = "/insertPart", method = RequestMethod.GET)
	public String insertPart(ModelMap model){//, @RequestParam("nazwa") String nazwa, @RequestParam("rodzaj") String rodzaj, @RequestParam("typ") String typ, @RequestParam("infoDodatkowe") String infoD, @RequestParam("ilosc") String ilosc) {
		//List result = createRepository.listTyp();
		//model.addAttribute("result", result);
		return "insert";
		
	}
	
	
	 @RequestMapping(value = "/insertAction", method = RequestMethod.POST)
	   public String insertPart(@ModelAttribute("Producent")Producent p, 
	   ModelMap model) {
	      model.addAttribute("name", p.getName());
	     // model.addAttribute("age", prod.getAge());
	     // model.addAttribute("id", prod.getId());
	      
	      return "index";
	   }
	
	 /* @RequestMapping(value = "/insertPart", method = RequestMethod.GET)
	   public ModelAndView model() {
	      return new ModelAndView("insert", "command", new Model());
	   }*/
	   
	   /*@RequestMapping(value = "/insertAction", method = RequestMethod.POST)
	   public String addPart(@ModelAttribute("SpringWeb")Model m, 
	   ModelMap model) {
	      model.addAttribute("name", m.getName());	      
	      return "index";
	   }
	   */

	
}

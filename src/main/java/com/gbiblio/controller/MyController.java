
package com.gbiblio.controller;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gbiblio.model.Adherent;
import com.gbiblio.service.IAdherentService;

@Controller
@RequestMapping("/myController")
public class MyController {
	
	IAdherentService adherentService;
	public MyController(IAdherentService adherentService) {
		this.adherentService = adherentService;
	}

	//	
	@PostConstruct
	private void init() {
		System.out.println(adherentService);
	}
   
   @ModelAttribute("myBean")
   public MyBean getString() {
	   return new MyBean();
   }

   @GetMapping("/index")
   public String index(Model model) {
	   
//	  model.addAttribute("my", "my my");
      model.addAttribute("message", "Hello Spring MVC 5!");
//      List<Adherent> listAdherent = adherentService.listAll();
//      model.addAttribute("listAdherent", listAdherent);
      return "index";
   }
   @PostMapping(value = "/index", params = {"createNewUser"})
   public String valid(@Valid @ModelAttribute MyBean myBean, BindingResult result, Model model) {
	   
//	  model.addAttribute("my", "my my");
      model.addAttribute("message", "Hello Spring MVC 5!");
//      List<Adherent> listAdherent = adherentService.listAll();
//      model.addAttribute("listAdherent", listAdherent);
      return "index";
   }
   
}
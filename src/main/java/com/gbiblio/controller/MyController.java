
package com.gbiblio.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gbiblio.model.Adherent;
import com.gbiblio.service.IAdherentService;

@Controller
@RequestMapping("/myController")
public class MyController {
	
	@Autowired
	IAdherentService adherentService;
   
   @ModelAttribute("myString")
   public String getString() {
	   return "myString .. 1";
   }

   @GetMapping("/index")
   public String index(Model model) {
	  model.addAttribute("my", "my my");
      model.addAttribute("message", "Hello Spring MVC 5!");
      List<Adherent> listAdherent = adherentService.listAll();
      model.addAttribute("listAdherent", listAdherent);
      return "index";
   }
   
}
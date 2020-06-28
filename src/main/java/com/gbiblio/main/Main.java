package com.gbiblio.main;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;
import com.gbiblio.service.AdherentService;
import com.gbiblio.service.DocumentService;
import com.gbiblio.service.EmpruntService;

public class Main {
public static void main(String[] args) {
		
		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/properties/spring/applicationContext.xml");
		
		AdherentService adherentService = ctx.getBean(AdherentService.class);
		DocumentService documentService = ctx.getBean(DocumentService.class);
		EmpruntService empruntService = ctx.getBean(EmpruntService.class);
		
		Adherent adherent_1 = new Adherent("Zineb", "ELMARZOUQY");
		Adherent adherent_2 = new Adherent("Aya", "KANDOUCH");
		Document document_1 = new Livre("DOCKER", true);
		Emprunt emprunt = new Emprunt(new Date(), new Date(), adherent_1, document_1);
		
		adherentService.add(adherent_1);
		documentService.add(document_1);
		empruntService.add(emprunt);
		
	}
}

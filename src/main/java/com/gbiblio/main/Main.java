package com.gbiblio.main;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;
import com.gbiblio.service.IAdherentService;
import com.gbiblio.service.IDocumentService;
import com.gbiblio.service.IEmpruntService;

public class Main {
public static void main(String[] args) {
		
		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/properties/spring/applicationContext.xml");
		
		IAdherentService adherentService = ctx.getBean(IAdherentService.class);
		IDocumentService documentService = ctx.getBean(IDocumentService.class);
		IEmpruntService empruntService = ctx.getBean(IEmpruntService.class);
		
		
//		Adherent adherent_1 = new Adherent("Zineb", "ELMARZOUQY");
//		Adherent adherent_2 = new Adherent("Aya", "KANDOUCH");
//		Document document_1 = new Livre("DOCKER", true);
		Adherent adherent_1 = new Adherent(1L);
		Document document_1 = new Livre(1L);
		Emprunt emprunt = new Emprunt(new Date(), new Date(), adherent_1, document_1);
		
//		adherentService.add(adherent_1);
//		documentService.add(document_1);
//		empruntService.add(emprunt);
		adherentService.delete(1L);

	}
}

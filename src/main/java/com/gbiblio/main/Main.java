package com.gbiblio.main;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;
import com.gbiblio.service.IBiblioManager;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) throws GBiblioException {

		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/resources/properties/spring/applicationContext.xml");
//
//		IAdherentService adherentService = ctx.getBean(IAdherentService.class);
		
//		BeanTest bean1 = (BeanTest) ctx.getBean("bean1");
//		BeanTest bean2 = (BeanTest) ctx.getBean("bean2");
//
//		System.out.println(bean1);
//		System.out.println(bean2);

//		IDocumentService documentService = ctx.getBean(IDocumentService.class);
//		IEmpruntService empruntService = ctx.getBean(IEmpruntService.class);

//		Adherent adherent_1 = new Adherent("Zineb", "ELMARZOUQY");
//		Adherent adherent_2 = new Adherent("Aya", "KANDOUCH");
//		Adherent adherent_3 = new Adherent("per", "per");

//		Document document_1 = new Livre("DOCKER", true);
//		Adherent adherent_1 = new Adherent(2L);
//		Document document_1 = new Livre(1L);
//		Emprunt emprunt = new Emprunt(new Date(), new Date(), adherent_1, document_1);

//		adherentService.add(adherent_3);
//		documentService.add(document_1);
//		empruntService.add(emprunt);
//		adherentService.delete(1L);

//		List<Adherent> listAdherent = adherentService.listAll();
//		for (Adherent adherent : listAdherent) {
//			System.out.println(adherent.getNom());
//		}
		
		/******************************************************************/
		
		IBiblioManager biblioManager = ctx.getBean(IBiblioManager.class);
//		Adherent adherent_1 = new Adherent(1L);
//		Document document_1 = new Livre(1L);
//		Emprunt emprunt = new Emprunt(new Date(), new Date(), adherent_1, document_1);
//		
//		biblioManager.emprunter(emprunt);
		
		biblioManager.ajouterAdherent(new Adherent("t", "t"));
	}
}

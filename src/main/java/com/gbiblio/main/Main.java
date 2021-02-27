package com.gbiblio.main;

import java.text.ParseException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Adherent;
import com.gbiblio.service.IAdherentService;
import com.gbiblio.service.IBibliothequeService;

public class Main {
	public static void main(String[] args) throws GBiblioException, ParseException {

		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/resources/properties/spring/applicationContext.xml");
//
		IAdherentService adherentService = ctx.getBean(IAdherentService.class);
		
//		BeanTest bean1 = (BeanTest) ctx.getBean("bean1");
//		BeanTest bean2 = (BeanTest) ctx.getBean("bean2");
//
//		System.out.println(bean1);
//		System.out.println(bean2);

//		IDocumentService documentService = ctx.getBean(IDocumentService.class);
//		IEmpruntService empruntService = ctx.getBean(IEmpruntService.class);

		Adherent adherent_1 = new Adherent("Zineb", "ELMARZOUQY");
		Adherent adherent_2 = new Adherent("Aya", "KANDOUCH");
//		Adherent adherent_3 = new Adherent("per", "per");

//		Document document_1 = new Livre("DOCKER", true);
//		Document document_2 = new Livre("STRING", true);
//		Document document_3 = new Dictionnaire("ENGLISH");
//		Document document_4 = new Document("doc");
//		Adherent adherent_1 = new Adherent(2L);
//		Document document_1 = new Livre(1L);
//		Emprunt emprunt = new Emprunt(new Date(), new Date(), adherent_1, document_1);

		adherentService.add(adherent_1);
		adherentService.add(adherent_2);
//		adherentService.add(adherent_3);
//		documentService.add(document_1);
//		documentService.add(document_2);
//		documentService.add(document_3);

//		documentService.add(document_4);

//		empruntService.add(new Emprunt(new Date(), new Date(), new Livre(1L)));
//		empruntService.add(new Emprunt(new Date(), new Date(), new Livre(2L)));

//		adherentService.delete(1L);

//		List<Adherent> listAdherent = adherentService.listAll();
//		for (Adherent adherent : listAdherent) {
//			for (Emprunt emp : adherent.getSetEmprunt()) {
//				System.out.println(emp.getAdherent().getNom());
//			}
//		}
		
		/******************************************************************/
		
//		IBiblioManager biblioManager = ctx.getBean(IBiblioManager.class);
//		Document document_1 = new Livre(1L);
//		Set<Emprunt> l = new HashSet<Emprunt>();
//		Emprunt emprunt_1 = new Emprunt(2L);
//		Emprunt emprunt_2 = new Emprunt(3L);
//		l.add(emprunt_1);
//		l.add(emprunt_2);
//		Adherent adherent_1 = new Adherent("Zineb", "ELMARZOUQY", l);
//		biblioManager.ajouterAdherent(adherent_1);

//		
//		biblioManager.emprunter(emprunt);
//		Adherent adherent_1 = new Adherent("cascad", "cascad");
//		Document document_1 = new Livre(2L);
//		Emprunt emprunt = biblioManager.emprunter(new Emprunt(new Date(), new Date(), new Adherent(1L), new Livre(5L)));
//		List<Emprunt> listAdherent = biblioManager.getAllEmprunts();
//		for (Emprunt emp : listAdherent) {
//			System.out.println(emp);
//		}
/**/	

//		
//		 //Add subscription
//        SubscriptionEntity subOne = new SubscriptionEntity();
//        subOne.setSubscriptionName("Entertainment");
//         
//        SubscriptionEntity subTwo = new SubscriptionEntity();
//        subTwo.setSubscriptionName("Horror");
//         
//        Set<SubscriptionEntity> subs = new HashSet<SubscriptionEntity>();
//        subs.add(subOne);
//        subs.add(subTwo);
//         
//        //Add readers
//        ReaderEntity readerOne = new ReaderEntity();
//        readerOne.setEmail("demo-user1@mail.com");
//        readerOne.setFirstName("demo");
//        readerOne.setLastName("user");
//         
//        ReaderEntity readerTwo = new ReaderEntity();
//        readerTwo.setEmail("demo-user2@mail.com");
//        readerTwo.setFirstName("demo");
//        readerTwo.setLastName("user");
//         
////        Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
////        readers.add(readerOne);
////        readers.add(readerTwo);
//         
//        readerOne.setSubscriptions(subs);
//        readerTwo.setSubscriptions(subs);
// 
		
		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
       
		
//        em.persist(readerOne);
//		 em.persist(readerTwo);
		
		IBibliothequeService bibliothequeService = ctx.getBean(IBibliothequeService.class);
//		Document document_1 = new Livre("SQL", true, new Date());
//		documentService.add(document_1);
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.set(Calendar.HOUR_OF_DAY, 0);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.SECOND, 0);
//		cal.set(Calendar.MILLISECOND, 0);
//		
//		Bibliotheque bibliotheque_1 = new Bibliotheque(cal.getTime());
//		Bibliotheque bibliotheque_2 = new Bibliotheque(new Date());
//		Bibliotheque bibliotheque_3 = new Bibliotheque(new Date());
//		bibliothequeService.add(bibliotheque_1);
//		bibliothequeService.add(bibliotheque_2);
//		bibliothequeService.add(bibliotheque_3);
//		TimeZone timezone = TimeZone.getTimeZone("UTC");
//		String sDate1="2020-12-04 00:00:00";  
//		String sDate2="2020-12-04 23:59:59";  
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("fr_FR"));
//		format.setTimeZone(timezone);
//		Date date1= format.parse(sDate1);  
//		Date date2= format.parse(sDate2);  
//		
//
//		
//		List<Bibliotheque> list = bibliothequeService.findByDate(date1, date2);
//		for (Bibliotheque dibliotheque : list) {
//			System.out.println(dibliotheque.getPublishingDate());
//		}
	}
}

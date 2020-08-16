package com.gbiblio.main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;

public class MainStream {
	public static Map<String, Document> listDocument = null;
	public static Map<String, Adherent> listAdherent = null;

	public static void listDocument() {
		listDocument = new TreeMap<String, Document>();
		listDocument.put("DOCKER", new Livre("DOCKER", true));
		listDocument.put("ANGULAR", new Livre("ANGULAR", true));
		listDocument.put("SPRING", new Livre("SPRING", true));
		listDocument.put("JAVA", new Livre("JAVA", true));
	}

	public static void listAdherent() {
		listAdherent = new TreeMap<String, Adherent>();
		Adherent adherent_1 = new Adherent("Aya", "KANDOUCH");
		adherent_1.setSetEmprunt(new TreeSet<Emprunt>());
		Adherent adherent_2 = new Adherent("Zineb", "ELMARZOUQY");
		adherent_2.setSetEmprunt(new TreeSet<Emprunt>());
		listAdherent.put("KANDOUCH", adherent_1);
		listAdherent.put("ELMARZOUQY", adherent_2);
	}

	@Deprecated
	static public boolean alreadyEmprunted(Adherent adherent, String idDocument) {
		boolean[] allreadyEmplrunted = { false };
		if (adherent != null && idDocument != null && adherent.getSetEmprunt() != null) {
			adherent.getSetEmprunt()
					.forEach(emprunt -> allreadyEmplrunted[0] = emprunt.getDocument().getTitre().equals(idDocument)
							? true
							: false);
		}
		return allreadyEmplrunted[0];
	}
	
	@Deprecated
	static public boolean isDisponible(String idDocument) {
		if (listDocument == null)
			throw new NullPointerException("List of document cannot be null");

		Document doc = listDocument.get(idDocument);
		if (doc != null && ((Livre) doc).isDisponible()) {
			return true;
		}
		return false;
	}

	public static boolean emprunter(String idDocument, String idAdherent) {
		if (listAdherent == null)
			throw new NullPointerException("List of adherent cannot be null");

		if (listDocument == null)
			throw new NullPointerException("List of document cannot be null");

		if (StringUtils.isBlank(idDocument) || StringUtils.isBlank(idAdherent))
			throw new NullPointerException("Params cannot be null");
		
		List<Adherent> adherents = listAdherent.entrySet().stream()
		        .filter(e -> idAdherent.equals(e.getKey()))
				 .map(Map.Entry::getValue)
				 .collect(Collectors.toList());
		Adherent adherent = null;
		if (adherents.size() == 1) {
			adherent = adherents.get(0);
		}
		
		List<Document> documents = listDocument.entrySet().stream()
				  .filter(e -> idAdherent.equals(e.getKey()))
				  .map(Map.Entry::getValue)
				  .collect(Collectors.toList());
		Document document = null;
		if (documents.size() == 1) {
			document = documents.get(0);
		}
		

		if (adherent != null && document != null && ((Livre) document).isDisponible()) {		
			Set<Emprunt> emprunt = new HashSet<Emprunt>();
			emprunt.addAll(adherent.getSetEmprunt());
			
			//default time zone
			ZoneId defaultZoneId = ZoneId.systemDefault();		
			//creating the instance of LocalDate using the day, month, year info
		    LocalDate localDate = LocalDate.now().plusDays(15);     
		    //local date + atStartOfDay() + default time zone + toInstant() = Date
		    Date date_2 = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			
			emprunt.add(new Emprunt(new Date(), date_2, document));
			adherent.setSetEmprunt(emprunt);
			((Livre) document).setDisponible(false);
			
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		listDocument();
		listAdherent();
		boolean emp_1 = emprunter("DOCKER", "KANDOUCH");
		boolean emp_2 = emprunter("ANGULAR", "ELMARZOUQY");
		boolean emp_3 = emprunter("ANGULAR_8", "ELMARZOUQY");
		
		if(listDocument != null) {
			listDocument.forEach((k, v) -> {
				System.out.println(v.getTitre() + ", " + ((Livre) v).isDisponible());
			});
		}
		
		if(listAdherent != null) {
			listAdherent.forEach((k, v) -> {
				System.out.println("****************************************************");
				System.out.println(k);
				System.out.println("Livres empruntes :");
				if (v != null && v.getSetEmprunt() != null) {
					v.getSetEmprunt().forEach((emp) -> {
						System.out.println(emp.getDocument().getTitre());
					});
				} else {
					System.out.println("Pas d'emprunt");
				}
			});
		}

		

	}
}

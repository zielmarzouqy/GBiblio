package com.gbiblio.service;

import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;

public interface IBiblioManager {
	Adherent ajouterAdherent(Adherent adherent);
	void enleverAdherent(Adherent adherent);
	void ajouterDocument(Document document);
	Emprunt emprunter(Emprunt emprunt) throws GBiblioException;

}

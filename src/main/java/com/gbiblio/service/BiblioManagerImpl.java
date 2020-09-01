package com.gbiblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Adherent;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;

@Service
public class BiblioManagerImpl implements IBiblioManager {
	
	@Autowired
	IAdherentService adherentService;
	@Autowired
	IDocumentService documentService;
	@Autowired
	IEmpruntService empruntService;
	
	
	@Override
	public Adherent ajouterAdherent(Adherent adherent) {
		if (adherent == null)
			throw new NullPointerException("[BiblioManagerImpl][ajouterAdherent] adherent can not be null");
		return adherentService.add(adherent);
	}

	@Override
	public void enleverAdherent(Adherent adherent) {
		adherentService.delete(adherent.getId());
	}

	@Override
	public void ajouterDocument(Document document) {
		documentService.add(document);
	}

	@Override
	public Emprunt emprunter(Emprunt emprunt) throws GBiblioException {
		if (emprunt == null)
			throw new NullPointerException("[BiblioManagerImpl][emprunter] emprunt can not be null");	
		return empruntService.add(emprunt);
	}

	@Override
	public List<Emprunt> getAllEmprunts() {
		return empruntService.listAll();
	}
	

}

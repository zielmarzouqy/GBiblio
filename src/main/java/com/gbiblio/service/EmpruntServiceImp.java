package com.gbiblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.IDocumentDao;
import com.gbiblio.dao.IEmpruntDao;
import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Document;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;

@Service
public class EmpruntServiceImp implements IEmpruntService {

	@Autowired
	private IEmpruntDao empruntDao;
	
	@Autowired
	private IDocumentDao documentDao;

	@Transactional
	public Emprunt add(Emprunt emprunt) throws GBiblioException {
		if (emprunt == null) 
			throw new IllegalArgumentException("[EmpruntServiceImp][add] args null");
		
		try {
				Livre livre = (Livre) documentDao.findOne(emprunt.getDocument().getId());
				
				if (livre == null)
					throw new GBiblioException("[EmpruntServiceImp][add] Le document recherche n'existe pas id=" + emprunt.getDocument().getId());

				if (!livre.isDisponible())			
					throw new GBiblioException("[EmpruntServiceImp][add] Le document n'est pa disponible id=" + emprunt.getDocument().getId());
				
				empruntDao.persist(emprunt);
				livre.setDisponible(false);
				Document l = documentDao.update(livre);
				
				return emprunt;
		} catch (Exception e) {
			throw new GBiblioException("[EmpruntServiceImp][add] Erreur lors l'emprunt", e);
		}
	}

	@Transactional(readOnly = true)
	public List<Emprunt> listAll() {
		return empruntDao.findAll();

	}

}

package com.gbiblio.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.EmpruntDao;
import com.gbiblio.model.Emprunt;
import com.gbiblio.model.Livre;

@Service
public class EmpruntServiceImp implements IEmpruntService{

	@Autowired
	private EmpruntDao empruntDao;
	
	@Autowired
	IDocumentService documentService;

	@Transactional
	public boolean add(Emprunt emprunt) {
		if(emprunt != null  && emprunt.getAdherent() != null && emprunt.getDocument() != null) {
			Livre livre = (Livre) documentService.findOne(emprunt.getDocument().getId());
			if (livre != null) {
				if (livre.isDisponible()) {
					empruntDao.persist(emprunt);
					livre.setDisponible(false);
					documentService.update(livre);
					return true;
				}
			}
		}
		return false;
	}
	
	@Transactional(readOnly = true)
	public List<Emprunt> listAll() {
		return empruntDao.findAll();

	}

}

package com.gbiblio.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.IAdherentDao;
import com.gbiblio.model.Adherent;

@Service
public class AdherentServiceImp implements IAdherentService {

	@Autowired
	private IAdherentDao adherentDao;

	@Transactional
	public Adherent add(Adherent adherent){
		if (adherent == null)
			throw new NullPointerException("[AdherentServiceImp][add] adherent can not be null");
		adherentDao.persist(adherent);
		return adherent;
	}

	@Transactional(readOnly = true)
	public List<Adherent> listAll() {
		return adherentDao.findAll();

	}
	
	@Transactional
	public int delete(Long id) {
		return adherentDao.delete(id);
	}

}

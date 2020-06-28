package com.gbiblio.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.AdherentDao;
import com.gbiblio.model.Adherent;

@Component
public class AdherentService {

	@Autowired
	private AdherentDao adherentDao;

	@Transactional
	public void add(Adherent adherent) {
		adherentDao.persist(adherent);
	}

	@Transactional(readOnly = true)
	public List<Adherent> listAll() {
		return adherentDao.findAll();

	}

}

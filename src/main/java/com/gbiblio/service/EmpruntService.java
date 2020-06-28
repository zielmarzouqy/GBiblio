package com.gbiblio.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.EmpruntDao;
import com.gbiblio.model.Emprunt;

@Component
public class EmpruntService {

	@Autowired
	private EmpruntDao empruntDao;

	@Transactional
	public void add(Emprunt emprunt) {
		empruntDao.persist(emprunt);
	}

	@Transactional(readOnly = true)
	public List<Emprunt> listAll() {
		return empruntDao.findAll();

	}

}

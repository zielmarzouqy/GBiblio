package com.gbiblio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.IBiblioDao;
import com.gbiblio.model.Bibliotheque;

@Service
public class BibliothequeServiceImp implements IBibliothequeService {

	@Autowired
	private IBiblioDao biblioDao;

	@Transactional
	public Bibliotheque add(Bibliotheque bibliotheque) {
		 biblioDao.persist(bibliotheque);
		 return bibliotheque;
	}

	@Override
	public List<Bibliotheque> findByDate(Date d1, Date d2) {
		return biblioDao.findByDate(d1, d2);
	}

	

}

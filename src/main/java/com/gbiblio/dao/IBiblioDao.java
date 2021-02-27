package com.gbiblio.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.gbiblio.model.Bibliotheque;

public interface IBiblioDao {
	public void persist(Bibliotheque bib) throws PersistenceException;
	public List<Bibliotheque> findByDate(Date d1, Date d2);
	
}

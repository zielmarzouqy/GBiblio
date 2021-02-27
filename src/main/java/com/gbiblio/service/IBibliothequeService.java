package com.gbiblio.service;

import java.util.Date;
import java.util.List;

import com.gbiblio.model.Bibliotheque;

public interface IBibliothequeService {
	public Bibliotheque add(Bibliotheque bibliotheque);
	public List<Bibliotheque> findByDate(Date d1, Date d2);
}

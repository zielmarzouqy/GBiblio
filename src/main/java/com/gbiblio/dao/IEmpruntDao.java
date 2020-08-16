package com.gbiblio.dao;

import java.util.List;

import com.gbiblio.model.Emprunt;

public interface IEmpruntDao {
	public void persist(Emprunt emprunt);
	public List<Emprunt> findAll();
}

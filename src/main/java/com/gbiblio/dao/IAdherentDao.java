package com.gbiblio.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.gbiblio.model.Adherent;

public interface IAdherentDao {
	public void persist(Adherent adherent) throws PersistenceException;
	public List<Adherent> findAll();
	public int delete(Long id);
}

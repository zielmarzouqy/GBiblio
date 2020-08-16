package com.gbiblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gbiblio.model.Emprunt;

@Repository
public class EmpruntDaoImpl implements IEmpruntDao{
	@PersistenceContext
	private EntityManager em;

	public void persist(Emprunt emprunt) {
		em.persist(emprunt);
	}

	public List<Emprunt> findAll() {
		return em.createQuery("SELECT e FROM Emprunt e").getResultList();
	}
}

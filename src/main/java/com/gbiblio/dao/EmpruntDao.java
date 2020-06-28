package com.gbiblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.gbiblio.model.Emprunt;

@Component
public class EmpruntDao {
	@PersistenceContext
	private EntityManager em;

	public void persist(Emprunt emprunt) {
		em.persist(emprunt);
	}

	public List<Emprunt> findAll() {
		return em.createQuery("SELECT e FROM Emprunt e").getResultList();
	}
}

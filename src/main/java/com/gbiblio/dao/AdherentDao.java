package com.gbiblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.gbiblio.model.Adherent;

@Component
public class AdherentDao {
	@PersistenceContext
	private EntityManager em;

	public void persist(Adherent adherent) {
		em.persist(adherent);
	}

	public List<Adherent> findAll() {
		return em.createQuery("SELECT a FROM Adherent a").getResultList();
	}
	
	public void delete(Long id) {
		 em.createQuery("delete FROM Adherent a where a.id=:id")
		            .setParameter("id", id)
		            .executeUpdate();
	}
}

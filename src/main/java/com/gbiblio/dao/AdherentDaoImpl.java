package com.gbiblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import com.gbiblio.model.Adherent;

@Repository
public class AdherentDaoImpl implements IAdherentDao{
	
	@PersistenceContext
	private EntityManager em;

	public void persist(Adherent adherent) throws PersistenceException {
		if (adherent == null)
			throw new NullPointerException("[AdherentDaoImpl][persist] adherent can not be null");
		try {
			em.persist(adherent);
		} catch (PersistenceException e) {
			throw new PersistenceException(e);
		}

	}

	public List<Adherent> findAll() {
		return em.createQuery("SELECT a FROM Adherent a").getResultList();
	}
	
	public int delete(Long id) {
		if (id == null)
			throw new NullPointerException("[AdherentDaoImpl][delete] param can not be null id=" + id);
		return em.createQuery("delete FROM Adherent a where a.id=:id")
		            .setParameter("id", id)
		            .executeUpdate();
	}
}

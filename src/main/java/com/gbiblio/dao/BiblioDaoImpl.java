package com.gbiblio.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

import com.gbiblio.model.Bibliotheque;

@Repository
public class BiblioDaoImpl implements IBiblioDao {
	@PersistenceContext
	private EntityManager em;

	public void persist(Bibliotheque bib) {
		 em.persist(bib);
	}


	public List<Bibliotheque> findByDate(Date d1, Date d2) {
		return em.createQuery("select b FROM Bibliotheque b where b.publishingDate>=:start and b.publishingDate<=:end")
        .setParameter("start", d1)
        .setParameter("end", d2)
        .getResultList();
	}
}

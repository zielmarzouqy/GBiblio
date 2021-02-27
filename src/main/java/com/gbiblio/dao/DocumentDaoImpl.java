package com.gbiblio.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gbiblio.model.Document;
import com.gbiblio.model.Livre;

@Repository
public class DocumentDaoImpl implements IDocumentDao {
	@PersistenceContext
	private EntityManager em;

	public void persist(Document document) {
		em.persist(document);
	}

	public List<Document> findAll() {
		return em.createQuery("SELECT d FROM Document d").getResultList();
	}
	
	public Document findOne(Long id) {
		return em.find(Document.class, id);
	}
	
	public Document update(Document document) {
		return em.merge(document);
	}
	
	public void delete(Long id) {
		 em.createQuery("delete FROM Document d where d.id=:id")
		            .setParameter("id", id)
		            .executeUpdate();
	}

	@Override
	public List<Livre> findByDate(Date d1, Date d2) {
		return em.createQuery("select l FROM Livre l where l.publishingDate>=:publishingDate and l.publishingDate<=:publishingDate")
        .setParameter("publishingDate", d1)
        .setParameter("publishingDate", d2)
        .getResultList();
	}
}

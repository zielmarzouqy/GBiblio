package com.gbiblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.gbiblio.model.Document;

@Component
public class DocumentDao {
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
}

package com.gbiblio.dao;

import java.util.Date;
import java.util.List;

import com.gbiblio.model.Document;
import com.gbiblio.model.Livre;

public interface IDocumentDao {
	public void persist(Document document);
	public List<Document> findAll();
	public Document findOne(Long id);
	public Document update(Document document);
	public void delete(Long id);
	public List<Livre> findByDate(Date d1, Date d2);
}

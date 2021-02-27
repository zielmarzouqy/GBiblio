package com.gbiblio.service;

import java.util.Date;
import java.util.List;

import com.gbiblio.model.Document;
import com.gbiblio.model.Livre;

public interface IDocumentService {
	public void add(Document document);
	public List<Document> listAll();
	public Document findOne(Long id);
	public Document update(Document document);
	public void delete(Long id);
	public List<Livre> findByDate(Date d1, Date d2);
}

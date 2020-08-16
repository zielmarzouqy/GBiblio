package com.gbiblio.dao;

import java.util.List;
import com.gbiblio.model.Document;

public interface IDocumentDao {
	public void persist(Document document);
	public List<Document> findAll();
	public Document findOne(Long id);
	public Document update(Document document);
	public void delete(Long id);
}

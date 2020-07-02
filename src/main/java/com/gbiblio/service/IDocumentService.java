package com.gbiblio.service;

import java.util.List;

import com.gbiblio.model.Document;

public interface IDocumentService {
	public void add(Document document);
	public List<Document> listAll();
	public Document findOne(Long id);
	public Document update(Document document);
	public void delete(Long id);
}

package com.gbiblio.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.DocumentDao;
import com.gbiblio.model.Document;

@Component
public class DocumentService {

	@Autowired
	private DocumentDao documentDao;

	@Transactional
	public void add(Document document) {
		documentDao.persist(document);
	}

	@Transactional(readOnly = true)
	public List<Document> listAll() {
		return documentDao.findAll();

	}

}

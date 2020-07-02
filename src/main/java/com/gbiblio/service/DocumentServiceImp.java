package com.gbiblio.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbiblio.dao.DocumentDao;
import com.gbiblio.model.Document;


@Service
public class DocumentServiceImp implements IDocumentService{

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
	
	@Transactional(readOnly = true)
	public Document findOne(Long id) {
		return documentDao.findOne(id);

	}
	
	@Transactional
	public Document update(Document document) {
		return documentDao.update(document);

	}
	
	@Transactional
	public void delete(Long id) {
		 documentDao.delete(id);
	}

}

package com.gbiblio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Emprunt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateEmprunt;
	private Date dateRetour;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="id_adherent")
	private Adherent adherent;
	
	@OneToOne(optional = false)
	@JoinColumn(name="id_document")
	private Document document;

	public Emprunt() {
		super();
	}
	public Emprunt(Date dateEmprunt, Date dateRetour, Adherent adherent, Document document) {
		super();
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.adherent = adherent;
		this.document = document;
	}
	
	public Emprunt(Date dateEmprunt, Date dateRetour, Document document) {
		super();
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.document = document;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}


		
}

package com.gbiblio.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="document_type")
public class Document {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre;
	
//	@OneToOne
//	@JoinColumn(name="id_emprunt")
//	private Emprunt emprunt;
	
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Document(Long id) {
		super();
		this.id = id;
	}

	public Document(Long id, String titre) {
	super();
	this.id = id;
	this.titre = titre;
}

	public Document(String titre) {
		super();
		this.titre = titre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
//	public Emprunt getEmprunt() {
//		return emprunt;
//	}
//	public void setEmprunt(Emprunt emprunt) {
//		this.emprunt = emprunt;
//	}
	
	
	
	
}

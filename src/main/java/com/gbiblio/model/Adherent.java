package com.gbiblio.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Adherent {

	@Id
//	@GeneratedValue (strategy=GenerationType.AUTO, generator = "native")
//    @GenericGenerator(name = "native", strategy = "native")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;

	@OneToMany(mappedBy = "adherent", fetch = FetchType.EAGER)
	private Set<Emprunt> setEmprunt;

	public Adherent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adherent(Long id) {
		super();
		this.id = id;
	}

	public Adherent(Long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Adherent(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Emprunt> getSetEmprunt() {
		return setEmprunt;
	}

	public void setSetEmprunt(Set<Emprunt> setEmprunt) {
		this.setEmprunt = setEmprunt;
	}

}

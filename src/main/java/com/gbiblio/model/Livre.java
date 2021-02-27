package com.gbiblio.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@PrimaryKeyJoinColumn(name = "livre_id" , referencedColumnName = "id")
@DiscriminatorValue("Livre")
public class Livre extends Document{
	private boolean disponible;

	public Livre() {
		super();
	}
	public Livre(Long id) {
		super(id);
	}
	public Livre(Long id, String titre, boolean disponible) {
		super(id, titre);
		this.disponible = disponible;
	}

	public Livre(String titre, boolean disponible) {
		super(titre);
		this.disponible = disponible;
	}
	
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
}

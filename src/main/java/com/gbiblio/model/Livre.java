package com.gbiblio.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Livre")
public class Livre extends Document{
	private boolean disponible;

	public Livre() {
		super();
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

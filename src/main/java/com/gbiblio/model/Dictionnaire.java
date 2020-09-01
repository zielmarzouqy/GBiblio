package com.gbiblio.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@PrimaryKeyJoinColumn(name = "dictionnaire_id", referencedColumnName = "id")
@DiscriminatorValue("Dictionnaire")
public class Dictionnaire extends Document{

	public Dictionnaire() {
	}
	public Dictionnaire(String titre) {
		super(titre);
	}

}

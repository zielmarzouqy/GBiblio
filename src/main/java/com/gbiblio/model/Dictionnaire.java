package com.gbiblio.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dictionnaire")
public class Dictionnaire extends Document{

}

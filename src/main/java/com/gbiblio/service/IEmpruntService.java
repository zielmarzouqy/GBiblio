package com.gbiblio.service;

import java.util.List;

import com.gbiblio.model.Emprunt;

public interface IEmpruntService {
	public boolean add(Emprunt emprunt);
	public List<Emprunt> listAll();
}

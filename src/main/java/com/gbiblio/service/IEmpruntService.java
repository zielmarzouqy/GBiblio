package com.gbiblio.service;

import java.util.List;

import com.gbiblio.exception.GBiblioException;
import com.gbiblio.model.Emprunt;

public interface IEmpruntService {
	public Emprunt add(Emprunt emprunt) throws GBiblioException;
	public List<Emprunt> listAll();
}

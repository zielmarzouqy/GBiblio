package com.gbiblio.service;

import java.util.List;


import com.gbiblio.model.Adherent;

public interface IAdherentService {
	public Adherent add(Adherent adherent);
	public List<Adherent> listAll();
	public int delete(Long id);
}

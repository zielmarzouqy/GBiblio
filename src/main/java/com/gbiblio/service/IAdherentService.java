package com.gbiblio.service;

import java.util.List;


import com.gbiblio.model.Adherent;

public interface IAdherentService {
	public void add(Adherent adherent);
	public List<Adherent> listAll();
	public void delete(Long id);
}

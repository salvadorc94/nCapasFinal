package com.uca.cine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Pais;
import com.uca.cine.repositories.PaisRepository;

@Service
public class PaisServiceImp implements PaisService {

	@Autowired
	public PaisRepository paisrepository;

	@Override
	public List<Pais> listar() {
		return paisrepository.findAll();
	}

	@Override
	public Pais getOne(int id) {
		return paisrepository.getOne(id);
	}
	
	
	
}

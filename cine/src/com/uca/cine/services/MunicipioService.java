package com.uca.cine.services;

import java.util.List;

import com.uca.cine.domain.Municipio;

public interface MunicipioService {

	public List<Municipio> listar();
	
	public Municipio getOne(int id);
}

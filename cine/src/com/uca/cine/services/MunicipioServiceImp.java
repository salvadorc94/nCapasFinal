package com.uca.cine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Municipio;
import com.uca.cine.repositories.MunicipioRepository;

@Service
public class MunicipioServiceImp implements MunicipioService {

	@Autowired
	public MunicipioRepository munirepo;
	
	@Override
	public List<Municipio> listar() {
		return munirepo.findAll();
	}

	@Override
	public Municipio getOne(int id) {
		return munirepo.getOne(id);
	}

}

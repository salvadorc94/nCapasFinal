package com.uca.cine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Departamento;
import com.uca.cine.repositories.DepartamentoRepository;

@Service
public class DepartamentoServiceImp implements DepartamentoService {
	@Autowired
	public DepartamentoRepository deparepo;

	@Override
	public List<Departamento> listar() {
		return deparepo.findAll();
	}

	@Override
	public Departamento getOne(int id) {
		return deparepo.getOne(id);
	}
	
}

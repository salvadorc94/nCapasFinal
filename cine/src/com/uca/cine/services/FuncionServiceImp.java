package com.uca.cine.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Funcion;
import com.uca.cine.repositories.FuncionRepository;

@Service
public class FuncionServiceImp implements FuncionService {
	
	@Autowired
	public FuncionRepository funcionrepository;

	@Override
	public List<Funcion> listarFunciones() {
		return funcionrepository.findAll();
	}

	@Override
	public Funcion obtenerFuncion(int id) {
		return funcionrepository.getOne(id);
	}

	@Transactional
	@Override
	public void insertarActualizarFuncion(Funcion f) {
		funcionrepository.save(f);
	}
	
	

}

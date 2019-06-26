package com.uca.cine.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Tipof;
import com.uca.cine.repositories.TipofRepository;

@Service
public class TipofServiceImp implements TipofService {

	@Autowired
	public TipofRepository tipofrepository;
	
	@Override
	public List<Tipof> listar() {
		return tipofrepository.findAll();
	}

	@Override
	public Tipof obtenerUno(int id) {
		return tipofrepository.getOne(id);
	}

	@Transactional
	@Override
	public void insertarActualizar(Tipof t) {
		tipofrepository.save(t);
	}

}

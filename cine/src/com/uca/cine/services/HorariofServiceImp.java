package com.uca.cine.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Horariof;
import com.uca.cine.repositories.HorariofRepository;


@Service
public class HorariofServiceImp implements HorariofService {
	@Autowired
	public HorariofRepository horariofrepository;

	@Override
	public List<Horariof> listar() {
		return horariofrepository.findAll();
	}

	@Override
	public Horariof obtenerUno(int id) {
		return horariofrepository.getOne(id);
	}

	@Transactional
	@Override
	public void insertarActualizar(Horariof h) {
		horariofrepository.save(h);
	}

}

package com.uca.cine.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Reserva;
import com.uca.cine.repositories.ReservaRepository;

@Service
public class ReservaServiceImp implements ReservaService {

	@Autowired
	public ReservaRepository reservarepository;

	@Override
	public List<Reserva> listar() {
		return reservarepository.findAll();
	}

	@Override
	public Reserva obtenerUno(int id) {
		return reservarepository.getOne(id);
	}
	
	@Transactional
	@Override
	public void insertarActualizar(Reserva r) {
		reservarepository.save(r);
	}
	
	
}

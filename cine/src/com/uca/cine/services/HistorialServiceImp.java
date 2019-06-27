package com.uca.cine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Historial;
import com.uca.cine.repositories.HistorialRepository;

@Service
public class HistorialServiceImp implements HistorialService {

	@Autowired
	private HistorialRepository hrepository;
	
	@Override
	public List<Historial> listarFunciones() {
		return hrepository.findAll();
	}

	@Override
	public Historial obtenerFuncion(int id) {
		return hrepository.getOne(id);
	}

	@Override
	public void insertarActualizarHistorial(Historial h) {
		hrepository.save(h);
	}

	@Override
	public List<Historial> filtrarFechas(int code, String fechai, String fechaf) {
		return hrepository.filtrarFechas(code, fechai, fechaf);
	}

}

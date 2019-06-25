package com.uca.cine.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cine.domain.Pelicula;
import com.uca.cine.repositories.PeliculaRepository;

@Service
public class PeliculaServiceImp implements PeliculaService {

	@Autowired
	public PeliculaRepository pelicularepository;
	
	@Override
	public List<Pelicula> listar() {
		return pelicularepository.findAll();
	}

	@Override
	public Pelicula obtenerUno(int id) {
		return pelicularepository.getOne(id);
	}

	@Transactional
	@Override
	public void insertarActualizar(Pelicula p) {
		pelicularepository.save(p);
	}

}

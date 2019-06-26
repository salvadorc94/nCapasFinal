package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Pelicula;


@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

}

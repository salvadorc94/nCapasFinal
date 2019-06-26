package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Funcion;


@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {
	
}

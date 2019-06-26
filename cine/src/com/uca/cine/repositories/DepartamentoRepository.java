package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Departamento;

@Repository
public interface DepartamentoRepository  extends JpaRepository<Departamento, Integer> {

}

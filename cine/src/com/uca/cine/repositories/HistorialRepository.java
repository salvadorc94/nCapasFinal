package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Historial;


@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer>  {

}

package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Municipio;



@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

}

package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}

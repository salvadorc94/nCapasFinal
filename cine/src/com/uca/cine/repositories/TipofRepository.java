package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Tipof;

@Repository
public interface TipofRepository extends JpaRepository<Tipof, Integer> {

}

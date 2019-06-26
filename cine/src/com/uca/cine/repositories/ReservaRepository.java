package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}

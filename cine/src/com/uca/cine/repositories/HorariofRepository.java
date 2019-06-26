package com.uca.cine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Horariof;

@Repository
public interface HorariofRepository extends JpaRepository<Horariof, Integer> {

}

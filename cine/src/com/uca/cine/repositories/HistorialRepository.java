package com.uca.cine.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uca.cine.domain.Historial;


@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer>  {

	
	@Query(value = "SELECT * FROM HISTORIAL H JOIN RESERVA R ON R.PKIDRESERVA = H.FKIDRESERVA WHERE H.FKIDUSUARIO=:cuser AND CAST(FECHARESERVA AS DATE) BETWEEN CAST(:fi AS DATE) AND CAST(:ff AS DATE);",nativeQuery = true)
	public List<Historial> filtrarFechas(@Param("cuser") int code,@Param("fi") String fi,@Param("ff") String ff);
}
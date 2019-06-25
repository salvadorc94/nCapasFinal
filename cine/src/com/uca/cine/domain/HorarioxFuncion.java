package com.uca.cine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="horarioxfuncion")
public class HorarioxFuncion {

	@Id
	@GeneratedValue(generator="horarioxfuncion_pk_idhorarioxfuncion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "horarioxfuncion_pk_idhorarioxfuncion_seq", sequenceName = "public.horarioxfuncion_pk_idhorarioxfuncion_seq", allocationSize = 1)
	@Column(name = "pk_idhorarioxfuncion")
	private int pk_idhorarioxfuncion;
	
	//FK_HORARIO
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "fk_idhorariof")
			private Horariof horariof;
	
	//FK_FUNCION
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "fk_idfuncion")
			private Funcion funcion;

}

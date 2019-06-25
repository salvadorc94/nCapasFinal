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
@Table(schema="public",name="tipoxfuncion")
public class TipoxFuncion {

	@Id
	@GeneratedValue(generator="tipoxfuncion_pk_pk_idtipoxfuncion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "tipoxfuncion_pk_idtipoxfuncion_seq", sequenceName = "public.tipoxfuncion_pk_idtipoxfuncion_seq", allocationSize = 1)
	@Column(name = "pk_idtipoxfuncion")
	private int pk_idtipoxfuncion;
	
	//FK_TIPO
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "fk_idtipof")
		private Tipof tipof;
		
	//FK_FUNCION
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "fk_idfuncion")
		private Funcion funcion;

		
	
	
}

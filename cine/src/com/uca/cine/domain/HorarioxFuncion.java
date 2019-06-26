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
	@GeneratedValue(generator="horarioxfuncion_pkidhorarioxfuncion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "horarioxfuncion_pkidhorarioxfuncion_seq", sequenceName = "public.horarioxfuncion_pkidhorarioxfuncion_seq", allocationSize = 1)
	@Column(name = "pkidhorarioxfuncion")
	private int pkidhorarioxfuncion;
	
	//FK_HORARIO
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "fkidhorariof")
			private Horariof horariof;
	
	//FK_FUNCION
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "fkidfuncion")
			private Funcion funcion;

			public int getPkidhorarioxfuncion() {
				return pkidhorarioxfuncion;
			}

			public void setPkidhorarioxfuncion(int pkidhorarioxfuncion) {
				this.pkidhorarioxfuncion = pkidhorarioxfuncion;
			}

			public Horariof getHorariof() {
				return horariof;
			}

			public void setHorariof(Horariof horariof) {
				this.horariof = horariof;
			}

			public Funcion getFuncion() {
				return funcion;
			}

			public void setFuncion(Funcion funcion) {
				this.funcion = funcion;
			}

			
}

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
	@GeneratedValue(generator="tipoxfuncion_pkidtipoxfuncion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "tipoxfuncion_pkidtipoxfuncion_seq", sequenceName = "public.tipoxfuncion_pkidtipoxfuncion_seq", allocationSize = 1)
	@Column(name = "pkidtipoxfuncion")
	private int pkidtipoxfuncion;
	
	//FK_TIPO
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "fkidtipof")
		private Tipof tipof;
		
	//FK_FUNCION
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "fkidfuncion")
		private Funcion funcion;

		public int getPkidtipoxfuncion() {
			return pkidtipoxfuncion;
		}

		public void setPkidtipoxfuncion(int pkidtipoxfuncion) {
			this.pkidtipoxfuncion = pkidtipoxfuncion;
		}

		public Tipof getTipof() {
			return tipof;
		}

		public void setTipof(Tipof tipof) {
			this.tipof = tipof;
		}

		public Funcion getFuncion() {
			return funcion;
		}

		public void setFuncion(Funcion funcion) {
			this.funcion = funcion;
		}

		
		
	
	
}

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

@Entity
public class Historial {

	@Id
	@GeneratedValue(generator="historial_pkidhistorial_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "historial_pkidhistorial_seq", sequenceName = "public.historial_pkidhistorial_seq", allocationSize = 1)
	@Column(name = "pkidhistorial")
	private int pkidhistorial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidusuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidreserva")
	private Reserva reserva;

	public int getPkidhistorial() {
		return pkidhistorial;
	}

	public void setPkidhistorial(int pkidhistorial) {
		this.pkidhistorial = pkidhistorial;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	
}

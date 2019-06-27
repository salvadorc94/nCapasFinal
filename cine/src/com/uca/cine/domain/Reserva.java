package com.uca.cine.domain;

import java.util.Date;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(schema="public",name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(generator="reserva_pkidreserva_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "reserva_pkidreserva_seq", sequenceName = "public.reserva_pkidreserva_seq", allocationSize = 1)
	@Column(name = "pkidreserva")
	private int pkidreserva;
	
	@NotNull
	@Min(1)
	@Max(15)
	@Column(name = "nasientosreserva")
	private int nasientosreserva;
	
	@NotNull
	@Column(name = "saldoutilizar")
	private int saldoutilizar;
	
	@Column(name = "saldorestante")
	private int saldorestante;
	
	@Column(name = "fechareserva")
	private String fechareserva;
	
	//FK ID USUARIO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidusuario")
	private Usuario usuario;
	//FK ID FUNCION
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidfuncion")
	private Funcion funcion;
	public int getPkidreserva() {
		return pkidreserva;
	}
	public void setPkidreserva(int pkidreserva) {
		this.pkidreserva = pkidreserva;
	}
	public int getNasientosreserva() {
		return nasientosreserva;
	}
	public void setNasientosreserva(int nasientosreserva) {
		this.nasientosreserva = nasientosreserva;
	}
	
	
	public int getSaldoutilizar() {
		return saldoutilizar;
	}
	public int getSaldorestante() {
		return saldorestante;
	}
	public void setSaldorestante(int saldorestante) {
		this.saldorestante = saldorestante;
	}
	public String getFechareserva() {
		return fechareserva;
	}
	public void setFechareserva(String fechareserva) {
		this.fechareserva = fechareserva;
	}
	public void setSaldoutilizar(int saldoutilizar) {
		this.saldoutilizar = saldoutilizar;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Funcion getFuncion() {
		return funcion;
	}
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	
		
	
}

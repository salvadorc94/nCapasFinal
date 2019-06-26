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
	private float saldoutilizar;
	
	@NotNull
	@Column(name = "saldorestante")
	private float saldorestante;
	
	@NotEmpty(message="Ingrese una fecha")
	@NotNull
	@Column(name = "fechareserva")
	private Date fechareserva;
	
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
	public float getSaldoutilizar() {
		return saldoutilizar;
	}
	public void setSaldoutilizar(float saldoutilizar) {
		this.saldoutilizar = saldoutilizar;
	}
	public float getSaldorestante() {
		return saldorestante;
	}
	public void setSaldorestante(float saldorestante) {
		this.saldorestante = saldorestante;
	}
	public Date getFechareserva() {
		return fechareserva;
	}
	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
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

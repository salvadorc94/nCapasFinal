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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(schema="public",name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(generator="reserva_pk_idreserva_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "reserva_pk_idreserva_seq", sequenceName = "public.reserva_pk_idreserva_seq", allocationSize = 1)
	@Column(name = "pk_idreserva")
	private int pk_idreserva;
	
	@NotNull
	@Min(1)
	@Column(name = "n_asientos_reserva")
	private int n_asientos_reserva;
	
	@NotNull
	@Column(name = "saldo_utilizar")
	private float saldo_utilizar;
	
	@NotNull
	@Column(name = "saldo_restante")
	private float saldo_restante;
	
	@NotEmpty(message="Ingrese una fecha")
	@NotNull
	@Column(name = "fecha_reserva")
	private Date fecha_reserva;
	
	//FK ID USUARIO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idusuario")
	private Usuario usuario;
	//FK ID FUNCION
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idfuncion")
	private Funcion funcion;
	public int getPk_idreserva() {
		return pk_idreserva;
	}
	public void setPk_idreserva(int pk_idreserva) {
		this.pk_idreserva = pk_idreserva;
	}
	public int getN_asientos_reserva() {
		return n_asientos_reserva;
	}
	public void setN_asientos_reserva(int n_asientos_reserva) {
		this.n_asientos_reserva = n_asientos_reserva;
	}
	public float getSaldo_utilizar() {
		return saldo_utilizar;
	}
	public void setSaldo_utilizar(float saldo_utilizar) {
		this.saldo_utilizar = saldo_utilizar;
	}
	public float getSaldo_restante() {
		return saldo_restante;
	}
	public void setSaldo_restante(float saldo_restante) {
		this.saldo_restante = saldo_restante;
	}
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
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

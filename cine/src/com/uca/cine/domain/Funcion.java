package com.uca.cine.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

@Entity
@Table(schema="public",name="funcion")
public class Funcion {
	
	@Id
	@GeneratedValue(generator="funcion_pkidfuncion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "funcion_pkidfuncion_seq", sequenceName = "public.funcion_pkidfuncion_seq", allocationSize = 1)
	@Column(name = "pkidfuncion")
	private int pkidfuncion;
	
	@Min(1)
	@Column(name = "asientos")
	private int asientos;
	
	@Column(name = "estado")
	private boolean estado;
	
	@NotNull
	@Column(name = "fechacreacion")
	private Date fechacreacion;
	
	@NotNull
	@Column(name = "usuariocreacion")
	private String usuariocreacion;
	
	@NotNull
	@Column(name = "fechamodificacion")
	private Date fechamodificacion;
	
	@NotNull
	@Column(name = "usuariomodificacion")
	private String usuariomodificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidpelicula")
	private Pelicula pelicula;
	
	@OneToMany(mappedBy = "funcion", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy = "funcion", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<HorarioxFuncion> horarioxfuncion;
	
	@OneToMany(mappedBy = "funcion", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<TipoxFuncion> tipoxfuncion;
	
	public String getEstadoDelegate() {
		return estado == true ? "Activo":"Inactivo";
	}

	public int getPkidfuncion() {
		return pkidfuncion;
	}

	public void setPkidfuncion(int pkidfuncion) {
		this.pkidfuncion = pkidfuncion;
	}

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getUsuariocreacion() {
		return usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public String getUsuariomodificacion() {
		return usuariomodificacion;
	}

	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<HorarioxFuncion> getHorarioxfuncion() {
		return horarioxfuncion;
	}

	public void setHorarioxfuncion(List<HorarioxFuncion> horarioxfuncion) {
		this.horarioxfuncion = horarioxfuncion;
	}

	public List<TipoxFuncion> getTipoxfuncion() {
		return tipoxfuncion;
	}

	public void setTipoxfuncion(List<TipoxFuncion> tipoxfuncion) {
		this.tipoxfuncion = tipoxfuncion;
	}
	
	

}

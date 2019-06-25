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
	@GeneratedValue(generator="funcion_pk_idfuncion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "funcion_pk_idfuncion_seq", sequenceName = "public.funcion_pk_idfuncion_seq", allocationSize = 1)
	@Column(name = "pk_idfuncion")
	private int pk_idfuncion;
	
	@Min(1)
	@Column(name = "asientos")
	private int asientos;
	
	@Column(name = "estado")
	private boolean estado;
	
	@NotNull
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;
	
	@NotNull
	@Column(name = "usuario_creacion")
	private String usuario_creacion;
	
	@NotNull
	@Column(name = "fecha_modificacion")
	private Date fecha_modificacion;
	
	@NotNull
	@Column(name = "usuario_modificacion")
	private String usuario_modificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idpelicula")
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

	public int getPk_idfuncion() {
		return pk_idfuncion;
	}

	public void setPk_idfuncion(int pk_idfuncion) {
		this.pk_idfuncion = pk_idfuncion;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getUsuario_modificacion() {
		return usuario_modificacion;
	}

	public void setUsuario_modificacion(String usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
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

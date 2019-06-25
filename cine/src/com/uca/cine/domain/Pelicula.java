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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(schema="public",name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(generator="pelicula_pkidpelicula_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pelicula_pkidpelicula_seq", sequenceName = "public.pelicula_pkidpelicula_seq", allocationSize = 1)
	@Column(name = "pkidpelicula")
	private int pkidpelicula;
	
	@NotEmpty(message="Ingrese un nombre")
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private boolean estado;
	
	@NotNull
	@Column(name = "imagen")
	private String imagen;
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
	
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Funcion> funciones;
	
	public String getEstadoDelegate() {
		return estado == true ? "Activo":"Inactivo";
	}

	public int getPkidpelicula() {
		return pkidpelicula;
	}

	public void setPkidpelicula(int pkidpelicula) {
		this.pkidpelicula = pkidpelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}

		

}

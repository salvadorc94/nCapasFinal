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
	@GeneratedValue(generator="pelicula_pk_idpelicula_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pelicula_pk_idpelicula_seq", sequenceName = "public.pelicula_pk_idpelicula_seq", allocationSize = 1)
	@Column(name = "pk_idpelicula")
	private int pk_idpelicula;
	
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
	
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Funcion> funciones;
	
	public String getEstadoDelegate() {
		return estado == true ? "Activo":"Inactivo";
	}

	public int getPk_idpelicula() {
		return pk_idpelicula;
	}

	public void setPk_idpelicula(int pk_idpelicula) {
		this.pk_idpelicula = pk_idpelicula;
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

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	

}

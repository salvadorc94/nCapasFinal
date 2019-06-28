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
@Table(schema="public",name="tipof")
public class Tipof {
	@Id
	@GeneratedValue(generator="tipof_pkidtipof_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "tipof_pkidtipof_seq", sequenceName = "public.tipof_pkidtipof_seq", allocationSize = 1)
	@Column(name = "pkidtipof")
	private int pkidtipof;
	
	@NotNull
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "estado")
	private boolean estado;
	
	@NotNull
	@Column(name = "fechacreacion")
	private String fechacreacion;
	
	@NotNull
	@Column(name = "usuariocreacion")
	private String usuariocreacion;
	
	@NotNull
	@Column(name = "fechamodificacion")
	private String fechamodificacion;
	
	@NotNull
	@Column(name = "usuariomodificacion")
	private String usuariomodificacion;
	
	@OneToMany(mappedBy = "tipof", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Funcion> funcion;
	
	public String getEstadoDelegate() {
		return estado == true ? "Activo":"Inactivo";
	}

	public int getPkidtipof() {
		return pkidtipof;
	}

	public void setPkidtipof(int pkidtipof) {
		this.pkidtipof = pkidtipof;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	

	public String getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(String fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public String getUsuariocreacion() {
		return usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}


	public String getUsuariomodificacion() {
		return usuariomodificacion;
	}

	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}

	public List<Funcion> getFuncion() {
		return funcion;
	}

	public void setFuncion(List<Funcion> funcion) {
		this.funcion = funcion;
	}

	
	
}

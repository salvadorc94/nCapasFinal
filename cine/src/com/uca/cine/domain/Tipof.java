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
	@GeneratedValue(generator="tipof_pk_idtipof_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "tipof_pk_idtipof_seq", sequenceName = "public.tipof_pk_idtipof_seq", allocationSize = 1)
	@Column(name = "pk_idtipof")
	private int pk_idtipof;
	
	@NotEmpty(message="Ingrese el horario")
	@NotNull
	@Column(name = "horario")
	private String horario;
	
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
	
	@OneToMany(mappedBy = "tipof", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<TipoxFuncion> tipoxfuncion;
	
	public String getEstadoDelegate() {
		return estado == true ? "Activo":"Inactivo";
	}

	public int getPk_idtipof() {
		return pk_idtipof;
	}

	public void setPk_idtipof(int pk_idtipof) {
		this.pk_idtipof = pk_idtipof;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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

	public List<TipoxFuncion> getTipoxfuncion() {
		return tipoxfuncion;
	}

	public void setTipoxfuncion(List<TipoxFuncion> tipoxfuncion) {
		this.tipoxfuncion = tipoxfuncion;
	}
	
	
	
}

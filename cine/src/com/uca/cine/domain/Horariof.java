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
@Table(schema="public",name="horariof")
public class Horariof {
	
	@Id
	@GeneratedValue(generator="horariof_pkidhorariof_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "horariof_pkidhorariof_seq", sequenceName = "public.horariof_pkidhorariof_seq", allocationSize = 1)
	@Column(name = "pkidhorariof")
	private int pkidhorariof;
	
	@NotEmpty(message="Ingrese el tipo")
	@NotNull
	@Column(name = "tipo")
	private String tipo;
	
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
	
	@OneToMany(mappedBy = "horariof", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<HorarioxFuncion> horarioxfuncion;
	
	public String getEstadoDelegate() {
		return estado == true ? "Activo":"Inactivo";
	}

	public int getPkidhorariof() {
		return pkidhorariof;
	}

	public void setPkidhorariof(int pkidhorariof) {
		this.pkidhorariof = pkidhorariof;
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

	public List<HorarioxFuncion> getHorarioxfuncion() {
		return horarioxfuncion;
	}

	public void setHorarioxfuncion(List<HorarioxFuncion> horarioxfuncion) {
		this.horarioxfuncion = horarioxfuncion;
	}
	

}

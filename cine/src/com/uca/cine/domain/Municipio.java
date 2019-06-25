package com.uca.cine.domain;

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

import com.sun.istack.NotNull;

@Entity
@Table(schema="public", name="municipio")
public class Municipio {
	
	@Id
	@GeneratedValue(generator="municipio_pk_idmunicipio_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "municipio_pk_idmunicipio_seq", sequenceName = "public.municipio_pk_idmunicipio_seq", allocationSize = 1)
	@Column(name = "pk_idmunicipio")
	private int pk_idmunicipio;
	
	@NotNull
	@Column(name = "municipio")
	private String municipio;
	
	@OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Usuario> usuarios;

	public int getPk_idmunicipio() {
		return pk_idmunicipio;
	}

	public void setPk_idmunicipio(int pk_idmunicipio) {
		this.pk_idmunicipio = pk_idmunicipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}

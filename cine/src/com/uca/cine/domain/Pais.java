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
@Table(schema="public", name="pais")
public class Pais {
	
	@Id
	@GeneratedValue(generator="pais_pk_idpais_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pais_pk_idpais_seq", sequenceName = "public.pais_pk_idpais_seq", allocationSize = 1)
	@Column(name = "pk_idpais")
	private int pk_idpais;
	
	@NotNull
	@Column(name = "pais")
	private String pais;
	
	@OneToMany(mappedBy = "pais", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Usuario> usuarios;

	public int getPk_idpais() {
		return pk_idpais;
	}

	public void setPk_idpais(int pk_idpais) {
		this.pk_idpais = pk_idpais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}

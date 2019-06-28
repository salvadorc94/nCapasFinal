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
@Table(schema="public", name="tipo")
public class Tipo {
	
	@Id
	@GeneratedValue(generator="tipo_pkidtipo_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "tipo_pkidtipo_seq", sequenceName = "public.tipo_pkidtipo_seq", allocationSize = 1)
	@Column(name = "pkidtipo")
	private int pkidtipo;
	
	@NotNull
	@Column(name = "tipo")
	private String tipo;
	
	
	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Usuario> usuarios;

	public int getPkidtipo() {
		return pkidtipo;
	}

	public void setPkidtipo(int pkidtipo) {
		this.pkidtipo = pkidtipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	

}

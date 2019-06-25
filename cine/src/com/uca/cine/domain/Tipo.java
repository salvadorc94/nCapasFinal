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
	@GeneratedValue(generator="tipo_pk_idtipo_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "tipo_pk_idtipo_seq", sequenceName = "public.tipo_pk_idtipo_seq", allocationSize = 1)
	@Column(name = "pk_idtipo")
	private int pk_idtipo;
	
	@NotNull
	@Column(name = "tipo")
	private String tipo;
	
	@NotNull
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Usuario> usuarios;

	public int getPk_idtipo() {
		return pk_idtipo;
	}

	public void setPk_idtipo(int pk_idtipo) {
		this.pk_idtipo = pk_idtipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}

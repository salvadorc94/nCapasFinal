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
@Table(schema="public", name="departamento")
public class Departamento {

	@Id
	@GeneratedValue(generator="departamento_pk_iddepartamento_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "departamento_pk_iddepartamento_seq", sequenceName = "public.departamento_pk_iddepartamento_seq", allocationSize = 1)
	@Column(name = "pk_iddepartamento")
	private int pk_iddepartamento;
	
	@NotNull
	@Column(name = "departamento")
	private String departamento;
	
	@OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Usuario> usuarios;

	public int getPk_iddepartamento() {
		return pk_iddepartamento;
	}

	public void setPk_iddepartamento(int pk_iddepartamento) {
		this.pk_iddepartamento = pk_iddepartamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}

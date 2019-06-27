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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema="public",name="usuario")
public class Usuario {
	

	@Id
	@GeneratedValue(generator="usuario_pkidusuario_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "usuario_pkidusuario_seq", sequenceName = "public.usuario_pkidusuario_seq", allocationSize = 1)
	@Column(name = "pkidusuario")
	private int pkidusuario;
	
	@NotEmpty(message="Ingrese un nombre")
	@NotNull
	@Column(name = "nombre")
	private String nombre;
	
	@NotEmpty(message="Ingrese un apellido")
	@NotNull
	@Column(name = "apellido")
	private String apellido;
	
	@NotNull
	@Column(name = "fecha")
	private String fecha;
	
	@NotEmpty(message="Ingrese una direccion")
	@NotNull
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "estado")
	private boolean estado;
	
	@NotEmpty(message="Ingrese un nombre de usuario")
	@NotNull
	@Column(name = "nombreusuario")
	private String nombreusuario;
	
	@NotEmpty(message="Ingrese una contrasenia")
	@NotNull
	@Column(name = "contraseniausuario")
	private String contraseniausuario;
	
	@Column(name = "saldo")
	private int saldo;

	//FK_PAIS
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidpais")
	private Pais pais;

	//FK_MUNICIPIO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidmunicipio")
	private Municipio municipio;
	
	//FK_DEPARTAMENTO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkiddepartamento")
	private Departamento departamento;
	
	//FK_TIPO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkidtipo")
	private Tipo tipo;
	
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Historial> historial;
	
	public Usuario() {
		super();
	}
	public String getEstadoDelegate() {
		return estado == true ? "Activo":"Inactivo";
	}
	public int getPkidusuario() {
		return pkidusuario;
	}
	public void setPkidusuario(int pkidusuario) {
		this.pkidusuario = pkidusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	public List<Historial> getHistorial() {
		return historial;
	}
	public void setHistorial(List<Historial> historial) {
		this.historial = historial;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	
	public String getContraseniausuario() {
		return contraseniausuario;
	}
	public void setContraseniausuario(String contraseniausuario) {
		this.contraseniausuario = contraseniausuario;
	}
	
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
		
	
	
}

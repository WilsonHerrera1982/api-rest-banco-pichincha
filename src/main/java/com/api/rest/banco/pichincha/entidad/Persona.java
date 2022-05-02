package com.api.rest.banco.pichincha.entidad;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "persona", schema = "bancopichincha")
@EqualsAndHashCode(of = "personaId")
@ToString(of = "personaId")
public class Persona {

	@Id
	@Column(name = "persona_id")
	@GeneratedValue
	private UUID personaId;
	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "genero")
	private String genero;

	@Column(name = "edad")
	private int edad;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "direccion")
	private String direccion;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	private Cliente cliente;

	public UUID getPersonaId() {
		return personaId;
	}

	public void setPersonaId(UUID personaId) {
		this.personaId = personaId;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}

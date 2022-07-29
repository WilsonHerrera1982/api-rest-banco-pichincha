package com.api.rest.banco.pichincha.entidad;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "cliente", schema = "bancopichincha")
@EqualsAndHashCode(of = "clienteId")
@ToString(of = "clienteId")
public class Cliente {

	@Id
	@GeneratedValue
	@Column(name = "cliente_id")
	private UUID clienteId;
	@Column(name = "clave")
	private String clave;
	@Column(name = "estado")
	@Getter
	private boolean estado;
	@MapsId
    @JoinColumn(name = "cliente_id")
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Persona persona;
	
	public UUID getClienteId() {
		return clienteId;
	}
	public void setClienteId(UUID clienteId) {
		this.clienteId = clienteId;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	

}

package com.api.rest.banco.pichincha.entidad;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table (name ="cuenta", schema = "bancopichincha")
@EqualsAndHashCode(of = "cuentaId")
@ToString(of = "cuentaId")
public class Cuenta {

	@Id
    @GeneratedValue
    @Column(name = "cuenta_id")
    private UUID cuentaId;
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
     @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "limite_diario")
    private BigDecimal limiteDiario;
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    @ManyToOne
    private Cliente cliente;
    
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public UUID getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(UUID cuentaId) {
		this.cuentaId = cuentaId;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public BigDecimal getLimiteDiario() {
		return limiteDiario;
	}
	public void setLimiteDiario(BigDecimal limiteDiario) {
		this.limiteDiario = limiteDiario;
	}
	
    
}

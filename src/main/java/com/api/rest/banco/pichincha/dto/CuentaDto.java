package com.api.rest.banco.pichincha.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class CuentaDto {

	private String numeroCuenta;
	private UUID cuentaId;
	private String tipoCuenta;
	private BigDecimal saldoInicial;
	private BigDecimal limiteDiario;
	private String cliente;
	
	
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
	public BigDecimal getLimiteDiario() {
		return limiteDiario;
	}
	public void setLimiteDiario(BigDecimal limiteDiario) {
		this.limiteDiario = limiteDiario;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}

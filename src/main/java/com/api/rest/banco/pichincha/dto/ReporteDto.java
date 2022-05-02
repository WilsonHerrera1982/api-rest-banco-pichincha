package com.api.rest.banco.pichincha.dto;

import java.util.Date;

public class ReporteDto {
	
	private Date fecha;
	private String cliente;
	private String cuenta;
	private String tipo;
	private String saldoInicial;
	private String movimiento;
	private String saldo;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(String saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public String getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	
	

}

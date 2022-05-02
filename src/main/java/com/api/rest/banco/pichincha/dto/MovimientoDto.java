package com.api.rest.banco.pichincha.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class MovimientoDto {

	private UUID movimientoId;
	private String tipoMovimiento;
	private Date fecha;
	private BigDecimal valor;
	private String cuenta;
	public UUID getMovimientoId() {
		return movimientoId;
	}
	public void setMovimientoId(UUID movimientoId) {
		this.movimientoId = movimientoId;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	
}

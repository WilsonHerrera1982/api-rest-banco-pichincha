package com.api.rest.banco.pichincha.entidad;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "movimientos", schema = "bancopichincha")
@EqualsAndHashCode(of = "movimientoId")
@ToString(of = "movimientoId")
public class Movimiento {

	@Id
	@GeneratedValue
	@Column(name = "movimiento_id")
	private UUID movimientoId;
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@Column(name = "valor")
	private BigDecimal valor;
	@Column(name = "saldo")
	private BigDecimal saldo;
	@JoinColumn(name = "cuenta_id")
	@ManyToOne
	private Cuenta cuenta;
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
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
}

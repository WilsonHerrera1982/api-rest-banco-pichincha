package com.api.rest.banco.pichincha.controlador;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.banco.pichincha.dto.CuentaDto;
import com.api.rest.banco.pichincha.entidad.Cuenta;
import com.api.rest.banco.pichincha.entidad.Movimiento;
import com.api.rest.banco.pichincha.servicio.CuentaServicio;
import com.api.rest.banco.pichincha.servicio.MovimientoServicio;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaControlador {

	@Autowired
	private CuentaServicio cuentaServicio;
	@Autowired
	private MovimientoServicio movimientoServicio;

	@PostMapping("/guardar")
	private ResponseEntity guardar(@RequestBody CuentaDto cuenta) {
		Movimiento mov = new Movimiento();
		Cuenta cuen = new Cuenta();

		UUID uuid = UUID.randomUUID();
		try {
			ResponseEntity responseEntity = cuentaServicio.guardar(cuenta);
			cuen = cuentaServicio.obtenerXId(cuenta.getNumeroCuenta());
			mov.setMovimientoId(uuid);
			mov.setCuenta(cuen);
			mov.setFecha(new Date());
			mov.setSaldo(cuenta.getSaldoInicial());
			mov.setTipoMovimiento("Deposito");
			mov.setValor(cuenta.getSaldoInicial());
			movimientoServicio.guardarMovimiento(mov);
			return responseEntity;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}

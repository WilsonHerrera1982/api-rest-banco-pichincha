package com.api.rest.banco.pichincha.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.banco.pichincha.dto.CuentaDto;
import com.api.rest.banco.pichincha.servicio.CuentaServicio;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaControlador {

	@Autowired
	private CuentaServicio cuentaServicio;
	@PostMapping("/guardar")
	private ResponseEntity guardar(@RequestBody CuentaDto cuenta) {
		
		ResponseEntity responseEntity = cuentaServicio.guardar(cuenta);
		try {

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return responseEntity;

	}

}

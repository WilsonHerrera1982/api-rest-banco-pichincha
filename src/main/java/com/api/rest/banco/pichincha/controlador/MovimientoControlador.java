package com.api.rest.banco.pichincha.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.banco.pichincha.dto.MovimientoDto;
import com.api.rest.banco.pichincha.dto.ReporteDto;
import com.api.rest.banco.pichincha.entidad.Movimiento;
import com.api.rest.banco.pichincha.servicio.MovimientoServicio;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoControlador {

	@Autowired
	private MovimientoServicio movimientoServicio;

	@PostMapping("/guardar")
	private ResponseEntity guardar(@RequestBody MovimientoDto movimientoDto) {

		ResponseEntity responseEntity = movimientoServicio.guardar(movimientoDto);
		try {

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return responseEntity;

	}

	@GetMapping("/reporte")
	public List<ReporteDto> getReportIdentificacionAndBetween(@RequestParam String identificacion,
			@RequestParam Date fechaInicio, @RequestParam Date fechaFin) {
		List<Movimiento> lisMovimientos = new ArrayList<>();
		List<ReporteDto> listaRetorno = new ArrayList<>();
		lisMovimientos = movimientoServicio.reporte(identificacion, fechaInicio, fechaFin);
		for (Movimiento mov : lisMovimientos) {
			ReporteDto movi = new ReporteDto();
			movi.setCuenta(mov.getCuenta().getNumeroCuenta());
			movi.setFecha(mov.getFecha());
			movi.setCliente(mov.getCuenta().getCliente().getPersona().getNombre());
			movi.setMovimiento(mov.getValor().toString());
			movi.setSaldo(mov.getSaldo().toString());
			movi.setSaldoInicial(mov.getSaldo().toString());
			movi.setTipo(mov.getTipoMovimiento());
			listaRetorno.add(movi);
		}
		return listaRetorno;
	}
}

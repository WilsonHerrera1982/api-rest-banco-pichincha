package com.api.rest.banco.pichincha.servicio;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.rest.banco.pichincha.dto.MovimientoDto;
import com.api.rest.banco.pichincha.entidad.Cuenta;
import com.api.rest.banco.pichincha.entidad.Movimiento;
import com.api.rest.banco.pichincha.repositorio.CuentaRepositorio;
import com.api.rest.banco.pichincha.repositorio.MovimientoRepositorio;

@Service
public class MovimientoServicio {

	@Autowired
	private MovimientoRepositorio movimientoRepositorio;
	@Autowired
	private CuentaRepositorio cuentaRepositorio;

	public ResponseEntity guardar(MovimientoDto movimiento) {
		Optional<Cuenta> cuenta = cuentaRepositorio.findByNumeroCuenta(movimiento.getCuenta());
		String mensaje = "";
		List<Movimiento> listaMov = movimientoRepositorio.listaMovimientos(cuenta.get().getNumeroCuenta());
		if (listaMov.isEmpty()) {
			if (!movimiento.getTipoMovimiento().equals("Retiro")) {
				Movimiento movimiento2 = new Movimiento();
				movimiento2.setFecha(movimiento.getFecha());
				movimiento2.setMovimientoId(movimiento.getMovimientoId());
				movimiento2.setTipoMovimiento(movimiento.getTipoMovimiento());
				movimiento2.setCuenta(cuenta.get());
				movimiento2.setSaldo(cuenta.get().getSaldoInicial());
				movimiento2.setValor(movimiento.getValor());
				movimientoRepositorio.save(movimiento2);
				mensaje = "Registro guardardo con exito";
			}else {
				mensaje = "Saldo Insuficiente";
			}
		} else {
			List<Movimiento> lista = listaMov.stream().filter(mov -> mov.getFecha().equals(movimiento.getFecha()))
					.collect(Collectors.toList());
			List<Movimiento> ordenar = listaMov.stream().sorted(Comparator.comparing(Movimiento::getFecha).reversed())
					.toList();
			Movimiento movimiento2 = new Movimiento();
			movimiento2.setCuenta(listaMov.get(0).getCuenta());
			movimiento2.setFecha(movimiento.getFecha());
			movimiento2.setMovimientoId(movimiento.getMovimientoId());
			movimiento2.setTipoMovimiento(movimiento.getTipoMovimiento());
			if (movimiento.getTipoMovimiento().equals("Retiro")) {
				double suma = listaMov.stream().mapToDouble(m -> m.getValor().doubleValue()).sum();
				if (movimiento.getValor().compareTo(listaMov.get(0).getCuenta().getLimiteDiario()) == 0 || 
						movimiento.getValor().compareTo(listaMov.get(0).getCuenta().getLimiteDiario()) < 0) {
					mensaje = "Limite diario de retiro exedido";
					return null;
				} else if (ordenar.get(0).getSaldo().compareTo(movimiento.getValor()) < 0) {
					mensaje = "Saldo no disponible";
					return null;
				} else {
					movimiento2.setValor(movimiento.getValor().negate());
					movimiento2.setSaldo(ordenar.get(0).getSaldo().subtract(movimiento.getValor()));
					movimientoRepositorio.save(movimiento2);
					mensaje = "Registro guardardo con exito";
				}
			} else {

				movimiento2.setValor(movimiento.getValor());
				movimiento2.setSaldo(ordenar.get(0).getSaldo().add(movimiento.getValor()));
				movimientoRepositorio.save(movimiento2);
				mensaje = "Registro guardardo con exito";
			}
		}
		return ResponseEntity.ok(mensaje);
	}

	public List<Movimiento> reporte(String identificacion, Date fechaInicio, Date fechaFin) {

		return movimientoRepositorio.reporte(identificacion, fechaInicio, fechaFin);
	}
	
	public void guardarMovimiento(Movimiento mov) {
		movimientoRepositorio.save(mov);
	}
}

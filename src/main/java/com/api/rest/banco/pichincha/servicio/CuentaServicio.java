package com.api.rest.banco.pichincha.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.rest.banco.pichincha.dto.CuentaDto;
import com.api.rest.banco.pichincha.entidad.Cliente;
import com.api.rest.banco.pichincha.entidad.Cuenta;
import com.api.rest.banco.pichincha.entidad.Persona;
import com.api.rest.banco.pichincha.repositorio.ClienteRepositorio;
import com.api.rest.banco.pichincha.repositorio.CuentaRepositorio;

@Service
public class CuentaServicio {

	@Autowired
	private CuentaRepositorio cuentaRepositorio;
	@Autowired
	private PersonaServicio personaServicio;
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	public ResponseEntity guardar(CuentaDto cuenta) {
		String mensaje = "";
		Optional<Persona> persona = personaServicio.obtenerXIdentificacion(cuenta.getCliente());
		if (persona.get().getPersonaId() != null) {
			Cliente cliente = clienteRepositorio.findByPersona(persona);
			Cuenta cuenta2 = new Cuenta();
			cuenta2.setCuentaId(cuenta.getCuentaId());
			cuenta2.setCliente(cliente);
			cuenta2.setEstado(true);
			cuenta2.setLimiteDiario(cuenta.getLimiteDiario());
			cuenta2.setNumeroCuenta(cuenta.getNumeroCuenta());
			cuenta2.setSaldoInicial(cuenta.getSaldoInicial());
			cuenta2.setTipoCuenta(cuenta.getNumeroCuenta());
			Cuenta cuenta1 = cuentaRepositorio.findByNumeroCuenta(cuenta.getNumeroCuenta()).orElse(new Cuenta());
			if (cuenta1.getCuentaId() != null) {
				cuenta2 = new Cuenta();

				mensaje = "Cuenta con #" + cuenta.getNumeroCuenta() + " ya existe!";

			} else {
				cuentaRepositorio.save(cuenta2);
				mensaje = "Registro almacenado correctamente";
			}
		} else {
			mensaje = "Cliente con identificació #" + cuenta.getCliente() + "no existe!";
		}
		return ResponseEntity.ok(mensaje);

	}
	
	public Cuenta obtenerXId(String numero) {
		return cuentaRepositorio.findByNumeroCuenta(numero).orElse(new Cuenta());
	}
}

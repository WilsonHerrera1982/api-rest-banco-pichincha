package com.api.rest.banco.pichincha.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.rest.banco.pichincha.entidad.Cliente;
import com.api.rest.banco.pichincha.entidad.Persona;
import com.api.rest.banco.pichincha.repositorio.ClienteRepositorio;
import com.api.rest.banco.pichincha.repositorio.PersonaRepositorio;

@Service
public class ClienteServicio {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private PersonaRepositorio personaRepositorio;

	public ResponseEntity guardar(Cliente cliente) {
		String mensaje = "";
		Persona persona1 = personaRepositorio.findByIdentificacion(cliente.getPersona().getIdentificacion())
				.orElse(new Persona());
		if (persona1.getPersonaId() != null) {
			cliente = new Cliente();

			mensaje = "Cliente con esta identificacion ya existe!";

		} else {
			clienteRepositorio.save(cliente);
			mensaje = "Registro almacenado correctamente";
		}
		return ResponseEntity.ok(mensaje);

	}

	
}

package com.api.rest.banco.pichincha.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.banco.pichincha.entidad.Cliente;
import com.api.rest.banco.pichincha.entidad.Persona;
import com.api.rest.banco.pichincha.servicio.ClienteServicio;
import com.api.rest.banco.pichincha.servicio.PersonaServicio;

@RestController
@RequestMapping("/api/cliente")
public class PersonaControlador {

	@Autowired
	private PersonaServicio personaServicio;
	@Autowired
	private ClienteServicio clienteServicio;

	@PostMapping("/guardar")
	private ResponseEntity guardar(@RequestBody Cliente cliente) {

		ResponseEntity responseEntity = clienteServicio.guardar(cliente);
		try {

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return responseEntity;

	}

	@GetMapping("/listar")
	private ResponseEntity<List<Persona>> listarPersonas() {
		return ResponseEntity.ok(personaServicio.listarPersonas());

	}

	@GetMapping(value = "(id)")
	private ResponseEntity<Optional<Persona>> obtenerXId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(personaServicio.obtenerXId(id));

	}

	@DeleteMapping("/eliminar")
	private ResponseEntity<Persona> eliminar(@RequestBody Persona persona) {
		personaServicio.eliminar(persona);

		return ResponseEntity.ok().build();
	}

}

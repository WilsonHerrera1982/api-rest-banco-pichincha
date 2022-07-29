package com.api.rest.banco.pichincha.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.banco.pichincha.dto.ClienteDto;
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
	private ResponseEntity guardar(@RequestBody ClienteDto clienteDto) {
		UUID uuid = UUID.randomUUID();
		Cliente cliente = new Cliente();
		cliente.setClave(clienteDto.getClave());
		cliente.setClienteId(uuid);
		cliente.setEstado(true);
		Persona persona = new Persona();
		persona.setDireccion(clienteDto.getDireccion());
		persona.setEdad(clienteDto.getEdad());
		persona.setGenero(clienteDto.getGenero());
		persona.setPersonaId(uuid);
		persona.setTelefono(clienteDto.getTelefono());
		persona.setIdentificacion(clienteDto.getIdentificacion());
		persona.setNombre(clienteDto.getNombre());
		ResponseEntity responseEntity = clienteServicio.guardar(cliente, persona);

		try {

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return responseEntity;

	}

	@GetMapping("/listar")
	private ResponseEntity<List<ClienteDto>> listarPersonas() {
		List<ClienteDto> listaClientes = new ArrayList<>();

		for (Persona per : personaServicio.listarPersonas()) {
			ClienteDto cliente = new ClienteDto();
			cliente.setNombre(per.getNombre());
			cliente.setDireccion(per.getDireccion());
			cliente.setEdad(per.getEdad());
			cliente.setGenero(per.getGenero());
			cliente.setIdentificacion(per.getIdentificacion());
			cliente.setTelefono(per.getTelefono());
			listaClientes.add(cliente);
		}

		return ResponseEntity.ok(listaClientes);

	}

	@GetMapping("/consultar")
	private ResponseEntity<ClienteDto> obtenerXId(@RequestParam String identificacion) {

		ClienteDto cliente = new ClienteDto();
		Optional<Persona> per = personaServicio.obtenerXId(identificacion);
		if (per.isEmpty()) {
			return ResponseEntity.ok().header("Cliente", "No registrado").body(null);
		} else {
			cliente.setNombre(per.get().getNombre());
			cliente.setDireccion(per.get().getDireccion());
			cliente.setEdad(per.get().getEdad());
			cliente.setGenero(per.get().getGenero());
			cliente.setIdentificacion(per.get().getIdentificacion());
			cliente.setTelefono(per.get().getTelefono());
		}
		return ResponseEntity.ok(cliente);

	}

	@DeleteMapping("/eliminar")
	private ResponseEntity<Persona> eliminar(@RequestParam String identificacion) {
		personaServicio.eliminar(identificacion);

		return ResponseEntity.ok().build();
	}

}

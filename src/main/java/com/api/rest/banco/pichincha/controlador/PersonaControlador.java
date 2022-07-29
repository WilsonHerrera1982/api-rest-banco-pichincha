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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.banco.pichincha.dto.PersonaDto;
import com.api.rest.banco.pichincha.entidad.Cliente;
import com.api.rest.banco.pichincha.entidad.Persona;
import com.api.rest.banco.pichincha.servicio.ClienteServicio;
import com.api.rest.banco.pichincha.servicio.PersonaServicio;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/cliente")
public class PersonaControlador {

	@Autowired
	private PersonaServicio personaServicio;
	@Autowired
	private ClienteServicio clienteServicio;

	@PostMapping("/guardar")
	private ResponseEntity guardar(@RequestBody PersonaDto personaDto) {
		
		ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		try {
			if(personaDto.getClave().equals("")|| personaDto.getClave() == null || personaDto.getIdentificacion() == null
					|| personaDto.getNombre() == null) {
				String mensaje = "Revisar los datos ingresados";
				throw new Exception(mensaje);
			}
			Cliente cliente = new Cliente();
			cliente.setPersona(new Persona());
			cliente.getPersona().setDireccion(personaDto.getDireccion());
			cliente.getPersona().setEdad(Integer.valueOf(personaDto.getEdad()));
			cliente.getPersona().setGenero(personaDto.getGenero());
			cliente.getPersona().setIdentificacion(personaDto.getIdentificacion());
			cliente.getPersona().setNombre(personaDto.getNombre());
			cliente.getPersona().setTelefono(personaDto.getTelefono());
			cliente.setClave(personaDto.getClave());
			responseEntity = clienteServicio.guardar(cliente);
		} catch (Exception e) {		
			Logger.getLogger(PersonaControlador.class.getName()).log(Level.WARNING,null,e);			
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

	@GetMapping("/consultar")
	private ResponseEntity<Optional<Persona>> consultar(@RequestParam String identificacion) {
		return ResponseEntity.ok(personaServicio.obtenerXIdentificacion(identificacion));

	}
}

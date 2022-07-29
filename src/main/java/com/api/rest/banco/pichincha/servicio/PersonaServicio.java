package com.api.rest.banco.pichincha.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.banco.pichincha.entidad.Persona;
import com.api.rest.banco.pichincha.repositorio.PersonaRepositorio;

@Service
public class PersonaServicio {

	@Autowired
	private PersonaRepositorio personaRepositorio;

	public Persona guardar(Persona persona) {

		return personaRepositorio.save(persona);
	}

	public List<Persona> listarPersonas() {
		return personaRepositorio.findAll();
	}

	public void eliminar(String identificacion) {
		Optional<Persona> persona =personaRepositorio.findByIdentificacion(identificacion);
		persona.get().getCliente().setEstado(false);
		personaRepositorio.save(persona.get());
	}

	public Optional<Persona> obtenerXId(String id) {
		return personaRepositorio.findByIdentificacion(id);
	}

	public Optional<Persona> obtenerXIdentificacion(String id) {
		return personaRepositorio.findByIdentificacion(id);
	}
}

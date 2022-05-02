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

	public void eliminar(Persona persona) {
		personaRepositorio.delete(persona);
	}

	public Optional<Persona> obtenerXId(Long id) {
		return personaRepositorio.findById(id);
	}

	public Optional<Persona> obtenerXIdentificacion(String id) {
		return personaRepositorio.findByIdentificacion(id);
	}
}

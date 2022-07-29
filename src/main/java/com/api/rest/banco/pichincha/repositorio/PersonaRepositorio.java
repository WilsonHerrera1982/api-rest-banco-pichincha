package com.api.rest.banco.pichincha.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.banco.pichincha.entidad.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {

	Optional<Persona> findByIdentificacion(String identificacion);
}

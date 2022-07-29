package com.api.rest.banco.pichincha.repositorio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.banco.pichincha.entidad.Cliente;
import com.api.rest.banco.pichincha.entidad.Persona;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, UUID> {
	
	Cliente findByPersona(Optional<Persona> persona);
}

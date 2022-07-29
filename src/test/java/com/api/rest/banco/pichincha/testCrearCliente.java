package com.api.rest.banco.pichincha;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.api.rest.banco.pichincha.dto.PersonaDto;
import com.api.rest.banco.pichincha.entidad.Cliente;
import com.api.rest.banco.pichincha.entidad.Persona;
import com.api.rest.banco.pichincha.repositorio.ClienteRepositorio;

@DataJpaTest
public class testCrearCliente {
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Test
	public void testGuardarCliente() {
		Cliente cliente = new Cliente();
		cliente.setPersona(new Persona());
		PersonaDto dto = new PersonaDto();
		dto.setClave("123400");
		dto.setDireccion("Test");
		dto.setEdad("25");
		dto.setGenero("Masculino");
		dto.setIdentificacion("1234567897");
		dto.setNombre("María Parrales");
		dto.setTelefono("0.0.045");
		cliente.setClave(dto.getClave());
		cliente.getPersona().setDireccion(dto.getDireccion());
		cliente.getPersona().setEdad(Integer.valueOf(dto.getEdad()));
		cliente.getPersona().setGenero(dto.getGenero());
		cliente.getPersona().setIdentificacion(dto.getIdentificacion());
		cliente.getPersona().setNombre(dto.getNombre());
		cliente.getPersona().setTelefono(dto.getTelefono());
		clienteRepositorio.save(cliente);
	}

}

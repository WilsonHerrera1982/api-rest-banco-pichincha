package com.api.rest.banco.pichincha;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.api.rest.banco.pichincha.dto.CuentaDto;
import com.api.rest.banco.pichincha.dto.PersonaDto;
import com.api.rest.banco.pichincha.entidad.Cliente;
import com.api.rest.banco.pichincha.entidad.Cuenta;
import com.api.rest.banco.pichincha.entidad.Persona;
import com.api.rest.banco.pichincha.repositorio.CuentaRepositorio;

@DataJpaTest
public class testCrearCuenta {

	
	@Autowired
	private CuentaRepositorio cuentaRepositorio;
	
	@Test
	public void testCrearCuenta() {
		Cuenta cuenta = new Cuenta();
		cuenta.setCliente(new Cliente());
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
		CuentaDto cdto = new CuentaDto();
		cdto.setCliente("13265656");
		cdto.setLimiteDiario(new BigDecimal(1000));
		cdto.setNumeroCuenta("1324545");
		cdto.setSaldoInicial(new BigDecimal(200));
		cuenta.setCliente(cliente);
		cuenta.setEstado(true);
		cuenta.setLimiteDiario(cdto.getLimiteDiario());
		cuenta.setNumeroCuenta(cdto.getNumeroCuenta());
		cuenta.setSaldoInicial(cdto.getSaldoInicial());
		cuenta.setTipoCuenta("Ahorros");
		cuentaRepositorio.save(cuenta);
	}
}

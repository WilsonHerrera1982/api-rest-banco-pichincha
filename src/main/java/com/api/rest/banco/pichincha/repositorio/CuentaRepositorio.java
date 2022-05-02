package com.api.rest.banco.pichincha.repositorio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.banco.pichincha.entidad.Cuenta;


public interface CuentaRepositorio extends JpaRepository<Cuenta,UUID>{

		Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);	
}

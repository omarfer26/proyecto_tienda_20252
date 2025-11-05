package com.ufps.prueba.repositories;

import com.ufps.prueba.entities.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public List<Cliente> findByName(String nombre);
	public List<Cliente> findByNameContaining(String nombre);
	
}

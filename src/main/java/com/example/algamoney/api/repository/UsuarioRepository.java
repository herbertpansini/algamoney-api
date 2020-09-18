package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.algamoney.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByEmail(String email);
}
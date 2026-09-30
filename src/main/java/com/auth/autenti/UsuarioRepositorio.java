package com.auth.autenti;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}

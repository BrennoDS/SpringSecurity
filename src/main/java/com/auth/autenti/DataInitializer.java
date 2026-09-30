package com.auth.autenti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration 
public class DataInitializer {
    @Bean 
    CommandLineRunner criarUsuario(UsuarioRepositorio repositorio, PasswordEncoder encoder){
        return args ->{
            if(repositorio.findByEmail("teste@email.com").isEmpty()){
                Usuario usuario = Usuario.builder()
                    .email("teste@email.com")
                    .senha(encoder.encode("123456"))
                    .build();
                repositorio.save(usuario);
            }
        };
    }
}

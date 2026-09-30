package com.auth.autenti;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service 
public class UsuarioDetailsServiceImpl implements UserDetailsService{
    
    private final UsuarioRepositorio usuarioRepositorio;

    

    public UsuarioDetailsServiceImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepositorio.findByEmail(username)
                .map(UsuarioDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
        
    }
}

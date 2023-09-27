package com.example.demo.service;

import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastroUsuarioService {
    private static UsuarioRepository usuarioRepository;

    public CadastroUsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public static String cadastrarUsuario(){

    }
}

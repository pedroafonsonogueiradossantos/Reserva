package com.example.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class CadastroUsuarioController {
	
	public String paginaCadastro() {
		return "cadastro/usuario";
	}
}

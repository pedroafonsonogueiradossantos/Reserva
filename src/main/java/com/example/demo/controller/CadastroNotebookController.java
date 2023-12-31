package com.example.demo.controller;

import com.example.demo.service.CadastroNotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastroNotebookController {

	@Autowired
	CadastroNotebookService cadastroNotebookService;

	@GetMapping("/cadastro/notebook")
	public String getPage() {
		return "cadastro/notebook";
	}
	@PostMapping("/cadastro/notebook")
	public String postNotebook(@RequestParam("numero") String numero,
							   @RequestParam("numeroPatrimonio") String numeroPatrimonio,
							   Model model) {
		model.addAttribute("numero", numero);
		model.addAttribute("numeroPatrimonio", numeroPatrimonio);
		cadastroNotebookService.cadastrarNotebook(numero, numeroPatrimonio);
		return "/cadastro/notebook";
	}
}

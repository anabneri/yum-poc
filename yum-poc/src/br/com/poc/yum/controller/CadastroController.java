package br.com.poc.yum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroController {
	@RequestMapping("/cadastro")
	public String loginPagina() {
		return "Cadastro";
	}
}

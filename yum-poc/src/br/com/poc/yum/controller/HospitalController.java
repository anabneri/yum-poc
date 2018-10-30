package br.com.poc.yum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.poc.yum.dao.HospitalDao;
import br.com.poc.yum.modelos.Hospital;

@Controller
public class HospitalController {
	@RequestMapping("/cadastro")
	public String paginaCadastro() {
		return "Cadastro";
	}

	@RequestMapping(value = "sucesso-cadastro", method = RequestMethod.POST) // Padrao
	public String adiciona(Hospital hospital) throws ClassNotFoundException {
		HospitalDao dao = new HospitalDao();
		dao.adiciona(hospital);
		return "redirect:login";
	}

	@RequestMapping("/login")
	public String loginPagina() {
		return "Login";

	}

	@RequestMapping(value = "loginEfetuado", method = RequestMethod.GET)
	public String verificar(Hospital hospital) throws ClassNotFoundException {

		HospitalDao dao = new HospitalDao();

		if (dao.verificar(hospital)) {
			return "index";
		}

		return "redirect:login";

	}

}
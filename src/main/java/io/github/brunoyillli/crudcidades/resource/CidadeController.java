package io.github.brunoyillli.crudcidades.resource;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.brunoyillli.crudcidades.entity.Cidade;

@Controller
public class CidadeController {
	
	@GetMapping("/")
	public String listar(Model memoria) {
		
		Set<Cidade> cidades = Set.of(
			new Cidade("Cornelio Procopio","PR"),
			new Cidade("Assis","SP"),
			new Cidade("Itajai", "SC")
		);
		
		memoria.addAttribute("listaCidades", cidades);
		return "crud";
	}
}

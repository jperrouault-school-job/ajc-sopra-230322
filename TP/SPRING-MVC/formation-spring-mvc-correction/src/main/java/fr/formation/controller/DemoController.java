package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DemoController {

//	@RequestMapping("/demo")
	@GetMapping("/demo")
	public String demonstration(HttpSession session, Model model) {
		// Pour transmettre des infos du contrôleur vers la vue
		model.addAttribute("variable", "la valeur de la variable");
		
//		return "/WEB-INF/demo.jsp";
		return "demo";
	}
	
	@PostMapping("/demo")
	public String postDemo(@RequestParam String username, @RequestParam(required = false) Float prix) {
		System.out.println("POST passé ici ..");
		System.out.println(username);
		System.out.println(prix);
		
		return "demo";
	}
	
}

package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

//	@RequestMapping("/demo")
	@GetMapping("/demo")
	public String demonstration() {
//		return "/WEB-INF/demo.jsp";
		return "demo";
	}
	
	@PostMapping("/demo")
	public String postDemo() {
		System.out.println("POST passé ici ..");
		
		return "demo";
	}
	
}

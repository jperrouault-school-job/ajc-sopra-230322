package fr.formation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Produit;

//@Controller
//@ResponseBody
@RestController
public class DemoApiController {
	@GetMapping("/api/demo")
	public Produit demo() {
		return new Produit();
	}
}

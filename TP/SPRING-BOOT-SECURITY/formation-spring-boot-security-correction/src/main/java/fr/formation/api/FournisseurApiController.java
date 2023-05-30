package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurApiController {
	@Autowired
	private IFournisseurRepository repoFournisseur;
	
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public List<Fournisseur> findAll() {
		return this.repoFournisseur.findAll();
	}
}

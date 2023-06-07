package fr.formation.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.request.ProduitRequest;
import fr.formation.api.response.ProduitResponse;
import fr.formation.exception.EntityNotFoundException;
import fr.formation.exception.EntityNotValidException;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produit")
public class ProduitApiController {
	@Autowired
	private IProduitRepository repoProduit;
	
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public List<ProduitResponse> findAll() {
		return this.repoProduit.findAll()
				.stream()
				.map(ProduitResponse::new)
				.toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public ProduitResponse add(@Valid @RequestBody ProduitRequest produitRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}
		
		Produit produit = new Produit();
		Fournisseur fournisseur = new Fournisseur();
		
		BeanUtils.copyProperties(produitRequest, produit);
		
		produit.setFournisseur(fournisseur);
		fournisseur.setId(produitRequest.getFournisseurId());
		
		this.repoProduit.save(produit);
		
		return new ProduitResponse(produit);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ProduitResponse edit(@PathVariable int id, @Valid @RequestBody ProduitRequest produitRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}
		
		Produit produit = this.repoProduit.findById(id).orElseThrow(EntityNotFoundException::new);
		
		BeanUtils.copyProperties(produitRequest, produit);
		
		this.repoProduit.save(produit);
		
		return new ProduitResponse(produit);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(@PathVariable int id) {
		try {
			this.repoProduit.deleteById(id);			
		}
		
		catch (Exception ex) {
			
		}
	}
}

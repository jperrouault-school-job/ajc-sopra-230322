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

import fr.formation.api.request.FournisseurRequest;
import fr.formation.api.response.FournisseurResponse;
import fr.formation.exception.EntityNotFoundException;
import fr.formation.exception.EntityNotValidException;
import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurApiController {
	@Autowired
	private IFournisseurRepository repoFournisseur;
	
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public List<FournisseurResponse> findAll() {
		return this.repoFournisseur.findAll()
				.stream()
				.map(FournisseurResponse::new)
				.toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public FournisseurResponse add(@Valid @RequestBody FournisseurRequest fournisseurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}
		
		Fournisseur fournisseur = new Fournisseur();
		
		BeanUtils.copyProperties(fournisseurRequest, fournisseur);
		
		this.repoFournisseur.save(fournisseur);
		
		return new FournisseurResponse(fournisseur);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public FournisseurResponse edit(@PathVariable int id, @Valid @RequestBody FournisseurRequest fournisseurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new EntityNotValidException();
		}
		
		Fournisseur fournisseur = this.repoFournisseur.findById(id).orElseThrow(EntityNotFoundException::new);
		
		BeanUtils.copyProperties(fournisseurRequest, fournisseur);
		
		this.repoFournisseur.save(fournisseur);
		
		return new FournisseurResponse(fournisseur);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(@PathVariable int id) {
		try {
			this.repoFournisseur.deleteById(id);			
		}
		
		catch (Exception ex) {
			
		}
	}
}

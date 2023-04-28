package fr.formation.repo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.formation.config.AppConfig;
import fr.formation.model.Fournisseur;
import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class FournisseurRepositoryTest {
	private static final int FOURNISSEUR_ID = 1;
	
	@Autowired
	private IFournisseurRepository repoFournisseur;

	@Test
	@Transactional
	void shouldFindById() {
		// given
		
		// when
		Optional<Fournisseur> optFournisseur = this.repoFournisseur.findById(FOURNISSEUR_ID);
		
		// then
		Assertions.assertTrue(optFournisseur.isPresent());
		Assertions.assertEquals(FOURNISSEUR_ID, optFournisseur.get().getId());
		Assertions.assertEquals("GOPRO", optFournisseur.get().getNom());
		Assertions.assertEquals("Albert", optFournisseur.get().getResponsable());
		Assertions.assertEquals(2, optFournisseur.get().getProduits().size());
	}

	@Test
	void shouldFindByIdNotFound() {
		// given
		
		// when
		Optional<Fournisseur> optFournisseur = this.repoFournisseur.findById(10);
		
		// then
		Assertions.assertFalse(optFournisseur.isPresent());
	}

	@Test
	void shouldFindAll() {
		// given
		
		// when
		List<Fournisseur> fournisseurs = this.repoFournisseur.findAll();
		
		// then
		Assertions.assertNotNull(fournisseurs);
		Assertions.assertEquals(3, fournisseurs.size());
	}

	@Test
	void shouldAdd() {
		// given
		Fournisseur fournisseur = new Fournisseur();

		fournisseur.setNom("Nouveau test");
		fournisseur.setResponsable("Responsable test");
		
		Assertions.assertEquals(0, fournisseur.getId());
		
		// when
		fournisseur = this.repoFournisseur.save(fournisseur);
		
		// then
		Assertions.assertNotEquals(0, fournisseur.getId());
		Assertions.assertEquals(4, this.repoFournisseur.findAll().size());
	}

	@Test
	void shouldFindByNomReturnFournisseur() {
		// given
		
		// when
		Fournisseur fournisseur = this.repoFournisseur.findByNom("Basik");
		
		// then
		Assertions.assertNotNull(fournisseur);
		Assertions.assertEquals(3, fournisseur.getId());
	}

	@Test
	void shouldFindByNomReturnNull() {
		// given
		
		// when
		Fournisseur fournisseur = this.repoFournisseur.findByNom("NOT");
		
		// then
		Assertions.assertNull(fournisseur);
	}
}

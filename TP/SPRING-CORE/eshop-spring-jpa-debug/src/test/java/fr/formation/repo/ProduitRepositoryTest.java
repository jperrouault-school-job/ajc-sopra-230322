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
import fr.formation.model.Produit;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class ProduitRepositoryTest {
	private static final int PRODUIT_ID = 1;
	
	@Autowired
	private IProduitRepository repoProduit;

	@Test
	void shouldFindById() {
		// given
		
		// when
		Optional<Produit> optProduit = this.repoProduit.findById(PRODUIT_ID);
		
		// then
		Assertions.assertTrue(optProduit.isPresent());
		Assertions.assertEquals(PRODUIT_ID, optProduit.get().getId());
		Assertions.assertEquals("GoPRO HERO 7", optProduit.get().getNom());
		Assertions.assertEquals(349.99f, optProduit.get().getPrix());
		Assertions.assertNotNull(optProduit.get().getFournisseur());
		Assertions.assertEquals(1, optProduit.get().getFournisseur().getId());
	}

	@Test
	void shouldFindByIdNotFound() {
		// given
		
		// when
		Optional<Produit> optProduit = this.repoProduit.findById(100);
		
		// then
		Assertions.assertFalse(optProduit.isPresent());
	}

	@Test
	void shouldFindAll() {
		// given
		
		// when
		List<Produit> produits = this.repoProduit.findAll();
		
		// then
		Assertions.assertNotNull(produits);
		Assertions.assertEquals(7, produits.size());
	}

	@Test
	void shouldFindAllByPrixBetween500And1000Return3() {
		// given
		
		// when
		List<Produit> produits = this.repoProduit.findByPrixBetween(500, 1000);
		
		// then
		Assertions.assertEquals(3, produits.size());
	}

	@Test
	void shouldFindAllByPrixBetween1000And2000Return1() {
		// given
		
		// when
		List<Produit> produits = this.repoProduit.findByPrixBetween(1000, 2000);
		
		// then
		Assertions.assertEquals(1, produits.size());
	}

	@Test
	void shouldFindAllByPrixBetween100And2000Return6() {
		// given
		
		// when
		List<Produit> produits = this.repoProduit.findByPrixBetween(100, 2000);
		
		// then
		Assertions.assertEquals(6, produits.size());
	}

	@Test
	void shouldFindAllByPrixBetween100And200Return0() {
		// given
		
		// when
		List<Produit> produits = this.repoProduit.findByPrixBetween(100, 200);
		
		// then
		Assertions.assertNotNull(produits);
		Assertions.assertEquals(0, produits.size());
	}

	@Test
	void shouldAdd() {
		// given
		Fournisseur fournisseur = new Fournisseur();
		Produit produit = new Produit();

		fournisseur.setId(2);
		
		produit.setNom("Produit test");
		produit.setModele("MOD");
		produit.setReference("REF");
		produit.setPrix(50);
		produit.setFournisseur(fournisseur);
		
		Assertions.assertEquals(0, produit.getId());
		
		// when
		produit = this.repoProduit.save(produit);
		
		// then
		Assertions.assertNotEquals(0, produit.getId());
		Assertions.assertEquals(8, this.repoProduit.findAll().size());
	}
}

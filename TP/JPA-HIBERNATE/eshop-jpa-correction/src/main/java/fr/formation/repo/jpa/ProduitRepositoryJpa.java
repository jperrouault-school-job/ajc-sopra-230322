package fr.formation.repo.jpa;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProduitRepositoryJpa implements IProduitRepository {

	@Override
	public List<Produit> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		EntityManager em = emf.createEntityManager();
		
		List<Produit> produits = em
			.createQuery("select p from Produit p", Produit.class)
			.getResultList();
		
		em.close();
		
		return produits;
	}

	@Override
	public Optional<Produit> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Produit save(Produit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produit> findByPrixBetween(float a, float b) {
		// TODO Auto-generated method stub
		return null;
	}

}

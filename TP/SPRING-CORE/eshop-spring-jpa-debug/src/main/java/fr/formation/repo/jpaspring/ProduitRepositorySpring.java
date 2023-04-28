package fr.formation.repo.jpaspring;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ProduitRepositorySpring implements IProduitRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Produit> findAll() {
		return em.createQuery("select p from Produit p", Produit.class).getResultList();
	}

	@Override
	public Optional<Produit> findById(Integer id) {
		return Optional.ofNullable(em.find(Produit.class, id));
	}

	@Override
	@Transactional
	public Produit save(Produit entity) {
		if (entity.getId() == 0) {
			em.persist(entity);
		}
		
		else {
			entity = em.merge(entity);
		}
		
		return entity;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		em.remove(em.find(Produit.class, id));
	}

	@Override
	public List<Produit> findByPrixBetween(float a, float b) {
		return em
				.createQuery("select p from Produit p where p.prix between ?1 and ?2", Produit.class)
				.setParameter(1, a)
				.setParameter(2, b)
				.getResultList();
	}
}

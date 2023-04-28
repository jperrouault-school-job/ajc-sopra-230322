package fr.formation.repo.jpaspring;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class FournisseurRepositorySpring implements IFournisseurRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Fournisseur> findAll() {
		return em	.createQuery("select f from Fournisseur f", Fournisseur.class)
					.getResultList();
	}

	@Override
	public Optional<Fournisseur> findById(Integer id) {
		return Optional.ofNullable(em.find(Fournisseur.class, id));
	}

	@Override
	@Transactional
	public Fournisseur save(Fournisseur entity) {
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
		em.remove(em.find(Fournisseur.class, id));
	}

	@Override
	public Fournisseur findByNom(String nom) {
		try {
			return em
					.createQuery("select f from Fournisseur f where f.nom = ?1", Fournisseur.class)
					.setParameter(1, nom)
					.getSingleResult();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

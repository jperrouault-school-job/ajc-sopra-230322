package fr.formation.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import jakarta.persistence.EntityManager;

public class ProduitRepositoryJpa extends AbstractRepositoryJpa implements IProduitRepository {
	@Override
	public List<Produit> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select p from Produit p", Produit.class)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Produit> findById(Integer id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Produit.class, id));
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Produit save(Produit entity) {
		try (EntityManager em = emf.createEntityManager()) {
			em.getTransaction().begin();
			
			try {
				if (entity.getId() == 0) {
					em.persist(entity);
				}
				
				else {
					entity = em.merge(entity);
				}
				
				em.getTransaction().commit();
			}
			
			catch (Exception ex) {
				ex.printStackTrace();
				em.getTransaction().rollback();
			}
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return entity;
	}

	@Override
	public void deleteById(Integer id) {
		try (EntityManager em = emf.createEntityManager()) {
			em.getTransaction().begin();
			
			try {
				em.remove(em.find(Produit.class, id));
				em.getTransaction().commit();
			}
			
			catch (Exception ex) {
				em.getTransaction().rollback();
			}
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Produit> findByPrixBetween(float a, float b) {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select p from Produit p where p.prix between ?1 and ?2", Produit.class)
				.setParameter(1, a)
				.setParameter(2, b)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
}

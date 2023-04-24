package fr.formation.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import jakarta.persistence.EntityManager;

public class FournisseurRepositoryJpa extends AbstractRepositoryJpa implements IFournisseurRepository {
	@Override
	public List<Fournisseur> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select f from Fournisseur f", Fournisseur.class)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Fournisseur> findById(Integer id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Fournisseur.class, id));
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
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
				em	.createQuery("delete from Fournisseur f where f.id = ?1")
					.setParameter(1, id)
					.executeUpdate();
				
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
	}

	@Override
	public Fournisseur findByNom(String nom) {
		try (EntityManager em = emf.createEntityManager()) {
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

	@Override
	public List<Fournisseur> findAllWithProduits() {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select f from Fournisseur f left join f.produits p", Fournisseur.class)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
}

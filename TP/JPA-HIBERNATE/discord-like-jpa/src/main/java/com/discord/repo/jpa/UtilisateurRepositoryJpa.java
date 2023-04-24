package com.discord.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.discord.model.Utilisateur;
import com.discord.repo.IUtilisateurRepository;

import jakarta.persistence.EntityManager;

public class UtilisateurRepositoryJpa extends AbstractRepositoryJpa implements IUtilisateurRepository {
	@Override
	public List<Utilisateur> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select u from Utilisateur u", Utilisateur.class)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Utilisateur> findById(Integer id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Utilisateur.class, id));
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
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
				em	.createQuery("delete from Utilisateur u where u.id = ?1")
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
	public Optional<Utilisateur> findByUsername(String username) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(
				em	.createQuery("select u from Utilisateur u where u.username = ?1", Utilisateur.class)
					.setParameter(1, username)
					.getSingleResult()
			);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}
}

package fr.formation.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Client;
import fr.formation.repo.IClientRepository;
import jakarta.persistence.EntityManager;

public class ClientRepositoryJpa extends AbstractRepositoryJpa implements IClientRepository {
	@Override
	public List<Client> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select c from client c", Client.class)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Client> findById(Integer id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Client.class, id));
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Client save(Client entity) {
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
				em	.createQuery("delete from Client c where c.id = ?1")
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
}

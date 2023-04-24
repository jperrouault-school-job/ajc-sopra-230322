package com.discord.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.discord.model.Salon;
import com.discord.repo.ISalonRepository;

import jakarta.persistence.EntityManager;

public class SalonRepositoryJpa extends AbstractRepositoryJpa implements ISalonRepository {
	@Override
	public List<Salon> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select s from Salon s", Salon.class)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Salon> findById(Integer id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Salon.class, id));
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Salon save(Salon entity) {
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
				em	.createQuery("delete from Salon s where s.id = ?1")
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

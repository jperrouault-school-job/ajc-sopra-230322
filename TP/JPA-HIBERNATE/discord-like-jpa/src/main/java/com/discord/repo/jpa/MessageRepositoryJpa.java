package com.discord.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.discord.model.Message;
import com.discord.repo.IMessageRepository;

import jakarta.persistence.EntityManager;

public class MessageRepositoryJpa extends AbstractRepositoryJpa implements IMessageRepository {
	@Override
	public List<Message> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select m from Message m", Message.class)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Message> findById(Integer id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Message.class, id));
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Message save(Message entity) {
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
				em	.createQuery("delete from Message m where m.id = ?1")
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
	public List<Message> findAllTop10BySalonId(int salonId) {
		try (EntityManager em = emf.createEntityManager()) {
			return em
				.createQuery("select m from Message m where m.salon.id = ?1", Message.class)
				.setParameter(1, salonId)
				.setMaxResults(10)
				.getResultList();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
}

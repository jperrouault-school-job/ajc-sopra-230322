package fr.formation.repo.jpaspring;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;

@Repository
public class ProduitRepositorySpring implements IProduitRepository {
	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
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

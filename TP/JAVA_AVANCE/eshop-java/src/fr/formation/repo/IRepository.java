package fr.formation.repo;

import java.util.List;

// Ce grand T, ça sera le Type qu'on définira dans les implémentations
// Et ça devient un "Type" qu'on peut utiliser dans notre interface
public interface IRepository<T> {
	public List<T> findAll();
}

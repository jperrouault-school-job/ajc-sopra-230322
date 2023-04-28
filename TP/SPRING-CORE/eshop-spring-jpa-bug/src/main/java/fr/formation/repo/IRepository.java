package fr.formation.repo;

import java.util.List;
import java.util.Optional;

// Ce grand T, ça sera le Type qu'on définira dans les implémentations
// Et ça devient un "Type" qu'on peut utiliser dans notre interface
public interface IRepository<T, ID> {
	// Liste des objets
	public List<T> findAll();
	
	// Un objet par son ID
	public Optional<T> findById(ID id);
	
	// Sauvegarde d'un objet
	public T save(T entity);
	
	// Suppression d'un objet par son ID
	public void deleteById(ID id);
}

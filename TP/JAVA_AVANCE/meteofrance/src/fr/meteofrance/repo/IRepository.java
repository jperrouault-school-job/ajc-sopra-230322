package fr.meteofrance.repo;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
	public List<T> findAll();
	public Optional<T> findById(int id);
	public T save(T entity);
	public void deleteById(int id);
}

package fr.formation.repo;

import org.springframework.stereotype.Repository;

import fr.formation.annotation.CustomTransactional;

@Repository
@CustomTransactional
public class DemoRepositorySpring {
	@CustomTransactional
	public String save(String demo) {
//		System.out.println("OUVERTURE ENTITY MANAGER");
//		System.out.println("CREATION TRANSACTION");
		
		System.out.println("SAUVEGARDE ...");
		
		if (false) {
			throw new RuntimeException();
		}
		
//		System.out.println("COMMIT TRANSACTION");
//		System.out.println("FERMETURE ENTITY MANAGER");
		
		return "ok";
	}
}

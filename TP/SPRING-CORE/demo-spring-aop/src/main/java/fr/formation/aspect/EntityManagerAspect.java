package fr.formation.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EntityManagerAspect {
	@Before("execution(* fr.formation.repo.DemoRepositorySpring.save(..))")
	public void openEntityManager() {
		System.out.println("[ASPECT] OUVERTURE ENTITY MANAGER");
	}
	
	@After("execution(* fr.formation.repo.DemoRepositorySpring.save(..))")
	public void closeEntityManager() {
		System.out.println("[ASPECT] FERMETURE ENTITY MANAGER");
	}
}

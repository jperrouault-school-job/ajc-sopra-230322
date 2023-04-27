package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.repo.DemoRepositorySpring;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		DemoRepositorySpring repoDemo = context.getBean(DemoRepositorySpring.class);
		
		repoDemo.save("demo");
	}
}

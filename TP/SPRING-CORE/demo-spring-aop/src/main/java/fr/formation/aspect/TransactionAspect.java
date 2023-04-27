package fr.formation.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {
	@Before("@annotation(fr.formation.annotation.CustomTransactional)")
	public void beginTransaction() {
		System.out.println("[ASPECT] CREATION TRANSACTION");
	}
	
	@AfterReturning("@annotation(fr.formation.annotation.CustomTransactional)")
	public void commitTransaction() {
		System.out.println("[ASPECT] COMMIT TRANSACTION");
	}
	
	@AfterThrowing("@annotation(fr.formation.annotation.CustomTransactional)")
	public void rollbackTransaction() {
		System.out.println("[ASPECT] ROLLBACK TRANSACTION");
	}
}

package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathsTest {
	@Test
	public void shouldReturn10When5And5() {
		// given
		Maths maths = new Maths();
		
		// when
		int result = maths.additionner(5, 5);
		
		// then
		Assertions.assertEquals(10, result);
	}
	
	@Test
	public void shouldReturn50When35And15() {
		// given
		Maths maths = new Maths();
		
		// when
		int result = maths.additionner(35, 15);
		
		// then
		Assertions.assertEquals(50, result);
	}
}

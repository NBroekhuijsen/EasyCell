package Functions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MilaFormulesTest {
	
	@Test
	public void testSum() {
		
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1);
		testarli1.add(2);
		testarli1.add(3);
		testarli1.add(4);
		
		ArrayList<Object> testarli2 = new ArrayList<Object>();	
		testarli1.add(2);
		testarli1.add(2);
		testarli1.add(2);
		testarli1.add(5);
		testarli1.add(5);
		
		ArrayList<Object> testlijst1 = new ArrayList<Object>();
		testlijst1.add("blabla");
		testlijst1.add(2);
		
		ArrayList<Object> testlijst2 = new ArrayList<Object>();
		testlijst2.add("blabla");
		
		assertEquals("10.0", MilaFormules.sum(testarli1));
		assertEquals("16.0", MilaFormules.sum(testarli2));
		assertNotSame("100.0", MilaFormules.sum(testarli1));
		assertNotSame("15.0", MilaFormules.sum(testarli2));
		assertTrue(MilaFormules.sum(testlijst1).equals("2"));
		assertTrue(MilaFormules.sum(testlijst2).equals("0"));
	}
	
	
	@Test
	public void testSumif() {
		
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1);
		testarli1.add(2);
		testarli1.add(3);
		testarli1.add(4);
		
		ArrayList<Object> testarli2 = new ArrayList<Object>();	
		testarli1.add(2);
		testarli1.add(2);
		testarli1.add(2);
		testarli1.add(5);
		testarli1.add(5);
		
		ArrayList<Object> testlijst1 = new ArrayList<Object>();
		testlijst1.add(2);
		testlijst1.add("blabla");
		testlijst1.add(2);
		
		ArrayList<Object> testlijst2 = new ArrayList<Object>();
		testlijst2.add(1);
		testlijst2.add("blabla");
		
		assertEquals("0.0", MilaFormules.sumif(testarli1));
		assertEquals("4.0", MilaFormules.sumif(testarli2));
		assertNotSame("100.0", MilaFormules.sumif(testarli1));
		assertNotSame("15.0", MilaFormules.sumif(testarli2));
		assertTrue(MilaFormules.sumif(testlijst1).equals("1"));
		assertTrue(MilaFormules.sumif(testlijst2).equals("0"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSumifException() {
		ArrayList<Object> testlijst1 = new ArrayList<Object>();
		testlijst1.add(1);
		assertTrue(MilaFormules.sumif(testlijst1).equals(1));
	}
	
	@Test
	public void testSign() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1);
		testarli1.add(2);
		testarli1.add(3);
		testarli1.add(4);
		
		
	}

}

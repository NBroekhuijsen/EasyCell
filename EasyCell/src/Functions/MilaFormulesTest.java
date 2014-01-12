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
		assertTrue(MilaFormules.sumif(testlijst1).equals("1"));
	}
	
	@Test
	public void testSign() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(5);
		assertTrue(MilaFormules.sign(testarli1).equals("1"));
	}
	
	@Test
	public void testSignMinus() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(-5);
		assertTrue(MilaFormules.sign(testarli1).equals("-1"));
	}
	
	@Test
	public void testSignZero() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0);
		assertTrue(MilaFormules.sign(testarli1).equals("0"));
	}
	
	@Test
	public void testSignFalse() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(8);
		assertFalse(MilaFormules.sign(testarli1).equals("-5"));
	}
	
	@Test
	public void testSignFalse2() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(8);
		assertFalse(MilaFormules.sign(testarli1).equals("0"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSignException() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1);
		testarli1.add(2);
		assertTrue(MilaFormules.sign(testarli1).equals("1"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSignException() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add("HALLO");
		assertTrue(MilaFormules.sign(testarli1).equals("1"));
	}
	
	@Test
	public void testSqrt() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(9);
		assertTrue(MilaFormules.sqrt(testarli1.equals("3")));
	}
	
	@Test
	public void testSqrt() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(5);
		assertFalse(MilaFormules.sqrt(testarli1.equals("2")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSqrt() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(-9);
		assertFalse(MilaFormules.sqrt(testarli1.equals("2")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSqrt() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(9);
		testarli1.add(9);
		assertFalse(MilaFormules.sqrt(testarli1).equals("2"));
	}
	
	@Test
	public void testRoundup() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1);
		testarli1.add(1.555);
		assertTrue(MilaFormules.roundup(testarli1).equals("1.6"));
	}
	
	@Test
	public void testRoundup2() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(2);
		testarli1.add(1.555);
		assertTrue(MilaFormules.roundup(testarli1).equals("1.56"));
	}
	
	@Test
	public void testRoundupFalse() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0);
		testarli1.add(1.9);
		assertFalse(MilaFormules.roundup(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRoundupMultipleInputs() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0);
		testarli1.add(1.9);
		testarli1.add(1.9);
		assertFalse(MilaFormules.roundup(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRoundupSingleInput() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.9);
		assertFalse(MilaFormules.roundup(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRoundupStringInput() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add("hallo ik ben een string");
		assertFalse(MilaFormules.roundup(testarli1).equals("1.9"));
	}
	
	
	@Test
	public void testRounddown() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1);
		testarli1.add(1.555);
		assertTrue(MilaFormules.rounddown(testarli1).equals("1.5"));
	}
	
	@Test
	public void testRounddown2() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(2);
		testarli1.add(1.555);
		assertTrue(MilaFormules.rounddown(testarli1).equals("1.55"));
	}
	
	@Test
	public void testRounddownFalse() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0);
		testarli1.add(1.9);
		assertFalse(MilaFormules.rounddown(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRounddownMultipleInputs() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0);
		testarli1.add(1.9);
		testarli1.add(1.9);
		assertFalse(MilaFormules.rounddown(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRounddownSingleInput() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.9);
		assertFalse(MilaFormules.rounddown(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRounddownStringInput() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add("hallo ik ben een string");
		assertFalse(MilaFormules.rounddown(testarli1).equals("1.9"));
	}
}

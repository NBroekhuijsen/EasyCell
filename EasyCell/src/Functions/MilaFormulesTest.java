package Functions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MilaFormulesTest {
	
	@Test
	public void testSum() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(8.8);
		testlijst.add(2.5);
		assertEquals(MilaFormules.sum(testlijst), "11.3");
	}
	
	@Test
	public void testSumFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(3.0);
		testlijst.add(3.0);
		assertFalse(MilaFormules.sum(testlijst).equals("6.0"));
	}
	
	@Test
	public void testSumWithStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add("hallo");
		testlijst.add(3.0);
		assertTrue(MilaFormules.sum(testlijst).equals("6.0"));
	}
	
	@Test
	public void testSumWithOnlyStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hallo");
		testlijst.add("hallo");
		assertTrue(MilaFormules.sum(testlijst).equals("0.0"));
	}
	
	@Test
	public void testSumIfDoubles() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		testlijst.add(2.0);
		testlijst.add(3.0);
		testlijst.add(4.0);
		testlijst.add(2.0);
		testlijst.add(2.0);
		testlijst.add(8.0);
		testlijst.add(2.1);
		assertEquals(MilaFormules.sumif(testlijst), "6.0");
	}
	
	@Test
	public void testSumIfFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		testlijst.add(2.0);
		testlijst.add(3.0);
		testlijst.add(5.0);
		testlijst.add(2.0);
		testlijst.add(5.0);
		testlijst.add(5.1);
		assertFalse(MilaFormules.sumif(testlijst).equals("15.0"));
	}
	
	@Test
	public void testSumIfRoundUp() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		testlijst.add(5.0000);
		assertEquals(MilaFormules.sumif(testlijst), "5.0");
	}
	
	@Test
	public void testSumIfWithStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		testlijst.add(5.0);
		testlijst.add("hallo");
		testlijst.add(5.0);
		testlijst.add("asdf");
		assertEquals(MilaFormules.sumif(testlijst), "10.0");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSumIfWithStringAsCriteria() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hallo");
		testlijst.add(5.0);
		testlijst.add("hallo");
		assertEquals(MilaFormules.sumif(testlijst), "0.0");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSumifOneInput() {
		ArrayList<Object> testlijst1 = new ArrayList<Object>();
		testlijst1.add(1.0);
		assertTrue(MilaFormules.sumif(testlijst1).equals("1.0"));
	}
	
	@Test
	public void testSign() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(5.0);
		assertEquals(MilaFormules.sign(testarli1), "isPositive");
	}
	
	@Test
	public void testSignMinus() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(-5.0);
		assertTrue(MilaFormules.sign(testarli1).equals("isNegative"));
	}
	
	@Test
	public void testSignZero() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0.0);
		assertTrue(MilaFormules.sign(testarli1).equals("isZero"));
	}
	
	@Test
	public void testSignFalse() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(8.0);
		assertFalse(MilaFormules.sign(testarli1).equals("isNegative"));
	}
	
	@Test
	public void testSignFalse2() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(8.0);
		assertFalse(MilaFormules.sign(testarli1).equals("isZero"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSignException() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.0);
		testarli1.add(2.0);
		assertTrue(MilaFormules.sign(testarli1).equals("isPositive"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSignExceptionString() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add("HALLO");
		assertTrue(MilaFormules.sign(testarli1).equals("isPositive"));
	}
	
	@Test
	public void testSqrt() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(9.0);
		assertEquals(MilaFormules.sqrt(testarli1),"3.0");
	}
	
	@Test
	public void testSqrtFalse() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(5.0);
		assertFalse(MilaFormules.sqrt(testarli1).equals("2.0"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSqrtNegative() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(-9.0);
		assertFalse(MilaFormules.sqrt(testarli1).equals("2.0"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSqrtMultipleInputs() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(9.0);
		testarli1.add(9.0);
		assertFalse(MilaFormules.sqrt(testarli1).equals("2"));
	}
	
	@Test
	public void testRoundup() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.555);
		testarli1.add(1.0);
		assertTrue(MilaFormules.roundup(testarli1).equals("1.6"));
	}
	
	@Test
	public void testRoundup2() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.555);
		testarli1.add(2.0);
		assertTrue(MilaFormules.roundup(testarli1).equals("1.56"));
	}
	
	@Test
	public void testRoundupFalse() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.9);
		testarli1.add(0.0);
		assertFalse(MilaFormules.roundup(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRoundupMultipleInputs() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0.0);
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
		testarli1.add(1.555);
		testarli1.add(1.0);
		assertTrue(MilaFormules.rounddown(testarli1).equals("1.5"));
	}
	
	@Test
	public void testRounddown2() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.555);
		testarli1.add(2.0);
		assertTrue(MilaFormules.rounddown(testarli1).equals("1.55"));
	}
	
	@Test
	public void testRounddownFalse() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(1.9);
		testarli1.add(0.0);
		assertFalse(MilaFormules.rounddown(testarli1).equals("1.9"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRounddownMultipleInputs() {
		ArrayList<Object> testarli1 = new ArrayList<Object>();
		testarli1.add(0.0);
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

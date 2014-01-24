package Functions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RemkoFormulesTest {

	@Test
	public void testAverageThree() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		testlijst.add(7.0);
		testlijst.add(9.0);
		assertEquals(RemkoFormules.average(testlijst), "6.0");
	}
	
	@Test
	public void testAverageTwo() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		testlijst.add(8.0);
		assertTrue(RemkoFormules.average(testlijst).equals("5.0"));
	}
	
	@Test
	public void testAverageOne() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		assertTrue(RemkoFormules.average(testlijst).equals("2.0"));
	}
	
	@Test
	public void testAverageFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add(2.0);
		testlijst.add(3.0);
		assertFalse(RemkoFormules.average(testlijst).equals("8.0"));
	}
	
	@Test
	public void testAverageStringInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add("tekst hier");
		testlijst.add(3.0);
		assertEquals(RemkoFormules.average(testlijst), "2.0");
	}
	
	@Test
	public void testAverageOnlyStringInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("tekst");
		testlijst.add("tekst hier");
		assertTrue(RemkoFormules.average(testlijst).equals("0.0"));
	}
	
	@Test
	public void testCount() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add(2.0);
		assertEquals(RemkoFormules.count(testlijst), "2.0");
	}
	
	@Test
	public void testCountFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		testlijst.add(66.0);
		assertFalse(!(RemkoFormules.count(testlijst).equals("2.0")));
	}
	
	@Test
	public void testCountWithStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add("STRING");
		testlijst.add(2.0);
		assertEquals(RemkoFormules.count(testlijst), "2.0");
	}
	
	@Test
	public void testCountWithOnlyStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("STRING");
		testlijst.add("NOG EEN STRING");
		assertEquals(RemkoFormules.count(testlijst), "0.0");
	}
	
	@Test
	public void testCountA() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add(2.0);
		assertEquals(RemkoFormules.counta(testlijst), "2.0");
	}
	
	@Test
	public void testCountAWithOneValue() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		assertEquals(RemkoFormules.counta(testlijst), "1.0");
	}
	
	@Test
	public void testCountAFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		testlijst.add(66.0);
		assertFalse(RemkoFormules.counta(testlijst).equals("1.0"));
	}
	
	@Test
	public void testCountAWithStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add("STRING");
		testlijst.add(2.0);
		assertTrue(RemkoFormules.counta(testlijst).equals("3.0"));
	}
	
	@Test
	public void testCountAWithOnlyStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("STRING");
		testlijst.add("NOG EEN STRING");
		assertTrue(RemkoFormules.counta(testlijst).equals("2.0"));
	}
	
	@Test
	public void testCountAWithNulls() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add("");
		testlijst.add("STRING");
		testlijst.add(2.0);
		testlijst.add("");
		assertEquals(RemkoFormules.counta(testlijst), "3.0");
	}
	
	@Test
	public void testCountAWithOnlyNulls() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("");
		testlijst.add("");
		assertTrue(RemkoFormules.counta(testlijst).equals("0.0"));
	}
	
	@Test
	public void testCountIf() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(4.0);
		testlijst.add(4.0);
		testlijst.add(1.0);
		testlijst.add(4.0);
		assertEquals(RemkoFormules.countif(testlijst), "2.0");
	}
	
	@Test
	public void testCountIfFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		testlijst.add(5.0);
		testlijst.add(2.0);
		assertFalse(RemkoFormules.countif(testlijst).equals("2.0"));
	}
	
	@Test
	public void testCountIfLargerthan() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(">5.0");
		testlijst.add(2.0);
		testlijst.add(7.0);
		testlijst.add(8.0);
		testlijst.add(4.5);
		testlijst.add(5.0);
		assertEquals(RemkoFormules.countif(testlijst), "2.0");
	}
	
	@Test
	public void testCountIfLargerthanEqualTo() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(">=5.0");
		testlijst.add(2.0);
		testlijst.add(7.0);
		testlijst.add(8.0);
		testlijst.add(4.5);
		testlijst.add(5.0);
		assertEquals(RemkoFormules.countif(testlijst), "3.0");
	}
	
	@Test
	public void testCountIfSmallerthan() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("<5.0");
		testlijst.add(2.0);
		testlijst.add(7.0);
		testlijst.add(8.0);
		testlijst.add(4.5);
		testlijst.add(5.0);
		assertEquals(RemkoFormules.countif(testlijst), "2.0");
	}
	
	@Test
	public void testCountIfSmallerthanEqualTo() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("<=5.0");
		testlijst.add(2.0);
		testlijst.add(7.0);
		testlijst.add(8.0);
		testlijst.add(4.5);
		testlijst.add(5.0);
		assertEquals(RemkoFormules.countif(testlijst), "3.0");
	}
	
	@Test
	public void testCountIfLargerThanString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("<blabla");
		testlijst.add(2.0);
		testlijst.add("7.0");
		testlijst.add(8.0);
		testlijst.add("blabla");
		testlijst.add("<blabla");
		testlijst.add(4.5);
		testlijst.add("<blabla");
		testlijst.add(5.0);
		assertEquals(RemkoFormules.countif(testlijst), "2.0");
	}
	
	@Test
	public void testCountIfLogical() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("false");
		testlijst.add("true");
		testlijst.add("false");
		testlijst.add(55.0);
		testlijst.add("false");
		assertEquals(RemkoFormules.countif(testlijst), "2.0");
	}
	
	@Test
	public void testCountIfStrings() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("holler at je string");
		testlijst.add("55");
		testlijst.add("holler at je string");
		testlijst.add("holler at je string");
		testlijst.add(66.6);
		testlijst.add("55");
		assertTrue(RemkoFormules.countif(testlijst).equals("2.0"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCountIfOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		assertTrue(RemkoFormules.countif(testlijst).equals("1.0"));
	}
	
	@Test
	public void testifFunction1st() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=2");
		testlijst.add(2.0);
		testlijst.add("blabla");
		assertTrue(RemkoFormules.ifFunction(testlijst).equals("2.0"));
	}
	
	@Test
	public void testifFunction2nd() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1+1=6");
		testlijst.add(2.0);
		testlijst.add("blabla");
		assertTrue(RemkoFormules.ifFunction(testlijst).equals("blabla"));
	}
	
	@Test
	public void testifFunctionWithDouble() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		testlijst.add(2.0);
		testlijst.add("blabla");
		assertTrue(RemkoFormules.ifFunction(testlijst).equals("2.0"));
	}
	
	@Test
	public void testifFunctionWithZero() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(0.0);
		testlijst.add(2.0);
		testlijst.add(-5.0);
		assertTrue(RemkoFormules.ifFunction(testlijst).equals("-5.0"));
	}
	
	@Test
	public void testifFunctionFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("(44-22=22)&&(22+22=66)");
		testlijst.add(2.0);
		testlijst.add("blabla");
		assertFalse(RemkoFormules.ifFunction(testlijst).equals("2.0"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testifFunctionNotLogical() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("blabla3");
		testlijst.add(2.0);
		testlijst.add("blabla");
		assertFalse(RemkoFormules.ifFunction(testlijst).equals("2.0"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testifFunctionNotEnoughInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("44-22=22");
		testlijst.add(2.0);
		assertFalse(RemkoFormules.ifFunction(testlijst).equals("2.0"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testifFunctionTooManyInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("44-22=22");
		testlijst.add(2.0);
		testlijst.add(2.0);
		testlijst.add(2.0);
		assertFalse(RemkoFormules.ifFunction(testlijst).equals("2.0"));
	}
}
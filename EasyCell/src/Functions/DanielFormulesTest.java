package Functions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DanielFormulesTest {
	
	
	@Test
	public void testnotWithDouble() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		//een value is altijd true, dus zou NOT false moeten geven.
		assertEquals(DanielFormules.not(testlijst), "false");
	}
	
	@Test
	public void testnotWithZero() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(0.0);
		//een value is altijd true, dus zou NOT false moeten geven.
		assertEquals(DanielFormules.not(testlijst), "true");
	}
	
	@Test
	public void testNot() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1.0 + 1.0 = 2.0 AND (2.0 + 2.0 = 4.0 OR 4.0 + 4.0 = 12512.0)");
		//deze string is true, dus zou NOT false moeten geven.
		assertTrue(DanielFormules.not(testlijst).equals("false"));
	}
	@Test
	public void testNotReverse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1.0 + 1.0 = 125.0 AND (2.0 + 2.0 = 4.0 OR 4.0 + 4.0 = 125.0)");
		//deze string is false, dus zou NOT true moeten geven.
		assertTrue(DanielFormules.not(testlijst).equals("true"));
	}
	
	@Test
	public void testNotFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("3.0 + 3.0 = 6.0 AND (4.0 + 4.0 = 8.0 OR 3.0 + 3.0 = 3463.0)");
		//deze string is true, dus zou NOT false moeten geven.
		assertFalse(DanielFormules.not(testlijst).equals("true"));
	}
	
	@Test
	public void testNotFalseReverse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("3.0 + 3.0 = 238572837.0 AND (4.0 + 4.0 = 8.0 OR 3.0 + 3.0 =3463.0)");
		//deze string is false, dus zou NOT true moeten geven.
		assertFalse(DanielFormules.not(testlijst).equals("false"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNotFalseGeenLogica() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("HALLO");
		assertFalse(DanielFormules.not(testlijst).equals("false"));
	}
	
	@Test 
	public void testOrDouble() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		assertEquals(DanielFormules.or(testlijst), "true");
	}
	
	@Test
	public void testOrMultipleDoubles() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(0.0);
		testlijst.add(0.0);
		testlijst.add(1.0);
		testlijst.add(0.0);
		assertEquals(DanielFormules.or(testlijst), "true");
	}
	
	@Test
	public void testOrZero() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(0.0);
		assertEquals(DanielFormules.or(testlijst), "false");
	}
	
	@Test
	public void testOrMultipleZeroes() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(0.0);
		testlijst.add(0.0);
		testlijst.add(0.0);
		assertEquals(DanielFormules.or(testlijst), "false");
	}
	
	@Test
	public void testOrZeroesWithLogic() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(0.0);
		testlijst.add("1+1=4");
		testlijst.add(0.0);
		assertEquals(DanielFormules.or(testlijst), "false");
	}
	
	@Test 
	public void testOrOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1.0 + 1.0 = 2.0");
		assertEquals(DanielFormules.or(testlijst), "true");
	}

	@Test
	public void testOrMultipleInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1.0 + 1.0 = 2.0");
		testlijst.add("2.0 + 2.0 = 4.0");
		assertEquals(DanielFormules.or(testlijst),"true");
	}
	
	@Test
	public void testOrMultipleInputsHalf() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1.0 + 1.0 = 2.0");
		testlijst.add("2.0 + 2.0 = 151266.0");
		assertEquals(DanielFormules.or(testlijst), "true");
	}
	
	@Test
	public void testOrMultipleInputsFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("1.0 + 1.0 = 4.0");
		testlijst.add("2.0 + 2.0 = 8.0");
		assertTrue(DanielFormules.or(testlijst).equals("false"));
	}

	
	@Test
	public void testOrMultipleInputsReverse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("2.0 + 4.0 = 6.0");
		testlijst.add("6.0 > 3.0");
		assertFalse(DanielFormules.or(testlijst).equals("false"));
	}
	
	@Test
	public void testOrMultipleInputsHalfReverse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("3.0 + 3.0 = 6.0");
		testlijst.add("8.0 - 5.0 = 18357687.0");
		assertFalse(DanielFormules.or(testlijst).equals("false"));
	}
	
	@Test
	public void testOrMultipleInputsFalseReserve() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("5.0 < 2.0");
		testlijst.add("2.0 = 125.0");
		assertFalse(DanielFormules.or(testlijst).equals("true"));
	}
	
	@Test
	public void testPower() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(4.0);
		assertEquals(DanielFormules.power(testlijst), "81.0");
	}
	
	@Test
	public void testPowerNegativeBase() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(-3.0);
		testlijst.add(4.0);
		assertEquals(DanielFormules.power(testlijst), "81.0");
	}
	
	@Test
	public void testPowerNegativePower() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(4.0);
		testlijst.add(-2.0);
		assertEquals(DanielFormules.power(testlijst), "0.0625");
	}
	
	@Test
	public void testPowerFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		testlijst.add(8.0);
		assertFalse(DanielFormules.power(testlijst).equals("0.0"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPowerWithString1() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add("HALLO");
		assertEquals(DanielFormules.power(testlijst), "81.0");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPowerWithString2() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("HALLO");
		testlijst.add(3.0);
		assertEquals(DanielFormules.power(testlijst), "81.0");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPowerWithOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		assertEquals(DanielFormules.power(testlijst), "81.0");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPowerWithmultipleInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(5.0);
		testlijst.add(8.0);
		assertEquals(DanielFormules.power(testlijst), "81.0");
	}
	
	@Test
	public void testProductOne() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		assertEquals(DanielFormules.product(testlijst), "3.0");
	}
	
	@Test
	public void testProductWithZero() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(5.0);
		testlijst.add(5.0);
		testlijst.add(5.0);
		testlijst.add(5.0);
		testlijst.add(0.0);
		assertEquals(DanielFormules.product(testlijst), "0.0");
	}
	
	@Test
	public void testProductTwo() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(5.0);
		assertEquals(DanielFormules.product(testlijst), "15.0");
	}
	
	@Test
	public void testProductTwoFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(5.0);
		assertFalse(DanielFormules.product(testlijst).equals("3.0"));
	}
	
	@Test
	public void testProductThree() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(5.0);
		testlijst.add(8.0);
		assertEquals(DanielFormules.product(testlijst), "120.0");
	}
	
	@Test
	public void testProductWithStringsOnly() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("HALLO IK BEN EEN STRING");
		testlijst.add("ik toevallig ook");
		testlijst.add("ik ben geen string ik ben een zin");
		assertEquals(DanielFormules.product(testlijst), "0.0");
	}
	
	@Test
	public void testProductWithStringsAndDoubles() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add("ik toevallig ook");
		testlijst.add(5.0);
		assertEquals(DanielFormules.product(testlijst), "15.0");
	}
	
	@Test
	public void testProper() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hallo ik ben HANS ik Hou vAn aNdIjViE");
		assertEquals(DanielFormules.proper(testlijst), "Hallo Ik Ben Hans Ik Hou Van Andijvie");
	}
	
	@Test
	public void testProperFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("ik ben een kip");
		assertFalse(DanielFormules.proper(testlijst).equals("Ik ben een kip"));
	}
	
	@Test
	public void testProperDouble() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.0);
		assertFalse(DanielFormules.proper(testlijst).equals("5.0"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testProperMultipleInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hallo");
		testlijst.add("hallohallo");
		assertFalse(DanielFormules.proper(testlijst).equals("5.0"));
	}

}

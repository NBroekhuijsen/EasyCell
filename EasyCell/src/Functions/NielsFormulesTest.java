package Functions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NielsFormulesTest {

	
	@Test
	public void testLowerFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("H");
		assertFalse(NielsFormules.lower(testlijst).equals("H"));
	}
	
	@Test
	public void testLowerUppercase() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("HALLO IK BEN NIELS IK TYP IN ALL CAPS WANT IK BEN BOOS");
		assertTrue(NielsFormules.lower(testlijst).equals("hallo ik ben niels ik typ in all caps want ik ben boos"));
	}
	
	@Test
	public void testLowerLowercase() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("h");
		assertTrue(NielsFormules.lower(testlijst).equals("h"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLowerMultipleInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("f");
		testlijst.add("u");
		testlijst.add("c");
		testlijst.add("k");
		assertTrue(NielsFormules.lower(testlijst).equals("f"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLower() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(42.42);
		assertTrue(NielsFormules.lower(testlijst).equals(42.42));
	}
	
	@Test
	public void testMax() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.1);
		testlijst.add(2.2);
		testlijst.add(3.3);
		assertEquals(NielsFormules.max(testlijst), ("3.3"));
	}
	
	@Test
	public void testMaxFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(5.5);
		testlijst.add(4.4);
		testlijst.add(3.3);
		assertFalse(NielsFormules.max(testlijst).equals("4.4"));
	}
	
	@Test
	public void testMaxStringInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add("hoi");
		testlijst.add("hoitwo");
		testlijst.add("hoidrie");
		assertEquals(NielsFormules.max(testlijst), "0.0");
	}
	
	@Test
	public void testMaxOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(555.0);
		assertEquals(NielsFormules.max(testlijst), ("555.0"));
	}
	
	@Test
	public void testMaxAndString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(15.0);
		testlijst.add("ballon");
		testlijst.add(20.0);
		assertEquals(NielsFormules.max(testlijst), "20.0");
	}

	@Test
	public void testMedian() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(1.0);
		testlijst.add(2.0);
		testlijst.add(3.0);
		assertTrue(NielsFormules.median(testlijst).equals("2.0"));
	}
	
	@Test
	public void testMedianFalse() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		testlijst.add(3.0);
		testlijst.add(4.0);
		assertFalse(!(NielsFormules.median(testlijst).equals("3.0")));
	}
	
	@Test
	public void testMedianOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		assertTrue(NielsFormules.median(testlijst).equals("2.0"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMedianString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(2.0);
		testlijst.add("HALLO IK STA HELEMAAL FOUT");
		testlijst.add(2.0);
		assertTrue(NielsFormules.median(testlijst).equals("HALLO IK STA HELEMAAL FOUT"));
	}		

	@Test
	public void testModLowerDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(7.0);
		testlijst.add(3.0);
		assertTrue(NielsFormules.mod(testlijst).equals("1.0"));	
	}
	
	@Test
	public void testModHigherDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(7.0);
		assertTrue(NielsFormules.mod(testlijst).equals("3.0"));	
	}
	
	@Test
	public void testModEqualDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(3.0);
		assertEquals(NielsFormules.mod(testlijst), "0.0");	
	}
	
	@Test
	public void testModEqualNegativeDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(-3.0);
		assertEquals(NielsFormules.mod(testlijst), "0.0");	
	}
	
	@Test
	public void testModEqualNegativeBase() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(-3.0);
		testlijst.add(3.0);
		assertEquals(NielsFormules.mod(testlijst), "0.0");	
	}
	
	@Test
	public void testModEqualBothNegative() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(-3.0);
		testlijst.add(-3.0);
		assertEquals(NielsFormules.mod(testlijst), "0.0");	
	}
	
	@Test
	public void testModNegativeDivisor() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(29.0);
		testlijst.add(-3.0);
		assertEquals(NielsFormules.mod(testlijst), "2.0");	
	}
	
	@Test
	public void testModNegativeBase() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(-29.0);
		testlijst.add(3.0);
		assertEquals(NielsFormules.mod(testlijst), "-2.0");	
	}
	
	@Test
	public void testModBothNegatives() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(-29.0);
		testlijst.add(-3.0);
		assertEquals(NielsFormules.mod(testlijst), "-2.0");	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testModDiviserZero() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(15.0);
		testlijst.add(0.0);
		assertEquals(NielsFormules.mod(testlijst), "0.0");	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testModOneInput() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		assertTrue(NielsFormules.mod(testlijst).equals("3.0"));	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testModTooManyInputs() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add(3.0);
		testlijst.add(3.0);
		assertTrue(NielsFormules.mod(testlijst).equals("0.0"));	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testModString() {
		ArrayList<Object> testlijst = new ArrayList<Object>();
		testlijst.add(3.0);
		testlijst.add("STRING");
		assertTrue(NielsFormules.mod(testlijst).equals("0.0"));	

	}
}

package Pakketjuh;

import static org.junit.Assert.*;

import java.awt.image.ReplicateScaleFilter;
import java.util.ArrayList;

import org.junit.Test;

import Functions.JuliantiFormules;

public class TestModel { 
//	Strings for the tests: testCellReader(), testFunctionTrimmer(), testGetFunction()
	String exCell1 = "SUM(x3y1,x3y3)";
	String exCell2 = "ISNUMBER(x1y1:x4y5)";
	String exCell3 = "     =SUM(x1y5: x1y6)    ";
//	TO DO: Strings to test all the 24 functions - already made space in memory
	String exCell4 = "=AVERAGE(4,6)";				//=5.0
	String exCell5 = "=COUNT(x1y2,x4y6,x2y3)";		//=3.0
	String exCell6 = "=COUNTA(x1y1:x3y3)";			//=9.0
	String exCell7 = "=COUNTIF(4,4,1,4)";			//=2.0
	String exCell8 = "=IF(1+1=2,2.0,blabla)";		//=2.0
	String exCell9 = "=INT(5.7)";					//=6.0
	String exCell10 = "=ISLOGICAL(true)";			//=true
	String exCell11 = "=NOT(1)";					//=false
	String exCell12 = "=OR(1)";						//=true
	String exCell13 = "=POWER(3,4)";				//=81.0
	String exCell14 = "=PRODUCT(3,5)";				//=15.0
	String exCell15 = "=PROPER(IK BEN MILA EN IK TYPE CAPSLOCK WANT IK BEN ALTIJD BOOS)";	//=Ik Ben Mila En Ik Type Capslock Want Ik Ben Altijd Boos
	String exCell16 = "=ROUNDDOWN(123.5555, 1)";	//=123.5
	String exCell17 = "=ROUNDUP(123.5555, 1)";		//=123.6
	String exCell18 = "=ISLOGICAL(1)";				//=false
	String exCell19 = "=ISEVEN(50)";				//=true
	String exCell20 = "=ISNUMBER(2)";				//=true
	String exCell21 = "=SUM(1,2,3,4)";				//=10.0
	String exCell22 = "=SUMIF(2,2,3,4,2,2,8)";	//=6.0
	String exCell23 = "=SIGN(-5)";					//=isNegative
	String exCell24 = "=SQRT(9)";					//3.0
	String exCell25 = "=UPPER(oopproject)";			//=OOPPROJECT
	String exCell26 = "=LOWER(OoP pRoJeCt)";		//=oop project
	String exCell27 = "=MAX(2,4,6,3,9,6)";			//9.0
	String exCell28 = "=MOD(3,7)";					//=3.0
	String exCell29 = "=MEDIAN(2,3,4)";				//=3.0

	String coor1 = "x293y20";
	String coor2 = "x1y1";
	String coor3 = "x49y480";
	String coor4 = "x33y83";
	
	

//	Parameters for the test: testIndeExpander
	String index1 = "A1: B2";
	String index2 = "D1, F3: F5";
		
	String calc = "SUM()";
	
	Model data_model = XMLParser.readXML("Spreadsheet.xml");

	@Test
	public void testCellReader() {
		
//		 JAVADOC: checks if cellcontent begins with "=" If so, calls methods to perform
//       conversions and calculations
//		TO DO: non static, so a table has to be made
			 
		assertEquals("1.0", data_model.cellReader("=SUM(x1y1,x2y1)")[0]);
		assertEquals("This is not the right String", data_model.cellReader("This is not the right String")[0]);
		assertEquals("1.123",data_model.cellReader("=ROUNDDOWN(1.123456,3)")[0]);
		assertEquals("1.124",data_model.cellReader("=ROUNDUP(1.123456, 3)")[0]);
		assertEquals("16.0", data_model.cellReader("=POWER(2,4)")[0]);
		assertEquals("16.0", data_model.cellReader("=POWER(x3y1,x5y1)")[0]);
		assertEquals("16.0", data_model.cellReader("=POWER(2,x5y1)")[0]);
		assertEquals(" ", data_model.cellReader(" ")[0]);
		assertEquals("     ", data_model.cellReader("     ")[0]);
		assertEquals("",data_model.cellReader("")[0]);
		
		assertEquals("5.0",data_model.cellReader(exCell4)[0]);
		assertEquals("3.0",data_model.cellReader(exCell5)[0]);
		assertEquals("9.0",data_model.cellReader(exCell6)[0]);
		assertEquals("2.0",data_model.cellReader(exCell7)[0]);
		assertEquals("2.0",data_model.cellReader(exCell8)[0]);
		assertEquals("6.0",data_model.cellReader(exCell9)[0]);
		assertEquals("true",data_model.cellReader (exCell10)[0]);
		assertEquals("false",data_model.cellReader(exCell11)[0]);
		assertEquals("true",data_model.cellReader(exCell12)[0]);
		assertEquals("81.0",data_model.cellReader(exCell13)[0]);
		assertEquals("15.0",data_model.cellReader(exCell14)[0]);
		assertEquals("Ik Ben Mila En Ik Type Capslock Want Ik Ben Altijd Boos",data_model.cellReader(exCell15)[0]);
		assertEquals("123.5",data_model.cellReader(exCell16)[0]);
		assertEquals("123.6",data_model.cellReader(exCell17)[0]);
		assertEquals("false",data_model.cellReader(exCell18)[0]);
		assertEquals("true",data_model.cellReader(exCell19)[0]);
		assertEquals("true",data_model.cellReader(exCell20)[0]);
		assertEquals("10.0",data_model.cellReader(exCell21)[0]);
		assertEquals("6.0",data_model.cellReader(exCell22)[0]);
		assertEquals("isNegative",data_model.cellReader(exCell23)[0]);
		assertEquals("isNegative",data_model.cellReader("=SIGN(-2.0)")[0]);
		assertEquals("isNegative",data_model.cellReader("=SIGN(-500)")[0]); 
		assertEquals("3.0",data_model.cellReader(exCell24)[0]);
//		assertEquals("OOPPROJECT",data_model.cellReader(exCell25)[0]);
//		assertEquals("oop project",data_model.cellReader(exCell26)[0]);
		assertEquals("9.0",data_model.cellReader(exCell27)[0]);
		assertEquals("3.0",data_model.cellReader(exCell28)[0]);
		assertEquals("3.0",data_model.cellReader(exCell29)[0]);


	}
	
	@Test
	public void testGetRows(){
		assertEquals(data_model.getRows(), 12 );
	}
	
	@Test
	public void testFunctionTrimmer() {
		assertEquals("x3y1,x3y3", Model.functionTrimmer(exCell1));
		assertEquals("x1y1:x4y5", Model.functionTrimmer(exCell2));
		assertEquals("x1y5:  x1y6", Model.functionTrimmer("SUM(x1y5:  x1y6)"));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFunctionTrimmerWrongString() {
		String wrongFunction = "SUMMERD(indexesAndStuff)";
		assertEquals("indexesAndStuff", Model.functionTrimmer(wrongFunction));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFunctionTrimmerNoExcelString() {
		String wrongExcelString = "SUMMERD(I'mNotEndingWithABracket";
		assertEquals("indexesAndStuff", Model.functionTrimmer(wrongExcelString));
	}
	
	@Test
	public void testGetFunction() {
//		DONE
		assertEquals("SUM", Model.getFunction(exCell1));
		assertEquals("ISNUMBER", Model.getFunction(exCell2));
	}


	@Test
	public void testIndexExpander() {
//         method indexExpander 
//         Recieves input as x1y2,x5y3:x33y3 etc.
//         Cuts out the "," and puts the pieces in ArrayList<String>
//        
//         Scans for ":", sorts the indexes out one by one
//         then fetches the contents and put them in ArrayList<String>

		ArrayList<Object> temp = new ArrayList<Object>();
		double nul = 0.0;
		double een = 1.0;
		double twee = 2.0;
		double drie = 3.0;
		
		temp.add(nul);
		temp.add(een);
		temp.add(twee);
		temp.add(drie);
		
		assertTrue(temp.equals(data_model.indexExpander("x1y1, x2y1, x3y1,x4y1")));
		assertTrue(temp.equals(data_model.indexExpander("x1y1:x4y1")));
		assertEquals(10.0, data_model.indexExpander("x1y2").get(0));
		
		ArrayList<Object> temp2 = new ArrayList<Object>();
		temp2.add("BijnaGefixt");
		temp2.add(30.0);
		temp2.add("coordinate+ 44=answer");


		assertTrue(temp2.equals(data_model.indexExpander("BijnaGefixt, x1y4,  coordinate+ x5y6=answer")));
		
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIndexExpanderNoCoorNextToDoublePoints() {
		String wrong = "OOP:SuperVO";
		assertEquals("indexesAndStuff", data_model.indexExpander(wrong));
	}
	
	
	@Test
	public void testGetCoorContent() {
//		DONE
		
		assertEquals("0", data_model.getCoorContent("x1y1"));
		assertEquals("10", data_model.getCoorContent("x1y2"));
		assertEquals("1", data_model.getCoorContent("x2y1"));
		
	}
	
	@Test
	public void testGetCoorX() {
//		DONE
		
//		True's
		assertEquals(293, Model.getCoorX(coor1));
		assertEquals(1, Model.getCoorX(coor2));
		assertEquals(49, Model.getCoorX(coor3));
		assertEquals(33, Model.getCoorX(coor4));
		
//		False's
		assertNotEquals(200,Model.getCoorX(coor1));
		assertNotEquals(13, Model.getCoorX(coor2));
		assertNotEquals(80, Model.getCoorX(coor3));
		assertNotEquals(683, Model.getCoorX(coor4));
				
	}
	
	@Test
	public void testGetCoorY() {
//		DONE
		
//		True's
		assertEquals(20, Model.getCoorY(coor1));
		assertEquals(1, Model.getCoorY(coor2));
		assertEquals(480, Model.getCoorY(coor3));
		assertEquals(83, Model.getCoorY(coor4));
		
//		False's
		assertNotEquals(200,Model.getCoorY(coor1));
		assertNotEquals(13, Model.getCoorY(coor2));
		assertNotEquals(80, Model.getCoorY(coor3));
		assertNotEquals(683, Model.getCoorY(coor4));
		


	}
	
	@Test
	public void testReplaceCoor() {

		assertEquals("1+1=2", data_model.replaceCoor("1+x2y1=2"));
		assertEquals("111", data_model.replaceCoor("x2y1x2y1x2y1"));
		assertEquals("lalala+1+2", data_model.replaceCoor("lalala+x2y1+x3y1"));
	}
	
	@Test
	public void testContentParser() {
//		DONE
		double dub1 = 3.84;
		double dub2 = 23489.3428;
		
		String str1 = "1000=599+2";
		
		assertEquals(Model.contentParser("23489.3428"), dub2);
		assertEquals(str1, Model.contentParser(str1));
		
	}
	
	
	@Test
	public void testFunctionExist() {
		
//		Missing one third of branch coverage...
		
		assertTrue(Model.functionExist("AVERAGE"));
		assertTrue(Model.functionExist("COUNT"));
		assertTrue(Model.functionExist("COUNTA"));
		assertTrue(Model.functionExist("COUNTIF"));
		assertTrue(Model.functionExist("IF"));
		assertTrue(Model.functionExist("INT"));
		assertTrue(Model.functionExist("ISLOGICAL"));
		assertTrue(Model.functionExist("ISEVEN"));
		assertTrue(Model.functionExist("ISNUMBER"));
		assertTrue(Model.functionExist("LOWER"));
		assertTrue(Model.functionExist("MAX"));
		assertTrue(Model.functionExist("MEDIAN"));
		assertTrue(Model.functionExist("MIN"));
		assertTrue(Model.functionExist("MOD"));
		assertTrue(Model.functionExist("NOT"));
		assertTrue(Model.functionExist("OR"));
		assertTrue(Model.functionExist("POWER"));
		assertTrue(Model.functionExist("PRODUCT"));
		assertTrue(Model.functionExist("PROPER"));
		assertTrue(Model.functionExist("ROUNDDOWN"));
		assertTrue(Model.functionExist("ROUNDUP"));
		assertTrue(Model.functionExist("SIGN"));
		assertTrue(Model.functionExist("SQRT"));
		assertTrue(Model.functionExist("SUM"));
		assertTrue(Model.functionExist("SUMIF"));

//		assertFalse(Model.functionExist("MILAISCOOL"));
//		assertFalse(Model.functionExist("Average"));
//		assertFalse(Model.functionExist("usecapslockcorrectly"));
//		assertFalse(Model.functionExist("Typing=fun"));
//		assertFalse(Model.functionExist("WhatPeopleDoToGet80%TestCoverageIsDepressing"));
	}
		
	@Test
	public void testCallFunction() {
		
		
		
		
		
		
		
		
	}
	
	public void testEnsureRows(){
		assertFalse(data_model.getRows() == 10);
		data_model.ensureRows(12);
		assertTrue(data_model.getRows() == 11);
	}

}

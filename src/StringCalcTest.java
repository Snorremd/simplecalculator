import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StringCalcTest {
	
	StringCalc stringCalc;
	int randomNum;
	String numbers;
	int expectedSum;

	@Before
	public void setUp() throws Exception {
		stringCalc = new StringCalc();
		randomNum = new Random().nextInt(100);
		
		Random random = new Random();
		int noNumbers = random.nextInt(10);
		numbers = "";
		expectedSum = 0;
		for(int i = 0; i < noNumbers; i++) {
			int aNumber = random.nextInt(100);
			expectedSum += aNumber;
			numbers += Integer.toString(aNumber) + ",";
		}
	}

	@After
	public void tearDown() throws Exception {
		stringCalc = null;
	}

	@Test
	public void testAddEmpty() {
		int result = 0;
		try {
			result = stringCalc.add("");
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 0);
	}
	
	@Test
	public void testAddOne() {
		int result = 0;
		try {
			result = stringCalc.add("1");
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 1);
	}

	@Test
	public void testAddOneTwo() {
		int result = 0;
		try {
			result = stringCalc.add("1,2");
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 3);
	}
	
	@Test
	public void testAddRandom() {
		int result = 0;
		try {
			result = stringCalc.add(Integer.toString(randomNum));
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(randomNum, result);
		
	}
	
	@Test
	public void testAddManyNumbers() {
		int result = 0;
		try {
			result = stringCalc.add(numbers);
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expectedSum, result);
	}
	
	@Test
	public void testAddNewLinesBetweenNumbers() {
		int result = 0;
		try {
			result = stringCalc.add("1\n2,3");
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(6, result);
	}
	
	@Test
	public void testAddChangeDelimiterToPip(){
		int result = 0;
		try {
			result = stringCalc.add("//|\n1|2");
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, result);
	}

	@Test
	public void testAddChangeDelimiterToSemicolon(){
		int result = 0;
		try {
			result = stringCalc.add("//;\n1;2");
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, result);
	}

//	@Test
//	public void testAddExceptionForNegativeNumber() {
//		try{
//			int result = stringCalc.add("-234,23,-343");
//		} catch (NegativeNumberException e){
//			
//			assertEquals("negatives not allowed "+ "-234,-343", e.getMessage());
//		}
//	}
}

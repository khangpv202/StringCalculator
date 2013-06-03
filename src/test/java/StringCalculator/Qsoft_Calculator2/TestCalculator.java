package StringCalculator.Qsoft_Calculator2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

public class TestCalculator {
	ExpectedException expected = ExpectedException.none();
	@Test
	public void testEmpty(){
		Calculator cal = new Calculator();
		assertEquals(0,cal.add(""));
	}
	@Test
	public void testAddOnlyNumber(){
		Calculator cal = new Calculator();
		assertEquals(1,cal.add("1"));
		assertEquals(91,cal.add("91"));
	}
	@Test
	public void testMoreNumber(){
		Calculator cal = new Calculator();
		assertEquals(7,cal.add("1,2,3,1"));
		assertEquals(7,cal.add("1;2;3;1"));
	}
	@Test
	public void testAddNewLine(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("1\n2,3"));
	}
	@Test
	public void testDelimiter(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("//,\n1,2,3"));
		assertEquals(6,cal.add("//;\n1;2;3"));
	}
	/*@Test
	public void testAddNegativeNumber(){
		Calculator cal = new Calculator();
		cal.add("1,2,-3");
		expected.expect(IllegalArgumentException.class);
        expected.expectMessage("negatives not allowed");	
	}*/
	@Test
	public void testBiger1000(){
		Calculator cal = new Calculator();
		assertEquals(2,cal.add("//,\n2,1001"));
	}
	@Test
	public void testMoreDelimiter(){
		Calculator cal = new Calculator();
		assertEquals(6,cal.add("//[,,]\n1,2,3"));
	}
}

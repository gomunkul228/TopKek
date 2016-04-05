package calculator.datatypes.complex;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.DivisionByZeroException;


public class ComplexTest {

	@Test
	public void test() {
		ComplexValue c1 = new ComplexValue(3,4);
		String c2 = "3.0+4.0i";
		System.out.print(c1.toString());
		assertTrue(c2.equals(c1.toString()));
	}
	
	@Test
	public void test2() {
		ComplexValue c1 = new ComplexValue(0,-4);
		String c2 = "0.0-4.0i";
		assertTrue(c2.equals(c1.toString()));
	}
	
	@Test
	public void test3() {
		ComplexValue c1 = new ComplexValue(5,-4);
		ComplexValue c3 = new ComplexValue(-1,4);
		String c2 = "4.0+0.0i";
		assertTrue(c2.equals((c1.add(c3)).toString()));
	}
	
	@Test
	public void test4() {
		ComplexValue c1 = new ComplexValue(1,2);
		ComplexValue c3 = new ComplexValue(3,4);
		String c2 = "-5.0+10.0i";
		assertTrue(c2.equals((c1.mul(c3)).toString()));
	}
	
	@Test
	public void test5() throws DivisionByZeroException {
		ComplexValue c1 = new ComplexValue(5,-5);
		ComplexValue c3 = new ComplexValue(1,2);
		String c2 = "-1.0-3.0i";
		System.out.print((c1.div(c3)).toString());
		assertTrue(c2.equals((c1.div(c3)).toString()));
	}
}

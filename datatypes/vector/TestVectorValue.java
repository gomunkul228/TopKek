package calculator.datatypes.vector;
import static org.junit.Assert.*;
import org.junit.Test;

import calculator.OperationNotSupportedException;

import java.util.ArrayList;

public class TestVectorValue {
	
	@Test
	public void testadd() throws OperationNotSupportedException
	{	
		ArrayList<Double> Vec = new ArrayList<Double>();
		Vec.add(1.0);
		Vec.add(2.0);
		VectorValue a = new VectorValue(Vec);
		System.out.println(a);
		Vec.set(0, 2.0);
		Vec.set(1, 3.0);
		VectorValue b = new VectorValue(Vec);
		System.out.println(a.add(b));
		Vec.set(0, 3.0);
		Vec.set(1, 5.0);
		VectorValue c = new VectorValue(Vec);
		System.out.println(c);
		assertTrue(c.equals(a.add(b)));
	}
	
	@Test
	public void testsub() throws OperationNotSupportedException
	{	
		ArrayList<Double> Vec = new ArrayList<Double>();
		Vec.add(3.0);
		Vec.add(5.0);
		VectorValue a = new VectorValue(Vec);
		Vec.set(0, 2.0);
		Vec.set(1, 3.0);
		VectorValue b = new VectorValue(Vec);
		Vec.set(0, 1.0);
		Vec.set(1, 2.0);
		VectorValue c = new VectorValue(Vec);
		assertTrue(c.equals(a.sub(b)));
	}
}

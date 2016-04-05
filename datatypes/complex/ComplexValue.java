package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class ComplexValue extends AbstractValue {
	
	public final double re;
	public final double im;
	
	public ComplexValue(double re, double im) {
		super();
		this.re = re;
		this.im = im;
	}
	
	public String toString() {
		if (im >= 0) return Double.toString(re) + "+" + Double.toString(im) + "i";
		else
		if (im < 0) return Double.toString(re) + "-" + Double.toString(Math.abs(im)) + "i";
		
		return null;
	}
	
	public AbstractValue add(AbstractValue operand) {
		return new ComplexValue(re + ((ComplexValue) operand).re, im + ((ComplexValue) operand).im);
	}
	
	public AbstractValue sub(AbstractValue operand) {
		return new ComplexValue(re - ((ComplexValue) operand).re, im - ((ComplexValue) operand).im);
	}

	public AbstractValue mul(AbstractValue operand) {
		return new ComplexValue(re * ((ComplexValue) operand).re - im * ((ComplexValue) operand).im, im * ((ComplexValue) operand).re + re * ((ComplexValue) operand).im);
	}

	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException {
		double cRe = ((ComplexValue) operand).re;
		double cIm = ((ComplexValue) operand).im;
		ComplexValue dual = new ComplexValue(cRe, -cIm);
		double r = ((ComplexValue)(((ComplexValue) operand).mul(dual))).re;
		if (r == 0.0)
			throw new DivisionByZeroException();
		ComplexValue dual2 = new ComplexValue(cRe / r, -cIm / r);
		return this.mul(dual2);
	}
}

package calculator.datatypes.vector;

import java.util.ArrayList;

import calculator.AbstractValue;
import calculator.OperationNotSupportedException;

public class VectorValue extends AbstractValue{

	private double c[];
		
	public VectorValue (ArrayList<Double> coordinates) {
		c = new double [coordinates.size()];
		for (int i = 0; i < coordinates.size() ; i++) {
			c[i] = coordinates.get(i);
		}
	}
		
	VectorValue (VectorValue other) {
		c = new double[other.c.length];
		for (int i=0; i<c.length; ++i) {
			c[i] = other.c[i];
		}
	}
	
	public String toString() {
		String n = "(";
		int len = this.c.length;
		for (int i = 0 ; i < len - 1 ; i++) {
			n += String.valueOf(this.c[i]) + ',';
		}
		n += String.valueOf(this.c[len - 1]) + ')';
		return n;
	}
		
	public void dimensionsAreEqual(VectorValue other) throws OperationNotSupportedException {
		if (this.c.length != other.c.length) {
			throw new OperationNotSupportedException("не совпадают размерности");
		}
	}
		
	public AbstractValue add(AbstractValue _other) throws OperationNotSupportedException {
		VectorValue other = (VectorValue) _other;
		dimensionsAreEqual(other);
		VectorValue result = new VectorValue(this);
		for (int i = 0 ; i < c.length ; i++) {
			result.c[i] += other.c[i];
		}
		return result;
	}
		
	public AbstractValue sub(AbstractValue _other) throws OperationNotSupportedException {
		VectorValue other = (VectorValue) _other;
		dimensionsAreEqual(other);
		VectorValue result = new VectorValue(this);
		for (int i = 0 ; i < c.length ; i++) {
			result.c[i] -= other.c[i];
		}
		return result;
	}
			
	public AbstractValue mul(AbstractValue other) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("*");
	}

	public AbstractValue div(AbstractValue other) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("/");		
	}
	
	public boolean equals(AbstractValue operand) throws OperationNotSupportedException
	{ 
	if((operand == null)||((VectorValue)operand).c.length!=this.c.length){
	throw new OperationNotSupportedException("lalala");
	}
	boolean soma = true;
	for(int i = 0; i<this.c.length;i++){
	soma = soma&&(this.c[i]==((VectorValue)operand).c[i]);
	}
	return soma;
	}

}

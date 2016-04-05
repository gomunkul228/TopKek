package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class ComplexValueParser implements AbstractValueParser {
	
	public String getDatatypeName() {
		return "комплексные числа";
	}
	
	public AbstractValue parse(String value) throws ParseValueException {
		if (value.contains("+")){
		final String[] twoNum = value.split("+");
		try {
			return new ComplexValue(Double.parseDouble(twoNum[1]),Double.parseDouble(twoNum[2]));
			} catch (NumberFormatException exception) {
				throw new ParseValueException();
			}
		finally{}
		}
	    if (value.contains("-")){
			final String[] twoNum2 = value.split("+");
			try{
				return new ComplexValue(Double.parseDouble(twoNum2[1]), - Double.parseDouble(twoNum2[2]));
				} catch (NumberFormatException exception) {
					throw new ParseValueException();
				}
	    }
	    return null;
	}

}

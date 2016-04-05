package calculator.datatypes.vector;

import java.util.ArrayList;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class VectorValueParser implements AbstractValueParser {
	public AbstractValue parse (String value) throws ParseValueException {
		try {
			ArrayList<Double> coordinates = new ArrayList<Double>();
			int i = 0;
			String n ="";
			int len = value.length();
			if (value.charAt(i) != '(') {
				throw new NumberFormatException();
			}
			i++;
			while (i < len) {
				while (i < len && value.charAt(i) != ',') {
					n+=value.charAt(i);
					i++;
				}
				if (i != len) {
					coordinates.add(Double.parseDouble(n));
					n = "";
				} else {
					if (n.charAt(n.length()-1) != ')') {
						throw new NumberFormatException();
					}
					coordinates.add(Double.parseDouble(n.substring(0, n.length()-1)));	
				}
				i++;
			}
			return new VectorValue(coordinates);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}
	
	public String getDatatypeName() {
		return "вектора";
	}

}

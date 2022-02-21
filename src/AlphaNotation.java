
/**
 * Please check the GitHub page for more information: https://github.com/NeoGames4/Reed-Solomon-Division-Processor
 * @author Mika Thein
 * @version 1.0 "Tay. Ham"
 */
public class AlphaNotation {
	
	/**
	 * Converts a polynomial from integer to alpha notation.
	 * @param integerNotation the polynomial in integer notation
	 * @return integerNotation in alpha notation
	 * @throws NumberFormatException
	 */
	public static String toAlphaNotation(String integerNotation) throws NumberFormatException {
		String result = "";
		for(String num : integerNotation.split("x")) result += "x" + getExponent(Integer.parseInt(num));
		return result.substring(1);
	}
	
	/**
	 * Converts a polynomial from alpha to integer notation.
	 * @param alphaNotation the polynomial in alpha notation
	 * @return alphaNotation in integer notation
	 * @throws NumberFormatException
	 */
	public static String toIntegerNotation(String alphaNotation) throws NumberFormatException {
		String result = "";
		for(String num : alphaNotation.split("x")) result += "x" + getInteger(Integer.parseInt(num));
		return result.substring(1);
	}
	
	/**
	 * Returns the exponent of 2 for {@Code integer}.
	 * @param integer
	 * @return n for integer as 2 pow n
	 */
	public static int getExponent(int integer) {
		if(integer < 1 || integer > 255) throw new RuntimeException("Value out of bounce: " + integer);
		int i = 0;
		while(getInteger(i) != integer) i++;
		return i;
	}
	
	/**
	 * Returns the integer of 2 pow exponent.
	 * @param exponent
	 * @return the integer represented by 2 pow exponent
	 */
	public static int getInteger(int exponent) {
		if(exponent < 0 || exponent > 255) throw new RuntimeException("Value out of bounce: " + exponent);
		if(exponent > 0) {
			int result = 2 * getInteger(exponent-1);
			return result > 255 ? result ^ 285 : result;
		} return 1;
	}

}

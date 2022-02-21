
/**
 * Please check the GitHub page for more information: https://github.com/NeoGames4/Reed-Solomon-Division-Processor
 * @author Mika Thein
 * @version 1.0 "Tay. Ham"
 */
public class DivisionProcessor {
	
	public final String generatorPolynomial, messagePolynomial;
	
	/**
	 * Divides the generator polynomial by the message polynomial in a GF(256).
	 * <p>For example:</p>
	 * Generator: 0x251x67x46x61x118x70x64x94x32x45<br>
	 * Message: 5x92x238x78x161x155x187x145x98x6x122x100x122x100x122x100<br>
	 * Returns: [196,35,39,119,235,215,231,226,93,23]
	 * @param generatorPolynomial the generator polynomial in alpha notation
	 * @param messagePolynomial the example polynomial in alpha notation
	 * @see AlphaNotation
	 * @see <a href="https://www.thonky.com/qr-code-tutorial/error-correction-coding">Explaination</a>
	 */
	public DivisionProcessor(String generatorPolynomial, String messagePolynomial) {
		this.generatorPolynomial = generatorPolynomial;
		this.messagePolynomial = messagePolynomial;
	}
	
	/**
	 * Returns the remainders of the division / the coefficients of the final polynomial.
	 * @return
	 */
	public int[] getRemainders() {
		int steps = messagePolynomial.split("x").length;
		String xorResult = messagePolynomial, result = xorResult;
		
		for(int i = 0; i<steps; i++) {
			result = multiplyAlphaPolynomialByAlphaExponent(generatorPolynomial, Integer.parseInt(xorResult.split("x")[0]));
			xorResult = AlphaNotation.toAlphaNotation(xor(AlphaNotation.toIntegerNotation(xorResult), AlphaNotation.toIntegerNotation(result)));
		} result = AlphaNotation.toIntegerNotation(xorResult);
		
		int[] remainders = new int[result.split("x").length];
		for(int i = 0; i<remainders.length; i++) remainders[i] = Integer.parseInt(result.split("x")[i]);
		return remainders;
	}
	
	private String multiplyAlphaPolynomialByAlphaExponent(String polynomial, int exponent) {
		String result = "";
		for(String num : polynomial.split("x")) result += "x" + ((Integer.parseInt(num) + exponent) % 255);
		return result.substring(1);
	}
	
	private static String clearZeros(String polynomial) {
		if(polynomial.startsWith("0")) polynomial = polynomial.substring(2);
		if(polynomial.endsWith("0")) polynomial = polynomial.substring(0, polynomial.length()-2);
		return polynomial.replace("x0x", "x");
	}
	
	/**
	 * XORs one polynomial with another.
	 * @param polynomialOne the first polynomial
	 * @param polynomialTwo the second polynomial
	 * @return polynomOne and polynomTwo XORed
	 */
	public static String xor(String polynomialOne, String polynomialTwo) {
		String result = "";
		String[] o = polynomialOne.split("x"), t = polynomialTwo.split("x");
		for(int i = 0; i<Math.max(o.length, t.length); i++) result += "x" + ((i < o.length ? Integer.parseInt(o[i]) : 0) ^ (i < t.length ? Integer.parseInt(t[i]) : 0));
		return clearZeros(result.substring(1));
	}

}

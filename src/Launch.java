
/**
 * Example class for using the AlphaNotation class as well as the DivisionProcessor class.
 * Please check the GitHub page for more information: https://github.com/NeoGames4/Reed-Solomon-Division-Processor
 * @author Mika Thein
 * @version 1.0 "Tay. Ham"
 */
public class Launch {
	
	public static void main(String[] args) {
		String messagePolynomial = AlphaNotation.toAlphaNotation("64x244x134x86x198x198x242x7x118x247x38x198x66x18x3x162x144x236x17x236x17x236");
		String generatorPolynomial = "0x210x171x247x242x93x230x14x109x221x53x200x74x8x172x98x80x219x134x160x105x165x231x";
		int[] result = new DivisionProcessor(generatorPolynomial, messagePolynomial).getRemainders();
		for(int r : result) System.out.println(r);
	}

}

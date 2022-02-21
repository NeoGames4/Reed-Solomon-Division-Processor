
/**
 * Example class for using the AlphaNotation class as well as the DivisionProcessor class.
 * Please check the GitHub page for more information: https://github.com/NeoGames4/Reed-Solomon-Division-Processor
 * @author Mika Thein
 * @version 1.0 "Tay. Ham"
 */
public class Launch {
	
	public static void main(String[] args) {
		String messagePolynom = AlphaNotation.toAlphaNotation("32x91x11x120x209x114x220x77x67x64x236x17x236x17x236x17");
		String generatorPolynom = "0x251x67x46x61x118x70x64x94x32x45";
		int[] result = new DivisionProcessor(generatorPolynom, messagePolynom).getRemainders();
		for(int r : result) System.out.println(r);
	}

}

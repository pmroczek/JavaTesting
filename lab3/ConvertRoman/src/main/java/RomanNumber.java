public class RomanNumber {
	private int arabicNumber;
	String[] romanNumbers = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; 
	int[] arabicNumbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 

	public RomanNumber(int arabicNumber) {
		if (arabicNumber < 1 || arabicNumber >= 4000)
			throw new IllegalArgumentException(
					"Invalid number, roman numbers accept range [1-3999]");

		this.arabicNumber = arabicNumber;
	}

	public String toString() {
		StringBuilder romanResult = new StringBuilder();
		for (int i = 0; i < romanNumbers.length; i++) {
			while (arabicNumber >= arabicNumbers[i]) {
				arabicNumber -= arabicNumbers[i];
				romanResult.append(romanNumbers[i]);
			}
		}

		return romanResult.toString();
	}
}

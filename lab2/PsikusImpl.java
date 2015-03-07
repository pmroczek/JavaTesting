import java.util.Random;

public class PsikusImpl implements Psikus {
	private static final int MinNumberLen = 1;
	private static final int MinNumberLenWithMinusSign = 2;

	@Override
	public Integer cyfrokrad(Integer liczba) {
		StringBuilder charsNumber = new StringBuilder(liczba.toString());

		if (hasOnlyOneDigit(charsNumber, liczba))
			return null;

		int indexToRemove = getRandomIndex(charsNumber.length(), liczba < 0);

		return convertStringToInt(deleteChar(charsNumber, indexToRemove,
				liczba < 0));
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		StringBuilder charsNumber = new StringBuilder(liczba.toString());

		if (hasOnlyOneDigit(charsNumber, liczba))
			throw new NieudanyPsikusException();

		int[] indexes = getRandomIndexes(charsNumber.length(), liczba < 0);

		return convertStringToInt(ReplaceDigits(charsNumber, indexes,
				liczba < 0));
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		String number = liczba.toString();
		if (number.contains("3") || number.contains("6")
				|| number.contains("7")) {
			return convertStringToInt(getRandomAndReplace(number));
		}

		return liczba;
	}

	private boolean hasOnlyOneDigit(StringBuilder charsNumber, Integer liczba) {
		return (charsNumber.length() == MinNumberLen)
				|| (liczba < 0 && charsNumber.length() == MinNumberLenWithMinusSign);
	}

	private int[] getRandomIndexes(int length, boolean isNegativeNumber) {
		int[] indexes = new int[2];

		do {
			indexes[0] = getRandomIndex(length, isNegativeNumber);
			indexes[1] = getRandomIndex(length, isNegativeNumber);
		} while (indexes[0] == indexes[1]);

		return indexes;
	}

	private int getRandomIndex(int range, boolean isNegativeNumer) {
		Random random = new Random();
		return random.nextInt(isNegativeNumer ? range - 1 : range);
	}

	private String getRandomAndReplace(String number) {
		StringBuilder charsNumber = new StringBuilder(number);
		Random random = new Random();
		int range = charsNumber.length();
		char randomedChar;
		int index;

		do {
			index = random.nextInt(range);
			randomedChar = charsNumber.charAt(index);
		} while ((randomedChar != '3' && randomedChar != '6' && randomedChar != '7')
				|| randomedChar == '-');

		charsNumber.replace(index, index + 1, GetReplaceString(randomedChar));

		return charsNumber.toString();
	}

	private String GetReplaceString(char randomedChar) {
		switch (randomedChar) {
		case '3':
			return "8";
		case '6':
			return "9";
		case '7':
			return "1";
		}

		return null;
	}

	private String deleteChar(StringBuilder charsNumber, int indexToRemove,
			boolean isNegative) {
		if (isNegative)
			charsNumber.deleteCharAt(0);

		charsNumber.deleteCharAt(indexToRemove);
		if (isNegative)
			charsNumber.insert(0, '-');

		return charsNumber.toString();
	}

	private String ReplaceDigits(StringBuilder charsNumber, int[] indexes,
			boolean isNegative) {

		if (isNegative)
			charsNumber.deleteCharAt(0);

		String tmpChar = charsNumber.subSequence(indexes[0], indexes[0] + 1)
				.toString();

		charsNumber.replace(indexes[0], indexes[0] + 1, charsNumber
				.subSequence(indexes[1], indexes[1] + 1).toString());
		charsNumber.replace(indexes[1], indexes[1] + 1, tmpChar);

		if (isNegative)
			charsNumber.insert(0, '-');

		return charsNumber.toString();
	}

	private Integer convertStringToInt(String number) {
		return Integer.valueOf(number);
	}
}

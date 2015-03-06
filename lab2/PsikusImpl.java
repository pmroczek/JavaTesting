import java.util.Random;

public class PsikusImpl implements Psikus {
	private static final int MinNumberLen = 1;
	private static final int MinNumberLenWithMinusSign = 2;

	@Override
	public Integer cyfrokrad(Integer liczba) {
		StringBuilder charsNumber = new StringBuilder(liczba.toString());

		if (hasOnlyOneDigit(charsNumber, liczba))
			return null;

		int indexToRemove = GetRandomIndex(charsNumber.length(), liczba < 0);

		return ConvertStringToInt(deleteChar(charsNumber, indexToRemove,
				liczba < 0));
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		StringBuilder charsNumber = new StringBuilder(liczba.toString());

		if (hasOnlyOneDigit(charsNumber, liczba))
			throw new NieudanyPsikusException();

		int[] indexes = GetRandomIndexes(charsNumber.length(), liczba < 0);

		return ConvertStringToInt(ReplaceDigits(charsNumber, indexes,
				liczba < 0));
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean hasOnlyOneDigit(StringBuilder charsNumber, Integer liczba) {
		return (charsNumber.length() == MinNumberLen)
				|| (liczba < 0 && charsNumber.length() == MinNumberLenWithMinusSign);
	}

	private int[] GetRandomIndexes(int length, boolean isNegativeNumber) {
		int[] indexes = new int[2];

		do {
			indexes[0] = GetRandomIndex(length, isNegativeNumber);
			indexes[1] = GetRandomIndex(length, isNegativeNumber);
		} while (indexes[0] == indexes[1]);

		return indexes;
	}

	private int GetRandomIndex(int range, boolean isNegativeNumer) {
		Random random = new Random();
		return random.nextInt(isNegativeNumer ? range - 1 : range);
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

	private Integer ConvertStringToInt(String number) {
		return Integer.valueOf(number);
	}
}

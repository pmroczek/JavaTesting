import java.util.Random;

public class PsikusImpl implements Psikus {
	private static final int MinNumberLen = 1;
	private static final int MinNumberLenWithMinusSign = 2;

	@Override
	public Integer cyfrokrad(Integer liczba) {
		StringBuilder charsNumber = new StringBuilder(liczba.toString());

		if (charsNumber.length() == MinNumberLen
				|| (liczba < 0 && charsNumber.length() == MinNumberLenWithMinusSign))
			return null;

		int indexToRemove = GetRandomIndex(charsNumber.length(), liczba < 0);

		charsNumber.deleteCharAt(indexToRemove);

		return ConvertStringToInt(charsNumber.toString());
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieduanyPsikusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	private int GetRandomIndex(int range, boolean isNegativeNumer) {
		Random random = new Random();
		int number = random.nextInt(range);

		if (isNegativeNumer && number == 0)
			while (number == 0)
				number = random.nextInt(range);

		return number;
	}

	private Integer ConvertStringToInt(String string) {
		return Integer.valueOf(string);
	}
}

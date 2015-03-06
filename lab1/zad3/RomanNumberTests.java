package zad3;

import org.junit.Test;

public class RomanNumberTests {
	@Test(expected = IllegalArgumentException.class)
	public void InitWithZero() {
		new RomanNumber(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void InitWithNegativeNumber() {
		new RomanNumber(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void InitWithOverRangeNumber() {
		new RomanNumber(4000);
	}
}

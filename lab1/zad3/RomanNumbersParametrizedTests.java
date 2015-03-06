package zad3;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanNumbersParametrizedTests {

	private int arabic;
	private String roman;

	public RomanNumbersParametrizedTests(int arabic, String roman) {
		this.arabic = arabic;
		this.roman = roman;
	}

	@Parameters(name = "{index}: RomanNumbers({0}) => {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, "I" }, { 2, "II" },
				{ 3, "III" }, { 4, "IV" }, { 5, "V" }, { 6, "VI" },
				{ 7, "VII" }, { 9, "IX" }, { 58, "LVII" }, { 100, "C" },
				{ 514, "DXIV" }, { 958, "CMLIII" }, { 3999, "MMMCMXCIX" } });
	}

	@Test
	public void CorrectTranformNumbers() {
		RomanNumber romanNumber = new RomanNumber(arabic);
		assertEquals(roman, romanNumber.toString());
	}
}

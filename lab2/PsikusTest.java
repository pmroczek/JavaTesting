import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public abstract class PsikusTest {
	public abstract Psikus createInstance();

	public Psikus psikus;
	private static final int RemoveMinusSign = 1;

	@Before
	public void setUp() {
		psikus = createInstance();
	}

	// cyfrokrad
	@Test
	public final void cyfrokradOneDigitReturnNull() {
		assertNull(psikus.cyfrokrad(1));
	}

	@Test
	public final void cyfrokradTwoDigitNoReturnNull() {
		assertNotNull(psikus.cyfrokrad(42));
	}

	@Test
	public final void cyfrokradLenTestWithTwoDigits() {
		assertEquals(1, psikus.cyfrokrad(32).toString().length());
	}

	@Test
	public final void cyfrokradLenTestWithTenDigits() {
		assertEquals(9, psikus.cyfrokrad(1234567890).toString().length());
	}

	@Test
	public final void cyfrokradNegetiveDigit() {
		assertNull(psikus.cyfrokrad(-1));
	}

	@Test
	public final void cyfrokradNegetiveTwoDigit() {
		assertNotNull(psikus.cyfrokrad(-12));
	}

	@Test
	public final void cyfrokradLenTestWithNegativeTwoDigits() {
		assertEquals(1, psikus.cyfrokrad(-32).toString().length()
				- RemoveMinusSign);
	}

	@Test
	public final void cyfrokradLenTestWithNegativeTenDigits() {
		assertEquals(9, psikus.cyfrokrad(-1234567890).toString().length()
				- RemoveMinusSign);
	}

	@Test
	public final void cyfrokradNoExeptionExpected() {
		try {
			psikus.cyfrokrad(1234567890);
		} catch (Exception e) {
			fail("No exception expected while cyfrkrad working!");
		}
	}

	// hultajchochla
	@Test(expected = NieudanyPsikusException.class)
	public final void hultajchochlaOneDigit() throws NieudanyPsikusException {
		psikus.hultajchochla(4);
	}

	@Test(expected = NieudanyPsikusException.class)
	public final void hultajchochlaOneNegativeDigit()
			throws NieudanyPsikusException {
		psikus.hultajchochla(-2);
	}

	@Test
	public final void hultajchochlaTwoDigitReplace()
			throws NieudanyPsikusException {
		assertEquals("14", psikus.hultajchochla(41).toString());
	}

	@Test
	public final void hultajchochlaTwoDigitReplace1()
			throws NieudanyPsikusException {
		assertEquals("85", psikus.hultajchochla(58).toString());
	}

	@Test
	public final void hultajchochlaTwoNegativeDigitReplace()
			throws NieudanyPsikusException {
		assertThat(psikus.hultajchochla(-58).toString(), CoreMatchers.allOf(
				CoreMatchers.containsString("-"),
				CoreMatchers.containsString("8"),
				CoreMatchers.containsString("5")));
	}

	@Test
	public final void hultajchochlaThreeDigitReplace()
			throws NieudanyPsikusException {
		assertThat(psikus.hultajchochla(278).toString(), CoreMatchers.allOf(
				CoreMatchers.containsString("2"),
				CoreMatchers.containsString("7"),
				CoreMatchers.containsString("8")));
	}

	@Test
	public final void hultajchochlaThreeNegativeDigitReplace()
			throws NieudanyPsikusException {
		assertThat(psikus.hultajchochla(-872).toString(), CoreMatchers.allOf(
				CoreMatchers.containsString("-"),
				CoreMatchers.containsString("2"),
				CoreMatchers.containsString("7"),
				CoreMatchers.containsString("8")));
	}

	@Test
	public final void hultajchochlaNoExeptionExpected() {
		try {
			psikus.hultajchochla(65247822);
		} catch (Exception e) {
			fail("No exception expected while cyfrkrad working!");
		}
	}
}

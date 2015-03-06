import static org.junit.Assert.*;

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

	@Test
	public final void OneDigitReturnNull() {
		assertNull(psikus.cyfrokrad(1));
	}

	@Test
	public final void TwoDigitNoReturnNull() {
		assertNotNull(psikus.cyfrokrad(42));
	}

	@Test
	public final void LenTestWithTwoDigits() {
		assertEquals(1, psikus.cyfrokrad(32).toString().length());
	}

	@Test
	public final void LenTestWithTenDigits() {
		assertEquals(9, psikus.cyfrokrad(1234567890).toString().length());
	}

	@Test
	public final void NegetiveDigit() {
		assertNull(psikus.cyfrokrad(-1));
	}

	@Test
	public final void NegetiveTwoDigit() {
		assertNotNull(psikus.cyfrokrad(-12));
	}

	@Test
	public final void LenTestWithNegativeTwoDigits() {
		assertEquals(1, psikus.cyfrokrad(-32).toString().length()
				- RemoveMinusSign);
	}

	@Test
	public final void LenTestWithNegativeTenDigits() {
		assertEquals(9, psikus.cyfrokrad(-1234567890).toString().length()
				- RemoveMinusSign);
	}

	@Test
	public final void NoExeptionExpected() {
		try {
			psikus.cyfrokrad(1234567890);
		} catch (Exception e) {
			fail("No exception expected while cyfrkrad working!");
		}
	}
}

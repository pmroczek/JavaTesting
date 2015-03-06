package zad1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTests {

	Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void addingTwoZeros() {
		assertEquals(0, calculator.add(0, 0));
	}

	@Test
	public void addingTwoPositiveNumbers() {
		assertEquals(140, calculator.add(127, 13));
	}

	@Test
	public void addingTwoPositiveAndNegativeResultIsPositive() {
		assertEquals(95, calculator.add(123, -28));
	}

	@Test
	public void addingTwoPositiveAndNegativeResultIsNegative() {
		assertEquals(-105, calculator.add(23, -128));
	}

	@Test
	public void addingTwoNegativeNumbers() {
		assertEquals(-366, calculator.add(-247, -119));
	}

	// subtraction
	@Test
	public void subtractionTwoZeros() {
		assertEquals(0, calculator.sub(0, 0));
	}

	@Test
	public void subtractionTwoPositiveNumbers() {
		assertEquals(-119, calculator.sub(12, 131));
	}

	@Test
	public void subtractionTwoPositiveAndNegativeResultIsPositive() {
		assertEquals(39, calculator.sub(15, -24));
	}

	@Test
	public void subtractionTwoPositiveAndNegativeResultIsNegative() {
		assertEquals(-151, calculator.sub(-23, 128));
	}

	@Test
	public void subtractionTwoNegativeNumbers() {
		assertEquals(-128, calculator.sub(-247, -119));
	}

	// multiplication
	@Test
	public void multiplicationTwoZeros() {
		assertEquals(0, calculator.multi(0, 0));
	}

	@Test
	public void multiplicationTwoPositiveNumbers() {
		assertEquals(143, calculator.multi(11, 13));
	}

	@Test
	public void multiplicationTwoPositiveAndNegativeResultIsPositive() {
		assertEquals(-636, calculator.multi(12, -53));
	}

	@Test
	public void multiplicationTwoNegativeAndPositiveResultIsNegative() {
		assertEquals(-630, calculator.multi(-42, 15));
	}

	@Test
	public void multiplicationTwoNegativeNumbers() {
		assertEquals(264, calculator.multi(-24, -11));
	}

	// division
	@Test(expected = ArithmeticException.class)
	public void divisionTwoZeros() {
		calculator.div(0, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void divisionPositiveByZero() {
		calculator.div(12, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void divisionNegativeByZero() {
		calculator.div(-18, 0);
	}

	@Test
	public void divisionZeroByPositive() {
		assertEquals(0, calculator.div(0, 18));
	}

	@Test
	public void divisionZeroByNagative() {
		assertEquals(0, calculator.div(0, -18));
	}

	@Test
	public void divisionTwoPositiveNumbers() {
		assertEquals(11, calculator.div(244, 22));
	}

	@Test
	public void divisionPositiveAndNegativeResultIsPositive() {
		assertEquals(0, calculator.div(12, -53));
	}

	@Test
	public void divisionNegativeAndPositiveResultIsNegative() {
		assertEquals(-3, calculator.div(-49, 15));
	}

	@Test
	public void divisionTwoNegativeNumbers() {
		assertEquals(2, calculator.div(-24, -11));
	}

	// greater
	@Test
	public void gratherTwoZeros() {
		assertFalse(calculator.greater(0, 0));
	}

	@Test
	public void gratherTwoPositiveNumbersResultTrue() {
		assertTrue(calculator.greater(12, 0));
	}

	@Test
	public void gratherTwoPositiveNumbersResultFalse() {
		assertFalse(calculator.greater(31, 32));
	}

	@Test
	public void gratherTwoSamePositiveNumbersResultFalse() {
		assertFalse(calculator.greater(31, 31));
	}

	@Test
	public void gratherTwoNegativeNumbersResultTrue() {
		assertTrue(calculator.greater(-7, -12));
	}

	@Test
	public void gratherTwoNegativeNumbersResultFalse() {
		assertFalse(calculator.greater(-4, -3));
	}

	@Test
	public void gratherTwoSameNegativeNumbersResultFalse() {
		assertFalse(calculator.greater(-12, -12));
	}
}

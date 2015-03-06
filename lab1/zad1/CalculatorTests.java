package zad1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CalculatorTests {

	@Test
	public void addingTwoZeros() {
		Calculator calculator = new Calculator();
		int result = calculator.add(0, 0);
		assertEquals(0, result);
	}

	@Test
	public void addingTwoPositiveNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.add(127, 13);
		assertEquals(140, result);
	}

	@Test
	public void addingTwoPositiveAndNegativeResultIsPositive() {
		Calculator calculator = new Calculator();
		int result = calculator.add(123, -28);
		assertEquals(95, result);
	}

	@Test
	public void addingTwoPositiveAndNegativeResultIsNegative() {
		Calculator calculator = new Calculator();
		int result = calculator.add(23, -128);
		assertEquals(-105, result);
	}

	@Test
	public void addingTwoNegativeNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.add(-247, -119);
		assertEquals(-366, result);
	}

	// subtraction
	@Test
	public void subtractionTwoZeros() {
		Calculator calculator = new Calculator();
		int result = calculator.sub(0, 0);
		assertEquals(0, result);
	}

	@Test
	public void subtractionTwoPositiveNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.sub(12, 131);
		assertEquals(-119, result);
	}

	@Test
	public void subtractionTwoPositiveAndNegativeResultIsPositive() {
		Calculator calculator = new Calculator();
		int result = calculator.sub(15, -24);
		assertEquals(39, result);
	}

	@Test
	public void subtractionTwoPositiveAndNegativeResultIsNegative() {
		Calculator calculator = new Calculator();
		int result = calculator.sub(-23, 128);
		assertEquals(-151, result);
	}

	@Test
	public void subtractionTwoNegativeNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.sub(-247, -119);
		assertEquals(-128, result);
	}

	// multiplication
	@Test
	public void multiplicationTwoZeros() {
		Calculator calculator = new Calculator();
		int result = calculator.multi(0, 0);
		assertEquals(0, result);
	}

	@Test
	public void multiplicationTwoPositiveNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.multi(11, 13);
		assertEquals(143, result);
	}

	@Test
	public void multiplicationTwoPositiveAndNegativeResultIsPositive() {
		Calculator calculator = new Calculator();
		int result = calculator.multi(12, -53);
		assertEquals(-636, result);
	}

	@Test
	public void multiplicationTwoNegativeAndPositiveResultIsNegative() {
		Calculator calculator = new Calculator();
		int result = calculator.multi(-42, 15);
		assertEquals(-630, result);
	}

	@Test
	public void multiplicationTwoNegativeNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.multi(-24, -11);
		assertEquals(264, result);
	}

	// division
	@Test(expected = ArithmeticException.class)
	public void divisionTwoZeros() {
		Calculator calculator = new Calculator();
		calculator.div(0, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void divisionPositiveByZero() {
		Calculator calculator = new Calculator();
		calculator.div(12, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void divisionNegativeByZero() {
		Calculator calculator = new Calculator();
		calculator.div(-18, 0);
	}

	@Test
	public void divisionZeroByPositive() {
		Calculator calculator = new Calculator();
		int result = calculator.div(0, 18);
		assertEquals(0, result);
	}

	@Test
	public void divisionZeroByNagative() {
		Calculator calculator = new Calculator();
		int result = calculator.div(0, -18);
		assertEquals(0, result);
	}

	@Test
	public void divisionTwoPositiveNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.div(244, 22);
		assertEquals(11, result);
	}

	@Test
	public void divisionPositiveAndNegativeResultIsPositive() {
		Calculator calculator = new Calculator();
		int result = calculator.div(12, -53);
		assertEquals(0, result);
	}

	@Test
	public void divisionNegativeAndPositiveResultIsNegative() {
		Calculator calculator = new Calculator();
		int result = calculator.div(-49, 15);
		assertEquals(-3, result);
	}

	@Test
	public void divisionTwoNegativeNumbers() {
		Calculator calculator = new Calculator();
		int result = calculator.div(-24, -11);
		assertEquals(2, result);
	}

	// greater
	@Test
	public void gratherTwoZeros() {
		Calculator calculator = new Calculator();
		boolean result = calculator.greater(0, 0);
		assertFalse(result);
	}

	@Test
	public void gratherTwoPositiveNumbersResultTrue() {
		Calculator calculator = new Calculator();
		boolean result = calculator.greater(12, 0);
		assertTrue(result);
	}

	@Test
	public void gratherTwoPositiveNumbersResultFalse() {
		Calculator calculator = new Calculator();
		boolean result = calculator.greater(31, 32);
		assertFalse(result);
	}

	@Test
	public void gratherTwoSamePositiveNumbersResultFalse() {
		Calculator calculator = new Calculator();
		boolean result = calculator.greater(31, 31);
		assertFalse(result);
	}

	@Test
	public void gratherTwoNegativeNumbersResultTrue() {
		Calculator calculator = new Calculator();
		boolean result = calculator.greater(-7, -12);
		assertTrue(result);
	}

	@Test
	public void gratherTwoNegativeNumbersResultFalse() {
		Calculator calculator = new Calculator();
		boolean result = calculator.greater(-4, -3);
		assertFalse(result);
	}

	@Test
	public void gratherTwoSameNegativeNumbersResultFalse() {
		Calculator calculator = new Calculator();
		boolean result = calculator.greater(-12, -12);
		assertFalse(result);
	}

	/*
	 * @Test public void addingTwoExtremeValues() { int a = -2147483648; int b =
	 * Integer.MAX_VALUE; a = a - 1; b = b + 1;
	 * System.out.println(Integer.MAX_VALUE); System.out.println(b);
	 * System.out.println(a); Calculator calculator = new Calculator(); int
	 * result = calculator.add(-247, -119); assertEquals(-366, result);
	 * 
	 * }
	 */
}

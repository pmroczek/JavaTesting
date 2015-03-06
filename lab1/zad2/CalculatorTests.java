package zad2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTests {

	private static Calculator calculator;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void addingTwoZeros() {
		double result = calculator.add(0.0, 0.0);
		assertEquals(0.0, result, DELTA);
	}

	@Test
	public void addingTwoPositiveNumbers() {
		double result = calculator.add(127.22, 13.54);
		assertEquals(140.76, result, DELTA);
	}

	@Test
	public void addingTwoPositiveAndNegativeResultIsPositive() {
		double result = calculator.add(123.1231, -28.2321);
		assertEquals(94.891, result, DELTA);
	}

	@Test
	public void addingTwoPositiveAndNegativeResultIsNegative() {
		double result = calculator.add(23.12, -128.42);
		assertEquals(-105.3, result, DELTA);
	}

	@Test
	public void addingTwoNegativeNumbers() {
		double result = calculator.add(-247.123, -119.421);
		assertEquals(-366.544, result, DELTA);
	}

	// subtraction
	@Test
	public void subtractionTwoZeros() {
		double result = calculator.sub(0.0, 0.0);
		assertEquals(0.0, result, DELTA);
	}

	@Test
	public void subtractionTwoPositiveNumbers() {
		double result = calculator.sub(12.32, 131.43);
		assertEquals(-119.11, result, DELTA);
	}

	@Test
	public void subtractionTwoPositiveAndNegativeResultIsPositive() {
		double result = calculator.sub(15.42, -24.15);
		assertEquals(39.57, result, DELTA);
	}

	@Test
	public void subtractionTwoPositiveAndNegativeResultIsNegative() {
		double result = calculator.sub(-23.531, 128.621);
		assertEquals(-151.152, result, DELTA);
	}

	@Test
	public void subtractionTwoNegativeNumbers() {
		double result = calculator.sub(-247.71, -119.562);
		assertEquals(-128.148, result, DELTA);
	}

	// multiplication
	@Test
	public void multiplicationTwoZeros() {
		double result = calculator.multi(0.00, 0.00);
		assertEquals(0.0, result, DELTA);
	}

	@Test
	public void multiplicationTwoPositiveNumbers() {
		double result = calculator.multi(11.51, 13.731);
		assertEquals(158.04381, result, DELTA);
	}

	@Test
	public void multiplicationTwoPositiveAndNegativeResultIsPositive() {
		double result = calculator.multi(12.61, -53.75);
		assertEquals(-677.7875, result, DELTA);
	}

	@Test
	public void multiplicationTwoNegativeAndPositiveResultIsNegative() {
		double result = calculator.multi(-42.254, 15.965);
		assertEquals(-674.58511, result, DELTA);
	}

	@Test
	public void multiplicationTwoNegativeNumbers() {
		double result = calculator.multi(-24.932, -11.254);
		assertEquals(280.584728, result, DELTA);
	}

	// division
	@Test(expected = ArithmeticException.class)
	public void divisionTwoZeros() {
		calculator.div(0.0, 0.0);
	}

	@Test(expected = ArithmeticException.class)
	public void divisionPositiveByZero() {
		calculator.div(12.77, 0.0);
	}

	@Test(expected = ArithmeticException.class)
	public void divisionNegativeByZero() {
		calculator.div(-18.23, 0.0);
	}

	@Test
	public void divisionZeroByPositive() {
		double result = calculator.div(0, 18.73);
		assertEquals(0, result, DELTA);
	}

	@Test
	public void divisionZeroByNagative() {
		double result = calculator.div(0, -18.012);
		assertEquals(0, result, DELTA);
	}

	@Test
	public void divisionTwoPositiveNumbers() {
		double result = calculator.div(244, 22.05);
		assertEquals(11.065759637188208, result, DELTA);
	}

	@Test
	public void divisionPositiveAndNegativeResultIsPositive() {
		double result = calculator.div(12.63, -53.01);
		assertEquals(-0.2382569326542162, result, DELTA);
	}

	@Test
	public void divisionNegativeAndPositiveResultIsNegative() {
		double result = calculator.div(-49.032, 15.64);
		assertEquals(-3.135038363171355, result, DELTA);
	}

	@Test
	public void divisionTwoNegativeNumbers() {
		double result = calculator.div(-24.6301, -11.620);
		assertEquals(2.119629948364888, result, DELTA);
	}

	// greater
	@Test
	public void gratherTwoZeros() {
		boolean result = calculator.greater(0.0, 0.0);
		assertFalse(result);
	}

	@Test
	public void gratherTwoPositiveNumbersResultTrue() {
		boolean result = calculator.greater(12.531, 0);
		assertTrue(result);
	}

	@Test
	public void gratherTwoPositiveNumbersResultFalse() {
		boolean result = calculator.greater(31.9999999, 32.00);
		assertFalse(result);
	}

	@Test
	public void gratherTwoSamePositiveNumbersResultFalse() {
		boolean result = calculator.greater(31.99991111, 31.99991111);
		assertFalse(result);
	}

	@Test
	public void gratherTwoNegativeNumbersResultTrue() {
		boolean result = calculator.greater(-7.121, -12.1451);
		assertTrue(result);
	}

	@Test
	public void gratherTwoNegativeNumbersResultFalse() {
		boolean result = calculator.greater(-4.00000001, -3.9999);
		assertFalse(result);
	}

	@Test
	public void gratherTwoSameNegativeNumbersResultFalse() {
		boolean result = calculator.greater(-12.0000001, -12.0000001);
		assertFalse(result);
	}
}

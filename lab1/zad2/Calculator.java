package zad2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
	private BigDecimal bigA;
	private BigDecimal bigB;
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	private static final int RoundingPrecision = 16;
	
	public double add(double a, double b) {
		SetsBigsValues(a, b);
		return bigA.add(bigB).doubleValue();
	}

	public double sub(double a, double b) {
		SetsBigsValues(a, b);
		return bigA.subtract(bigB).doubleValue();
	}

	public double multi(double a, double b) {
		SetsBigsValues(a, b);
		return bigA.multiply(bigB).doubleValue();
	}

	public double div(double a, double b) {

		if (b == 0.0)
			throw new ArithmeticException();

		SetsBigsValues(a, b);
		return bigA.divide(bigB, RoundingPrecision, roundingMode).doubleValue();
	}

	public boolean greater(double a, double b) {
		return a > b;
	}

	private void SetsBigsValues(double a, double b) {
		bigA = BigDecimal.valueOf(a);
		bigB = BigDecimal.valueOf(b);
	}
}

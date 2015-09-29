public class Complex {

	protected double a;
	protected double b;

	/**
	 * Creates a Complex number with components a + bi.
	 * @param a
	 * @param b
	 */
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}

	/**
	 * Creates the Complex representation of zero.
	 */
	public Complex() {
		this(0, 0);
	}

	/**
	 * Returns the sum of the two Complex numbers.
	 * @param c
	 * @return sum
	 */
	public Complex plus(Complex c) {
		return new Complex(a + c.a, b + c.b);
	}

	/**
	 * Returns the difference of the two Complex numbers.
	 * @param c
	 * @return difference
	 */
	public Complex minus(Complex c) {
		return plus(c.neg());
	}

	/**
	 * Returns the products of the two Complex numbers.
	 * @param c
	 * @return product
	 */
	public Complex times(Complex c) {
		return new Complex(
			a * c.a - b * c.b,
			a * c.b + b * c.a
		);
	}

	/**
	 * Returns the quotient of the two Complex numbers.
	 * @param c
	 * @return quotient
	 */
	public Complex over(Complex c) {
		double k = c.abs();
		return times(c.conj()).scale(1 / (k * k));
	}

	/**
	 * Returns the magnitude of the Complex number.
	 * @return magnitude
	 */
	public double abs() {
		return Math.hypot(a, b);
	}

	/**
	 * Returns a Complex number sheared by (k, l).
	 * @param k
	 * @param l
	 * @return shear
	 */
	public Complex shear(double k, double l) {
		return new Complex(a * k, b * l);
	}

	/**
	 * Returns a Complex number scaled by k.
	 * @param k
	 * @return dilation
	 */
	public Complex scale(double k) {
		return shear(k, k);
	}

	/**
	 * Returns the opposite of the Complex number.
	 * @return opposite
	 */
	public Complex neg() {
		return new Complex(-a, -b);
	}

	/**
	 * Returns the conjugate of the Complex number.
	 * @return conjugate
	 */
	public Complex conj() {
		return new Complex(a, -b);
	}

}

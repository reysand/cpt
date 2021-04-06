public class ComplexNumbers {
	/**
	 * Represents the real part of a complex number
	 **/
	private double re;

	/**
	 * Represents the imaginary part of a complex number
	 **/
	private double im;

	/**
	 * Default constructor
	 **/
	public ComplexNumbers() {
		this.re = 0.0;
		this.im = 0.0;
	}

	/**
	 * Initialization constructor
	 **/
	public ComplexNumbers(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public void squareAndAdd(ComplexNumbers numbers) {
		double real = this.re * this.re - this.im * this.im + numbers.re;
		double imaginary = 2 * this.re * this.im + numbers.im;

		this.re = real;
		this.im = imaginary;
	}

	public double getSquareAbs() {
		return this.re * this.re + this.im * this.im;
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	public void setRe(double re) {
		this.re = re;
	}

	public void setIm(double im) {
		this.im = im;
	}
}

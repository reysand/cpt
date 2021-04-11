import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
	/**
	 * Maximum number of iterations
	 */
	public static final int MAX_ITERATIONS = 2000;

	/**
	 * Changes the margins of the rectangle to display the correct starting
	 * range for the fractal.
	 **/
	@Override
	public void getInitialRange(Rectangle2D.Double range) {
		range.x = -2;
		range.y = -1.5;
		range.width = 3;
		range.height = 3;
	}

	/**
	 * Iteration function for a fractal
	 */
	@Override
	public int numIterations(double x, double y) {
		double real = 0;
		double imaginary = 0;
		double squareAdd = real * real + imaginary * imaginary;
		int i = 0;

		while (i < MAX_ITERATIONS && squareAdd <= 4) {
			double realTemp = real * real - imaginary * imaginary + x;
			double imaginaryTemp = 2 * real * imaginary + y;

			real = realTemp;
			imaginary = imaginaryTemp;
			squareAdd = real * real + imaginary * imaginary;
			++i;
		}
		if (i == MAX_ITERATIONS) {
			return -1;
		}
		return i;
	}

	/**
	 * Returning the name of the fractal
	 */
	@Override
	public String toString() {
		return "Mandelbrot";
	}
}

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
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

	@Override
	public int numIterations(double x, double y) {
		ComplexNumbers real = new ComplexNumbers(x, y);
		ComplexNumbers imaginary = new ComplexNumbers();
		int i = 0;

		while (i < MAX_ITERATIONS && imaginary.getSquareAbs() <= 4) {
			imaginary.squareAndAdd(real);
			++i;
		}
		if (i == MAX_ITERATIONS) {
			return -1;
		}
		return i;
	}
}

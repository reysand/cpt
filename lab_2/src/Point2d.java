/*
** 2D class of a point
*/
public class	Point2d {

	/* X coordinate */
	private double	xCoord;

	/* Y coordinate */
	private double	yCoord;

	/* Initialization constructor */
	public	Point2d(double x, double y) {
		xCoord = x;
		yCoord = y;
	}

	/* Default constructor */
	public	Point2d() {
		// Call the constructor with two parameters and define the source
		this(0, 0);
	}

	/* Returning the X coordinate */
	public double	getX() {
		return xCoord;
	}

	/* Returning the Y coordinate */
	public double	getY() {
		return yCoord;
	}

	/* Setting the X coordinate value */
	public void	setX(double val) {
		xCoord = val;
	}

	/* Setting the Y coordinate value */
	public void	setY(double val) {
		yCoord = val;
	}
}

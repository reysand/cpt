/*
** 3D class of a point
*/
public class Point3d {
	/* X coordinate */
	private double xCoord;

	/* Y coordinate */
	private double yCoord;

	/* Z coordinate */
	private double zCoord;

	/* Initialization constructor */
	public Point3d(double x, double y, double z) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}

	/* Default constructor */
	public Point3d() {
		// Call the constructor with three parameters and define the source
		this(0, 0, 0);
	}

	/* Get the distance between this point and the specified point */
	public double distanceTo(Point3d point3d) {
		double x = Math.pow(point3d.xCoord - xCoord, 2);
		double y = Math.pow(point3d.yCoord - yCoord, 2);
		double z = Math.pow(point3d.zCoord - zCoord, 2);
		return Math.round(Math.sqrt(x + y + z) * 100.0) / 100.0;
	}

	/* Check if this point is equal to the specified point */
	public boolean equalTo(Point3d point3d) {
		return point3d.xCoord == xCoord && point3d.yCoord == yCoord &&
				point3d.zCoord == zCoord;
	}

	/* Returning the X coordinate */
	public double getX() {
		return xCoord;
	}

	/* Returning the Y coordinate */
	public double getY() {
		return yCoord;
	}

	/* Returning the Z coordinate */
	public double getZ() {
		return zCoord;
	}

	/* Setting the X coordinate value */
	public void setX(double val) {
		xCoord = val;
	}

	/* Setting the Y coordinate value */
	public void setY(double val) {
		yCoord = val;
	}

	/* Setting the Z coordinate value */
	public void setZ(double val) {
		zCoord = val;
	}
}

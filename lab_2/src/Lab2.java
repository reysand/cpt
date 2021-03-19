import java.util.Scanner;

public class Lab2 {
	public static void main(String[] args) {
		Point3d[] points = new Point3d[3];
		for (int i = 0; i < points.length; ++i) {
			points[i] = new Point3d();
			System.out.println("Point #" + (i + 1));
			input(points[i]);
		}
		if (points[0].equalTo(points[1]) || points[0].equalTo(points[2])
				|| points[1].equalTo(points[2]))
		{
			System.out.println("This is not a triangle");
		}
		else
		{
			System.out.println("Area = " +
					computeArea(points[0], points[1], points[2]));
		}
	}

	/* Read point coordinates */
	public static void input(Point3d point3d)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Write the x coordinate: ");
		point3d.setX(scanner.nextDouble());
		System.out.print("Write the y coordinate: ");
		point3d.setY(scanner.nextDouble());
		System.out.print("Write the z coordinate: ");
		point3d.setZ(scanner.nextDouble());
	}

	/* Get the area of a triangle from three points */
	public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
		double a = p1.distanceTo(p2);
		double b = p1.distanceTo(p3);
		double c = p2.distanceTo(p3);
		double res = (a + b + c) / 2;
		res = Math.sqrt(res * (res - a) * (res - b) * (res - c));
		return Math.round(res * 100.0) / 100.0;
	}
}

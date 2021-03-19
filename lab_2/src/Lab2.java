import java.util.Scanner;

public class	Lab2 {
	public static void	main(String[] args) {
		Point3d firstPoint = new Point3d();
		Point3d secondPoint = new Point3d();
		Point3d thirdPoint = new Point3d();

		System.out.println("First point");
		input(firstPoint);
		System.out.println("Second point");
		input(secondPoint);
		System.out.println("Third point");
		input(thirdPoint);
		System.out.println(firstPoint.distanceTo(secondPoint));
		System.out.println(firstPoint.distanceTo(thirdPoint));
		System.out.println(secondPoint.distanceTo(thirdPoint));
		if (firstPoint.equalTo(secondPoint) || firstPoint.equalTo(thirdPoint)
				|| secondPoint.equalTo(thirdPoint))
		{
			System.out.println("This is not a triangle");
		}
		else
		{
			System.out.println("Area = " + computeArea(firstPoint, secondPoint,
					thirdPoint));
		}
	}

	/* Read point coordinates */
	public static void	input(Point3d point3d)
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
	public static double	computeArea(Point3d p1, Point3d p2, Point3d p3) {
		double a;
		double b;
		double c;
		double res;

		a = p1.distanceTo(p2);
		b = p1.distanceTo(p3);
		c = p2.distanceTo(p3);
		res = (a + b + c) / 2;
		res = Math.sqrt(res * (res - a) * (res - b) * (res - c));
		return Math.round(res * 100.0) / 100.0;
	}
}

import com.github.otsoko.bezier.CubicBezierCurve;
import com.github.otsoko.bezier.LinearBezierCurve;
import com.github.otsoko.bezier.Point;
import com.github.otsoko.bezier.QuadraticBezierCurve;

public class Main {

    public static void main(String[] args) {
        Point start = new Point(116, 630);
        Point c1 = new Point(220, 660);
        Point c2 = new Point(510, 540);
        Point end = new Point(680, 620);
        Point calculated = null;

        int numberOfPoints = 5;
        float dt = 1.0f / (numberOfPoints - 1);

        LinearBezierCurve linearCurve = new LinearBezierCurve(start, end);
        System.out.println("Linear:");
        for (int i = 0; i < numberOfPoints; i++) {
            calculated = linearCurve.getPointAtCurve(dt * i);
            System.out.println(calculated.toString());
        }

        System.out.println("\nQuadratic:");
        QuadraticBezierCurve quadraticCurve = new QuadraticBezierCurve(start, c1, end);
        for (int i = 0; i < numberOfPoints; i++) {
            calculated = quadraticCurve.getPointAtCurve(dt * i);
            System.out.println(calculated.toString());
        }

        CubicBezierCurve cubicCurve = new CubicBezierCurve(start, c1, c2, end);
        System.out.println("\nCubic:");
        for (int i = 0; i < numberOfPoints; i++) {
            calculated = cubicCurve.getPointAtCurve(dt * i);
            System.out.println(calculated.toString());
        }
    }
}

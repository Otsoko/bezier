package com.github.otsoko.bezier;

/**
 * Class BezierCurveCubic
 * 
 * @author Otsoko
 *
 */
public class LinearBezierCurve extends BezierCurve {

    public LinearBezierCurve(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Calculates the point on the curve in step t
     * 
     * @param t
     *        the step on the curve
     * @return the point in the step t
     */
    public Point getPointAtCurve(float t) {
        float x = start.getX() * (1 - t) + end.getX() * t;
        float y = start.getY() * (1 - t) + end.getY() * t;

        float rx = end.getX() - start.getX();
        float ry = end.getY() - start.getY();

        float angle = (float) Math.toDegrees(Math.atan2(ry, rx));

        return new Point(x, y, angle);
    }

}

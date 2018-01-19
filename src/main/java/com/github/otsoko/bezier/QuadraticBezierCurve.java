package com.github.otsoko.bezier;

/**
 * Class BezierCurveCubic
 * 
 * @author Otsoko
 *
 */
public class QuadraticBezierCurve extends BezierCurve {

    private Point c1 = null;

    public QuadraticBezierCurve(Point start, Point c1, Point end) {
        this.start = start;
        this.c1 = c1;
        this.end = end;
    }

    /**
     * Gets the first control point
     * 
     * @return the first control point
     */
    public Point getC1() {
        return c1;
    }

    /**
     * Sets the first control point
     * 
     * @param c1
     *        the first control point
     */
    public void setC1(Point c1) {
        this.c1 = c1;
    }

    /**
     * Calculates the point on the curve in step t
     * 
     * @param t
     *        the step on the curve
     * @return the point in the step t
     */
    public Point getPointAtCurve(float t) {
        float t_squared = t * t;
        float minus_t_squared = (1 - t) * (1 - t);

        float x = start.getX() * minus_t_squared + 2 * c1.getX() * t * (1 - t) + end.getX() * t_squared;
        float y = start.getY() * minus_t_squared + 2 * c1.getY() * t * (1 - t) + end.getY() * t_squared;

        float rx = (1 - t) * (c1.getX() - start.getX()) + t * (end.getX() - c1.getX());
        float ry = (1 - t) * (c1.getY() - start.getY()) + t * (end.getY() - c1.getY());

        float angle = (float) Math.toDegrees(Math.atan2(ry, rx));

        return new Point(x, y, angle);
    }

}

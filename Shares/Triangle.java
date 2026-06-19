/**
 * A concrete shape: Triangle defined by three sides.
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class Triangle extends Shape {

    private double a; // side 1
    private double b; // side 2
    private double c; // side 3

    /**
     * Creates a Triangle with three sides.
     * Throws InvalidShapeException if any side is non-positive
     * or if the three sides violate the triangle inequality
     * (the sum of any two sides must be greater than the third).
     *
     * @param a side 1
     * @param b side 2
     * @param c side 3
     */
    public Triangle(double a, double b, double c) {
        super();
        validateSides(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Creates a Triangle with color, fill, and three sides.
     */
    public Triangle(String color, boolean filled, double a, double b, double c) {
        super(color, filled);
        validateSides(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void validateSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new InvalidShapeException(
                "All triangle sides must be positive. Got: "
                + a + ", " + b + ", " + c);
        }
        // Triangle inequality rule
        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            throw new InvalidShapeException(
                "Invalid triangle: sides " + a + ", " + b + ", " + c
                + " violate the triangle inequality.");
        }
    }

    public double getSideA() { return a; }
    public double getSideB() { return b; }
    public double getSideC() { return c; }

    /**
     * Calculates area using Heron's formula.
     */
    @Override
    public double getArea() {
        double s = (a + b + c) / 2.0;  // semi-perimeter
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    /**
     * Scales all three sides by the given factor.
     */
    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException(
                "Resize factor must be positive. Got: " + factor);
        }
        this.a *= factor;
        this.b *= factor;
        this.c *= factor;
    }

    @Override
    public String toString() {
        return "Triangle[color=" + color + ", filled=" + filled
                + ", sides=(" + String.format("%.2f", a)
                + ", " + String.format("%.2f", b)
                + ", " + String.format("%.2f", c) + ")"
                + ", area=" + String.format("%.2f", getArea())
                + ", perimeter=" + String.format("%.2f", getPerimeter())
                + "]";
    }
}

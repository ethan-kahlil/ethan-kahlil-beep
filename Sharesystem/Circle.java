/**
 * A concrete shape: Circle defined by its radius.
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class Circle extends Shape {

    private double radius;

    /**
     * Creates a Circle with a given radius.
     * Throws InvalidShapeException if radius is non-positive.
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        super();
        if (radius <= 0) {
            throw new InvalidShapeException(
                "Circle radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    /**
     * Creates a Circle with color, fill, and radius.
     *
     * @param color  the color
     * @param filled fill status
     * @param radius the radius
     */
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException(
                "Circle radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    public void setRadius(double radius) {
        if (radius <= 0) throw new InvalidShapeException("Radius must be positive.");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Scales the radius by the given factor.
     * Factor must be positive.
     */
    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException(
                "Resize factor must be positive. Got: " + factor);
        }
        this.radius *= factor;
    }

    @Override
    public String toString() {
        return "Circle[color=" + color + ", filled=" + filled
                + ", radius=" + String.format("%.2f", radius)
                + ", area=" + String.format("%.2f", getArea())
                + ", perimeter=" + String.format("%.2f", getPerimeter())
                + "]";
    }
}

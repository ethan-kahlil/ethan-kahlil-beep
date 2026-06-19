/**
 * Abstract base class for all geometric shapes.
 *
 * Shape is declared abstract because a generic "shape" has no real definition
 * of area or perimeter on its own. Every concrete shape must provide those.
 * Attempting new Shape() directly causes a compile-time error:
 *   "Shape is abstract; cannot be instantiated"
 *
 * @author Prince (Student)
 * @version 1.0
 */
public abstract class Shape {

    protected String  color  = "white";
    protected boolean filled;

    /** Default constructor. */
    public Shape() { }

    /**
     * Creates a Shape with a specific color and fill setting.
     *
     * @param color  the color of the shape
     * @param filled true if the shape is filled
     */
    public Shape(String color, boolean filled) {
        this.color  = color;
        this.filled = filled;
    }

    // ---- Abstract methods (every subclass MUST override these) ----

    /** Returns the area of the shape. */
    public abstract double getArea();

    /** Returns the perimeter of the shape. */
    public abstract double getPerimeter();

    /**
     * Scales all dimensions by the given factor.
     * A non-positive factor must throw InvalidShapeException.
     *
     * @param factor the scaling factor
     */
    public abstract void resize(double factor);

    // ---- Getters / Setters ----

    public String getColor() { return color; }

    public boolean isFilled() { return filled; }

    public void setColor(String color) { this.color = color; }

    public void setFilled(boolean filled) { this.filled = filled; }

    /**
     * Concrete toString available to all subclasses.
     */
    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled
                + ", area=" + String.format("%.2f", getArea())
                + ", perimeter=" + String.format("%.2f", getPerimeter())
                + "]";
    }
}

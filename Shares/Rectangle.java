/**
 * A concrete shape: Rectangle defined by width and height.
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    /**
     * Creates a Rectangle with given width and height.
     * Throws InvalidShapeException if either dimension is non-positive.
     *
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(double width, double height) {
        super();
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException(
                "Rectangle dimensions must be positive. Got width="
                + width + ", height=" + height);
        }
        this.width  = width;
        this.height = height;
    }

    /**
     * Creates a Rectangle with color, fill, width, and height.
     */
    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException(
                "Rectangle dimensions must be positive.");
        }
        this.width  = width;
        this.height = height;
    }

    public double getWidth()  { return width; }
    public double getHeight() { return height; }

    public void setWidth(double width) {
        if (width <= 0) throw new InvalidShapeException("Width must be positive.");
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) throw new InvalidShapeException("Height must be positive.");
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    /**
     * Scales both width and height by the given factor.
     */
    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException(
                "Resize factor must be positive. Got: " + factor);
        }
        this.width  *= factor;
        this.height *= factor;
    }

    @Override
    public String toString() {
        return "Rectangle[color=" + color + ", filled=" + filled
                + ", width=" + String.format("%.2f", width)
                + ", height=" + String.format("%.2f", height)
                + ", area=" + String.format("%.2f", getArea())
                + ", perimeter=" + String.format("%.2f", getPerimeter())
                + "]";
    }
}

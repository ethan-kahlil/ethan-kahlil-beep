/**
 * Driver class demonstrating the Shape hierarchy.
 * Shows polymorphism, dynamic binding, InvalidShapeException handling,
 * printAreas, and largest shape detection.
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class ShapeDemo {

    /**
     * Prints the area of each shape via a superclass reference.
     * This is DYNAMIC BINDING: at runtime, the JVM calls the correct
     * getArea() for each actual object type, not the abstract Shape version.
     *
     * @param shapes array of Shape references
     */
    public static void printAreas(Shape[] shapes) {
        System.out.println("-- printAreas (Dynamic Binding Demo) --");
        for (Shape s : shapes) {
            // s.getArea() resolves at runtime to Circle/Rectangle/Triangle.getArea()
            System.out.println(s.getClass().getSimpleName()
                    + " area = " + String.format("%.2f", s.getArea()));
        }
    }

    /**
     * Returns the shape with the largest area by comparing getArea() values.
     *
     * @param shapes array of Shape references
     * @return the Shape with the maximum area
     */
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) return null;
        Shape max = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > max.getArea()) {
                max = shapes[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("===== SHAPE SYSTEM DEMO =====\n");

        // --- 1. Create valid shapes ---
        System.out.println("-- Creating Valid Shapes --");
        Circle    circle    = new Circle("red",   true,  7.0);
        Rectangle rectangle = new Rectangle("blue", false, 5.0, 10.0);
        Triangle  triangle  = new Triangle("green", true,  3.0, 4.0, 5.0);

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(triangle);
        System.out.println();

        // --- 2. Demonstrate resize ---
        System.out.println("-- Resize Circle by factor 2 --");
        circle.resize(2.0);
        System.out.println("After resize: " + circle);
        System.out.println();

        // --- 3. Demonstrate InvalidShapeException with a bad triangle ---
        System.out.println("-- Attempting invalid Triangle (1, 2, 100) --");
        try {
            Triangle bad = new Triangle(1.0, 2.0, 100.0);  // violates triangle inequality
        } catch (InvalidShapeException e) {
            System.out.println("Caught InvalidShapeException: " + e.getMessage());
        }
        System.out.println();

        // --- 4. Demonstrate invalid resize factor ---
        System.out.println("-- Attempting resize with factor -1 --");
        try {
            rectangle.resize(-1.0);
        } catch (InvalidShapeException e) {
            System.out.println("Caught InvalidShapeException: " + e.getMessage());
        }
        System.out.println();

        // --- 5. printAreas - demonstrates dynamic binding ---
        // Circle was resized to radius 14, so its area is large
        Shape[] shapes = { circle, rectangle, triangle };
        printAreas(shapes);
        System.out.println();

        /*
         * DYNAMIC BINDING EXPLANATION:
         * When printAreas calls s.getArea() through the Shape reference,
         * the JVM does NOT call Shape.getArea() (which is abstract).
         * Instead it dispatches to the actual runtime type's method.
         * For example, for the Circle object in the array:
         *   s.getArea()  -->  resolves to  Circle.getArea()  -->  Math.PI * 14 * 14
         * This is polymorphism: one method call, different behaviour per type.
         */

        // --- 6. Find and print the largest shape ---
        System.out.println("-- Largest Shape --");
        Shape big = largest(shapes);
        System.out.println("Largest: " + big);
        System.out.println();

        System.out.println("===== END OF DEMO =====");
    }
}

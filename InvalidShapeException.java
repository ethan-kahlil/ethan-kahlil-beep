/**
 * Custom unchecked exception thrown when a shape is given invalid dimensions.
 *
 * This is UNCHECKED (extends RuntimeException) because invalid shape dimensions
 * represent a programming error (bad input) rather than a recoverable condition.
 * Callers are not forced to handle it at compile time, which keeps the API clean.
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class InvalidShapeException extends RuntimeException {

    /**
     * Creates the exception with a descriptive message.
     *
     * @param message explanation of what was invalid
     */
    public InvalidShapeException(String message) {
        super(message);
    }
}

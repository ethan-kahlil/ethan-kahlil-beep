/**
 * Represents a book in the community library system.
 * Encapsulates ISBN, title, author, and availability status.
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class Book {

    private String isbn;
    private String title;
    private String author;
    private boolean available;

    /**
     * Constructor 1: Creates a Book with ISBN and title only.
     * Author defaults to "Unknown". Book is available by default.
     *
     * @param isbn  the ISBN of the book
     * @param title the title of the book
     */
    public Book(String isbn, String title) {
        this.isbn      = isbn;
        this.title     = title;
        this.author    = "Unknown";
        this.available = true;
    }

    /**
     * Constructor 2 (overloaded): Creates a Book with ISBN, title, and author.
     * Book is available by default.
     *
     * @param isbn   the ISBN of the book
     * @param title  the title of the book
     * @param author the author of the book
     */
    public Book(String isbn, String title, String author) {
        this.isbn      = isbn;
        this.title     = title;
        this.author    = author;
        this.available = true;
    }

    // ---- Getters ----

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // ---- Setters ----

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns a readable string representation of the book.
     */
    @Override
    public String toString() {
        return "Book[ISBN=" + isbn
                + ", Title=\"" + title + "\""
                + ", Author=" + author
                + ", Available=" + (available ? "Yes" : "On Loan")
                + "]";
    }
}

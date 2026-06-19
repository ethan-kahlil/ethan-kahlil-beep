/**
 * Represents a loan that connects exactly one Member to one Book.
 * Records the borrow date and due date (as simple strings for console demo).
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class Loan {

    private Member member;
    private Book   book;
    private String borrowDate;
    private String dueDate;

    /**
     * Creates a Loan linking a member to a book with borrow and due dates.
     *
     * @param member     the member borrowing the book
     * @param book       the book being borrowed
     * @param borrowDate the date the book was borrowed (e.g. "2025-06-01")
     * @param dueDate    the date the book is due back  (e.g. "2025-06-15")
     */
    public Loan(Member member, Book book, String borrowDate, String dueDate) {
        this.member     = member;
        this.book       = book;
        this.borrowDate = borrowDate;
        this.dueDate    = dueDate;
    }

    // ---- Getters ----

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    // ---- Setters ----

    public void setMember(Member member) {
        this.member = member;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Returns a readable string of the loan details.
     */
    @Override
    public String toString() {
        return "Loan[Member=" + member.getName()
                + ", Book=\"" + book.getTitle() + "\""
                + ", Borrowed=" + borrowDate
                + ", Due=" + dueDate
                + "]";
    }
}

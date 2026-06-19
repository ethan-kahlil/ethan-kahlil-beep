import java.util.ArrayList;
import java.util.List;

/**
 * Holds the full collection of books and members.
 * Provides operations: add book, register member, lend book, return book, search.
 *
 * Relationship notes:
 *   Library COMPOSITION Book   - Books have no meaningful existence outside the Library.
 *   Library COMPOSITION Member - Members are managed and owned by the Library.
 *   Library uses Loan objects to track active borrows (association).
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class Library {

    private List<Book>   books;    // composition: Library owns its books
    private List<Member> members;  // composition: Library owns its members

    /**
     * Creates an empty Library.
     */
    public Library() {
        this.books   = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // ---- Getters ----

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    // ---- Operations ----

    /**
     * Adds a book to the library collection.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.getTitle());
    }

    /**
     * Registers a new member with the library.
     *
     * @param member the member to register
     */
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Registered member: " + member.getName());
    }

    /**
     * Lends a book to a member.
     * Enforces the business rule: at most one active loan per book.
     *
     * @param memberId   ID of the member borrowing the book
     * @param isbn       ISBN of the book to lend
     * @param borrowDate the borrow date string
     * @param dueDate    the due date string
     */
    public void lendBook(String memberId, String isbn, String borrowDate, String dueDate) {
        // Find the member
        Member member = findMember(memberId);
        if (member == null) {
            System.out.println("ERROR: Member with ID '" + memberId + "' not found.");
            return;
        }

        // Find the book
        Book book = findBook(isbn);
        if (book == null) {
            System.out.println("ERROR: Book with ISBN '" + isbn + "' not found.");
            return;
        }

        // Enforce business rule: book must be available
        if (!book.isAvailable()) {
            System.out.println("REJECTED: \"" + book.getTitle()
                    + "\" is already on loan and cannot be lent again.");
            return;
        }

        // Create the loan and link everything together
        Loan loan = new Loan(member, book, borrowDate, dueDate);
        book.setAvailable(false);
        member.addLoan(loan);

        System.out.println("SUCCESS: \"" + book.getTitle()
                + "\" lent to " + member.getName()
                + " (due: " + dueDate + ")");
    }

    /**
     * Returns a book from a member back to the library.
     *
     * @param memberId ID of the member returning the book
     * @param isbn     ISBN of the book being returned
     */
    public void returnBook(String memberId, String isbn) {
        Member member = findMember(memberId);
        if (member == null) {
            System.out.println("ERROR: Member with ID '" + memberId + "' not found.");
            return;
        }

        // Find the loan for this book in the member's list
        Loan targetLoan = null;
        for (Loan loan : member.getLoans()) {
            if (loan.getBook().getIsbn().equals(isbn)) {
                targetLoan = loan;
                break;
            }
        }

        if (targetLoan == null) {
            System.out.println("ERROR: No active loan found for ISBN '" + isbn
                    + "' under member " + member.getName());
            return;
        }

        // Complete the return
        targetLoan.getBook().setAvailable(true);
        member.removeLoan(targetLoan);

        System.out.println("RETURNED: \"" + targetLoan.getBook().getTitle()
                + "\" returned by " + member.getName());
    }

    /**
     * Searches for books whose title contains the given keyword (case-insensitive).
     *
     * @param keyword the title keyword to search for
     * @return list of matching books
     */
    public List<Book> searchByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    /**
     * Prints the current state of the library (all books and members).
     */
    public void printState() {
        System.out.println("\n======= LIBRARY STATE =======");
        System.out.println("--- Books ---");
        for (Book b : books) {
            System.out.println("  " + b);
        }
        System.out.println("--- Members ---");
        for (Member m : members) {
            System.out.println("  " + m);
            for (Loan l : m.getLoans()) {
                System.out.println("      " + l);
            }
        }
        System.out.println("=============================\n");
    }

    // ---- Private Helpers ----

    private Member findMember(String memberId) {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) return m;
        }
        return null;
    }

    private Book findBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    /**
     * Returns a string summary of the library.
     */
    @Override
    public String toString() {
        return "Library[Books=" + books.size() + ", Members=" + members.size() + "]";
    }
}

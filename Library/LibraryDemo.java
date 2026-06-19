import java.util.List;

/**
 * Driver class to demonstrate the Library Management System.
 * Creates members and books, performs lend/return operations,
 * including one correctly rejected attempt.
 *
 * @author Prince (Student)
 * @version 1.0
 */
public class LibraryDemo {

    public static void main(String[] args) {

        System.out.println("===== COMMUNITY LIBRARY SYSTEM =====\n");

        // Create the library
        Library library = new Library();

        // Register members
        System.out.println("-- Registering Members --");
        Member alice = new Member("M001", "Matoke John");
        Member bob   = new Member("M002", "Masuke John");
        library.registerMember(alice);
        library.registerMember(bob);

        // Add books (using both constructors)
        System.out.println("\n-- Adding Books --");
        Book b1 = new Book("ISBN-001", "Clean Code");                         // Constructor 1
        Book b2 = new Book("ISBN-002", "The Pragmatic Programmer", "Hunt");   // Constructor 2
        Book b3 = new Book("ISBN-003", "Java: The Complete Reference", "Schildt"); // Constructor 2
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Print state BEFORE any loans
        System.out.println("\n-- State BEFORE Loans --");
        library.printState();

        // Perform lend operations
        System.out.println("-- Lending Operations --");
        library.lendBook("M001", "ISBN-001", "2025-06-01", "2025-06-15");  // Alice borrows Clean Code
        library.lendBook("M002", "ISBN-002", "2025-06-02", "2025-06-16");  // Bob borrows Pragmatic Programmer
        library.lendBook("M001", "ISBN-003", "2025-06-03", "2025-06-17");  // Alice borrows Java Reference

        System.out.println();

        // REJECTED attempt: try to lend Clean Code again (already on loan)
        System.out.println("-- Attempting to lend already-borrowed book --");
        library.lendBook("M002", "ISBN-001", "2025-06-04", "2025-06-18");  // Should be REJECTED

        System.out.println();

        // Print state AFTER lending
        System.out.println("-- State AFTER Lending --");
        library.printState();

        // Return a book
        System.out.println("-- Return Operation --");
        library.returnBook("M001", "ISBN-001");  // Alice returns Clean Code

        System.out.println();

        // Print state AFTER return
        System.out.println("-- State AFTER Return --");
        library.printState();

        // Search for a book by title
        System.out.println("-- Search by Title: 'java' --");
        List<Book> results = library.searchByTitle("java");
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book b : results) {
                System.out.println("  Found: " + b);
            }
        }

        System.out.println();
        System.out.println("===== END OF DEMO =====");
    }
}

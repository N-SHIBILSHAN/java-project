class Book {

    int bookId;
    String bookName;
    String author;
    int availableCopies;

    static int totalBooks = 0;
    static final String LIBRARY_NAME = "ABC Central Library";

    Book(int bookId, String bookName, String author, int availableCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.availableCopies = availableCopies;
        totalBooks++;
    }

    void issueBook() {
        try {
            if (availableCopies > 0) {
                availableCopies--;
                System.out.println(bookName + " issued successfully.");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Book is not available.");
        }
    }

    void returnBook() {
        availableCopies++;
        System.out.println(bookName + " returned successfully.");
    }

    void displayBook() {
        System.out.println("Library Name     : " + LIBRARY_NAME);
        System.out.println("Book ID          : " + bookId);
        System.out.println("Book Name        : " + bookName);
        System.out.println("Author           : " + author);
        System.out.println("Available Copies : " + availableCopies);
        System.out.println();
    }

    static void displayTotalBooks() {
        System.out.println("Total Books Added : " + totalBooks);
    }
}

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book(101, "Java Programming", "James Gosling", 2);
        Book b2 = new Book(102, "Python Basics", "Guido van Rossum", 0);
        Book b3 = new Book(103, "Data Structures", "Mark Allen", 5);

        System.out.println("BOOK DETAILS \n");

        b1.displayBook();
        b2.displayBook();
        b3.displayBook();

        System.out.println("ISSUE BOOK \n");

        b1.issueBook();
        b2.issueBook();

        System.out.println("\nRETURN BOOK \n");

        b1.returnBook();

        System.out.println("\nUPDATED BOOK DETAILS n");

        b1.displayBook();

        System.out.println("SUMMARY n");

        Book.displayTotalBooks();
    }
}
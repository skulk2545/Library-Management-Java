import java.util.*;
import java.io.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    private static final String BOOKS_FILE = "data/books.txt";
    private static final String MEMBERS_FILE = "data/members.txt";

    public Library() {
        loadBooks();
        loadMembers();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void addMember(Member member) {
        members.add(member);
        saveMembers();
    }

    public void borrowBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.isAvailable()) {
                book.borrow();
                saveBooks();
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId) && !book.isAvailable()) {
                book.returnBook();
                saveBooks();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showBooks() {
        for (Book book : books) System.out.println(book);
    }

    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null)
                books.add(Book.fromString(line));
        } catch (IOException e) { System.out.println("Books file not found."); }
    }

    private void saveBooks() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) pw.println(book.toString());
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void loadMembers() {
        try (BufferedReader br = new BufferedReader(new FileReader(MEMBERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null)
                members.add(Member.fromString(line));
        } catch (IOException e) { System.out.println("Members file not found."); }
    }

    private void saveMembers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(MEMBERS_FILE))) {
            for (Member m : members) pw.println(m.toString());
        } catch (IOException e) { e.printStackTrace(); }
    }
}

import java.util.*;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Books");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    String mId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    library.addMember(new Member(mId, name));
                    break;
                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    library.borrowBook(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextLine());
                    break;
                case 5:
                    library.showBooks();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}

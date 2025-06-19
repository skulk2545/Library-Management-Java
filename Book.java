public class Book {
    private String id, title, author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void borrow() { isAvailable = false; }
    public void returnBook() { isAvailable = true; }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + isAvailable;
    }

    public static Book fromString(String data) {
        String[] parts = data.split(",");
        Book book = new Book(parts[0], parts[1], parts[2]);
        if (!Boolean.parseBoolean(parts[3])) book.borrow();
        return book;
    }
}

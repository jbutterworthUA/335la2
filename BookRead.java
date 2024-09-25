public class BookRead {
    private Book book;
    private boolean isRead = false;

    public BookRead(Book myBook) {
        this.book = myBook;
    }

    public void setRead() {
        this.isRead = true;
    }

    public Book getBook() {
        return this.book;
    }
}
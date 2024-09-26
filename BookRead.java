public class BookRead {
    private Book book;
    private boolean isRead;

    /**
    * Contructor for the BookRead class. Bundles previous Book class
    * with a new attribute to mark its read status.
    * @param Book. The Book object we will be initializing our instance variable with.
    */
    public BookRead(Book myBook) {
        this.book = myBook;
        isRead = false;
    }

    /**
    * Setter method which will be used to update a BookRead object's read status.
    * Read status will only be changed to true, as it is initialized to false in constructor.
    */
    public void setRead() {
        this.isRead = true;
    }

    /**
    * Getter method which will be used to access the instance variable of our Book object.
    * Object will not act as escaping reference, as Book class is final and immutable.
    */
    public Book getBook() {
        return this.book;
    }
}

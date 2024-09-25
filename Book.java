final class Book {
    private String title;
    private String author;

    public Book(String title, String Author) {
        if (title == null || author == null) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.author = author;
    }

    /*
     * Helper method to get title of the book.
     * Since book is final and title is provided, prevents escaping reference.
     */
    public String getTitle() {
        return this.title;
    }

    /*
     * Helper method to get author of the book.
     * Since book is final and author is provided, prevents escaping reference.
     */
    public String getAuthor() {
        return this.author;
    }
}
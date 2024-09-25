import java.util.ArrayList;

public class RatedBookList {
    private ArrayList<BookReview> allRatedBooks;
    
    public RatedBookList() {
        allRatedBooks = new ArrayList<BookReview>();
    }

    public void addReviewBook(BookReview myBookReview) {
        allRatedBooks.add(myBookReview);
    }
}

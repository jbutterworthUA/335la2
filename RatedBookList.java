import java.util.ArrayList;
/**
* Class Purpose: Create a list of all existing books which have been
* given a rating by the user.
*/

public class RatedBookList {
    private ArrayList<BookReview> allRatedBooks;

    /**
    * Constructor for RatedBookList class. Will initialize instance variable as a new
    * ArrayList to later be filled with BookReview objects.
    */
    public RatedBookList() {
        allRatedBooks = new ArrayList<BookReview>();
    }

    /**
    * Method to add a book which has now been given a user rating.
    * @param BookReview. The BookReview object being added to our reviewed books list.
    */
    public void addReviewBook(BookReview myBookReview) {
        allRatedBooks.add(myBookReview);
    }
}

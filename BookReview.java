public class BookReview {
    private BookRead bookRead;
    private int rate;

    /**
    * Contructor for the BookReview class. Bundles previous BookRead class
    * with a new attribute to mark its user rating.
    * @param BookRead. The BookRead object we will be initializing our instance variable with.
    * @param int. The rating we will be initializing our instance variable with. Determined by user.
    */
    public BookReview(BookRead myBookRead, int myRate) {
        this.bookRead = myBookRead;
        this.rate = myRate;
    }

    /**
    *  --DISCUSS WHETHER WE SHOULD KEEP AS SETTER OR STICK WITH SECOND PARAM FOR CONSSTRUCTOR.--
    * 
    */
    private void setRate(int myRate) {
        this.rate = myRate;
    }
}

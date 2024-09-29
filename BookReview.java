public class BookReview {
    private BookRead bookRead;
    private int rate;

    /*
	 * Constructor for the BookReview class. Bundles previous BookRead class with a
	 * new attribute to mark its user rating.
	 * 
	 * @param BookRead. The BookRead object we will be initializing our instance
	 *                  variable with.
	 * @param int.      The rating we will be initializing our instance variable
	 *                  with. Determined by user.
	 */
    public BookReview(BookRead myBookRead, int myRate) {
        this.bookRead = myBookRead;
        this.rate = myRate;
    }

    /*
    *  --DISCUSS WHETHER WE SHOULD KEEP AS SETTER OR STICK WITH SECOND PARAM FOR CONSSTRUCTOR.--
    * @pre myRate should be an int from 1-5
    */
    public void setRate(int myRate) {
        this.rate = myRate;
    }
    
    public BookRead getBook() {
    	return bookRead;
    }
}

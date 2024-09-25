public class BookReview {
    private BookRead bookRead;
    private int rate;

    public BookReview(BookRead myBookRead, int myRate) {
        this.bookRead = myBookRead;
        this.rate = myRate;
    }

    private void setRate(int myRate) {
        this.rate = myRate;
    }
}

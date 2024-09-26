import java.util.ArrayList;
import java.util.Scanner;

/**
* Class Purpose: Serve as the intermediary between the client-side MyLibary UI class and those which 
* control the overall management of each object.
* Will handle the actual tasks of user requests by routing to appropriate class.
*/

public class LibrarySetup {
    private MasterList masterList;
    private RatedBookList ratedList;

    public LibrarySetup() {
        masterList = new MasterList();
        ratedList = new RatedBookList();
    }

    public void addBooks() {
        masterList.addBooks();
    }

    public void addBook() {
        masterList.addBook();
    }

    public void getBooks() {

    }

    /*
     * 
     */
    public void suggest() {

    }

    /*
     * Helper method to retrieve all books which have not been read.
     */
    private ArrayList<BookRead> getUnreadBooks() {
        return null;
    }

    public void search() {
        // Ask user how they want to search for the book.
        // Once we have search method, get the info. (title, author).
        // If looking for title/author, search master list.
        // If looking for rate, search ratedList.

    }

    public void rate() {
        // First, check if book is in ratedList to update the rate.
        // If not, find book in masterList and create a new object in ratedlist with its info.
        // Then add rate.
    }

    public void setToRead() {
        Scanner keyboard = new Scanner(System.in);
        // Ask the user which book they want to mark as read.
        System.out.println("Enter the title of the book you want to mark as read: ");
        String readTitle = keyboard.nextLine();

        System.out.println("Enter the author of the book you want to mark as read: ");
        String authorTitle = keyboard.nextLine();

        // Find the correct book in our masterList and update its read status.
        for (int i = 0; i < masterList.size(); i++) {
            String currentTitle = masterList.get(i).getBook().getTitle();
            String currentAuthor = masterList.get(i).getBook().getAuthor();

            // If title and author match, set the book's status to read.
            if (currentTitle.equals(readTitle) && currentAuthor.equals(authorTitle)) {
                masterList.get(i).setRead();
            }
        }

    }
}

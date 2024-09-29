import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/*
 * Class Purpose: Serve as the intermediary between the client-side MyLibary UI
 * class and those which control the overall management of each object. Will
 * handle the actual tasks of user requests by routing to appropriate class.
 */

public class LibrarySetup {
	private MasterList masterList;
	private RatedBookList ratedList;

	public LibrarySetup() {
		masterList = new MasterList();
		ratedList = new RatedBookList();
	}

	public void addBooks() {
		// Prompt user for name of text file.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the text file: ");
		String fileName = keyboard.nextLine();
		Scanner inFile = null;
		try {
			// Create file if possible.
			inFile = new Scanner(new File(fileName));
		} catch (Exception e) {
			// Otherwise, alert user that file was not found.
			System.out.println(fileName + " not found.");
			System.exit(1);
		}

		// Skip the first line of the file.
		inFile.nextLine();
		// Split the file and create BookRead object for each available line.
		while (inFile.hasNextLine()) {
			String currentLine = inFile.nextLine();
			String[] lineArray = currentLine.split(";");
			String title = lineArray[0];
			String author = lineArray[1];
			masterList.addBook(title, author);
		}
	}

	public void addBook() {
		// Ask user for appropriate info needed for book.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the title of the book to be added: ");
		String title = keyboard.nextLine();
		System.out.println("Enter the author of the book to be added: ");
		String author = keyboard.nextLine();
		masterList.addBook(title, author);
	}

    /**
     * Retrieve all books in the user's library, organized by user-determined method.
     * (Title/Author/Read Status)
     */
	public void getBooks() {
<<<<<<< HEAD
        Scanner keyboard = new Scanner(System.in);
        // Ask user how they would like their books sorted.
        System.out.println("How would you like your books sorted?\n(title, author, read, unread)?:");
        String input = keyboard.next();
        String sortMethod = input.toLowerCase();
        ArrayList<String> validSortMethods = new ArrayList<>();
        validSortMethods.add("title");
        validSortMethods.add("author");
        validSortMethods.add("read");
        validSortMethods.add("unread");
        while (!validSortMethods.contains(sortMethod)) {
            System.out.println("Please enter a valid sorting method (title, author, read, unread): ");
            input = keyboard.next();
            sortMethod = input.toLowerCase();
        } 
        // Get all books sorted by title.
        if (sortMethod.equals("title")) {
            ArrayList<BookRead> sortedBooks = sortByTitle();
            // Display each book to the user.
            System.out.println("Here are your library books sorted by title: ");
            for (int i = 0; i < sortedBooks.size(); i++) {
                String currentTitle = sortedBooks.get(i).getBook().getTitle();
                String currentAuthor = sortedBooks.get(i).getBook().getAuthor();
                System.out.println(currentTitle + ", by " + currentAuthor);
            }
        }

        // Get all books sorted by author.
        if (sortMethod.equals("author")) {
            ArrayList<BookRead> sortedBooks = sortByAuthor();
            // Display each book to the user.
            System.out.println("Here are your library books sorted by author: ");
            for (int i = 0; i < sortedBooks.size(); i++) {
                String currentTitle = sortedBooks.get(i).getBook().getTitle();
                String currentAuthor = sortedBooks.get(i).getBook().getAuthor();
                System.out.println(currentTitle + ", by " + currentAuthor);
            }
        }

        // Get all books that have been read. (Sorted by title.)
        if (sortMethod.equals("title")) {
            ArrayList<BookRead> sortedBooks = sortByTitle();
            // Display each book to the user.
            System.out.println("Here are your read library books sorted by title: ");
            for (int i = 0; i < sortedBooks.size(); i++) {
                if (sortedBooks.get(i).isRead()) {
                    String currentTitle = sortedBooks.get(i).getBook().getTitle();
                    String currentAuthor = sortedBooks.get(i).getBook().getAuthor();
                    System.out.println(currentTitle + ", by " + currentAuthor);
                } 
            }
        }

        // Get all books that have not been read (Sorted by title.)
        if (sortMethod.equals("title")) {
            ArrayList<BookRead> sortedBooks = sortByTitle();
            // Display each book to the user.
            System.out.println("Here are your unread library books sorted by title: ");
            for (int i = 0; i < sortedBooks.size(); i++) {
                if (!sortedBooks.get(i).isRead()) {
                    String currentTitle = sortedBooks.get(i).getBook().getTitle();
                    String currentAuthor = sortedBooks.get(i).getBook().getAuthor();
                    System.out.println(currentTitle + ", by " + currentAuthor);
                } 
            }
        }




=======
>>>>>>> 60f4028322d59b8a7b60ca597769abddd257a2d6
	}

    /**
     * Helper method to retrieve list of all books in masterList, sorted by title.
     * @return ArrayList of BookRead objects, sorted alphabetically by title.
     */
    private ArrayList<BookRead> sortByTitle() {

    }

    /**
     * Helper method to retrieve list of all books in masterList, sorted by author.
     * @return ArrayList of BookRead objects, sorted alphabetically by author.
     */
    private ArrayList<BookRead> sortByAuthor() {

    }

	/*
	 * Suggest a random unread book from the user's library for them to read.
	 */
	public void suggestRead() {
		// Retrieve all possible unread books using our helper method.
		ArrayList<BookRead> unreadBooks = getUnreadBooks();
		// Shuffle the list of unread books and retrieve Book object at index 0.
		Collections.shuffle(unreadBooks);
		Book suggestion = unreadBooks.get(0).getBook();

		String title = suggestion.getTitle();
		String author = suggestion.getAuthor();

		// Display the suggestion message for the user.
		System.out.println("You should try reading " + title + ", by " + author + ".");
	}

	/*
	 * Helper method to retrieve all books which have not been read.
	 * 
	 * @return ArrayList<BookRead>. Collection of all books with an unread status.
	 */
	private ArrayList<BookRead> getUnreadBooks() {
		ArrayList<BookRead> unreadBooks = new ArrayList<>();
		// Iterate through every book in our masterList and check its status.
		for (int i = 0; i < masterList.size(); i++) {
			// If the current book has not been read, add to unread list.
			if (!masterList.get(i).isRead()) {
				unreadBooks.add(masterList.get(i));
			}
		}
		return unreadBooks;
	}

	public void search() {
		// Once we have search method, get the info. (title, author).
		// If looking for title/author, search master list.
		// If looking for rate, search ratedList.


		// Ask user how they want to search for the book.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How would you like to search for the book?");
		System.out.println("Please input title, author, or rate: ");
		String answer = keyboard.nextLine();
		String searchMethod = answer.toLowerCase();

		// If user did not enter a valid search method, continue prompting until they do
		// so.
		while (!isValid(searchMethod)) {
			System.out.println("Please input a valid search method (title, author, rate): ");
			answer = keyboard.nextLine();
			searchMethod = answer.toLowerCase();
		}

		// If we are searching by title, call searchByTitle helper method.
		if (searchMethod.equals("title")) {

			// First, ask for the title of the book to search for.
			System.out.println("Type the title of the book you are searching for: ");
			String searchTitle = keyboard.nextLine();

            // Retrieve all possible books.
            ArrayList<BookRead> possibleBooks = searchByTitle(searchTitle);

            // Display books for the user.
            displayBooks(possibleBooks);
		}

		// If we are searching by author, we will iterate through masterList.
		if (searchMethod.equals("author")) {
			// First, ask for the title of the book to search for.
			System.out.println("Type the author of the book you are searching for: ");
			String searchAuthor = keyboard.nextLine();

            // Retrieve all possible books.
            ArrayList<BookRead> possibleBooks = searchByAuthor(searchAuthor);

            // Display books for the user.
            displayBooks(possibleBooks);
		}

        if (searchMethod.equals("rate")) {
            System.out.println("Type the rate of the book you are searching for: ");
			int searchRate = keyboard.nextInt();

            // Retrieve all possible books.
            ArrayList<BookReview> possibleBooks = searchByRate(searchRate);

            // Display books for the user.
            displayBooksByRate(possibleBooks);
        }
	}

    private void displayBooks(ArrayList<BookRead> possibleBooks) {
        // Display all books which the user may have been searching for.
		// If there are no possible books, display alternate message.
		if (possibleBooks.size() == 0) {
			System.out.println("No books matching your search");
		} else {
			System.out.println("List of books matching your search: ");
			for (int i = 0; i < possibleBooks.size(); i++) {
				String title = possibleBooks.get(i).getBook().getTitle();
				String author = possibleBooks.get(i).getBook().getAuthor();

				System.out.println(title + ", by " + author + ".");
			}
		}
    }
    
    private void displayBooksByRate(ArrayList<BookReview> possibleBooks) {
        // Display all books which the user may have been searching for.
		// If there are no possible books, display alternate message.
		if (possibleBooks.size() == 0) {
			System.out.println("No books matching your search");
		} else {
			System.out.println("List of books matching your search: ");
			for (int i = 0; i < possibleBooks.size(); i++) {
				String title = possibleBooks.get(i).getBook().getBook().getTitle();
				String author = possibleBooks.get(i).getBook().getBook().getAuthor();

				System.out.println(title + ", by " + author + ".");
			}
		}
    }

    /**
     * Helper method to retrieve all books which have the same title the user has inputted.
     * @param searchTitle
     * @return ArrayList of all possible books the user could be searching for.
     */
    private ArrayList<BookRead> searchByTitle(String searchTitle) {
        // Create list to store all possible books.
        ArrayList<BookRead> possibleBooks = new ArrayList<>();

        // Search every book in masterList, checking if the title matches our searchTitle.
        for (int i = 0; i < masterList.size(); i++) {
            String currentTitle = masterList.get(i).getBook().getTitle();
            // If the title of the current book matches, add it to possible books.
            if (currentTitle.equals(searchTitle)) {
                possibleBooks.add(masterList.get(i));
            }
        }
        return possibleBooks;
    }

    /**
     * Helper method to retrieve all books which have the same author the user has inputted.
     * @param searchAuthor
     * @return ArrayList of all possible books the user could be searching for.
     */
    private ArrayList<BookRead> searchByAuthor(String searchAuthor) {
        // Create list to store all possible books.
        ArrayList<BookRead> possibleBooks = new ArrayList<>();

        // Search every book in masterList, checking if the title matches our searchTitle.
        for (int i = 0; i < masterList.size(); i++) {
            String currentAuthor = masterList.get(i).getBook().getAuthor();
            // If the title of the current book matches, add it to possible books.
            if (currentAuthor.equals(searchAuthor)) {
                possibleBooks.add(masterList.get(i));
            }
        }
        return possibleBooks;
    }

    /**
     * Helper method to retrieve all books which have the same rate the user has inputted.
     * @param searchRate
     * @return ArrayList of all possible books the user could be searching for.
     */
    private ArrayList<BookReview> searchByRate(int searchRate) {
        // Create list to store all possible books.
        ArrayList<BookReview> possibleBooks = new ArrayList<>();

        // Search every book in masterList, checking if the title matches our searchTitle.
        for (int i = 0; i < ratedList.size(); i++) {
            int currentRate = ratedList.get(i).getRate();
            // If the title of the current book matches, add it to possible books.
            if (currentRate == searchRate) {
                possibleBooks.add(ratedList.get(i));
            }
        }
        return possibleBooks;
    }

	/*
	 * Helper method to determine if a user has given a valid method to search for a
	 * book.
	 * 
	 * @param input. The String containing a user's input method. @return. True if
	 * user input a valid way to search, false if not.
	 */
	private boolean isValid(String input) {
		// Create place to store valid inputs from user.
		ArrayList<String> validMethods = new ArrayList<String>(3);
		validMethods.add("title");
		validMethods.add("author");
		validMethods.add("rate");

		if (validMethods.contains(input)) {
			return true;
		}

		return false;
	}

    /**
     * Ask the user for the book they would like to rate, then update or create new rating accordingly.
     */
	public void rate() {
		// Ask user which book they would like to rate.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the title of the book you would like to rate: ");
        String searchTitle = keyboard.nextLine();
        System.out.println("Type the author of the book you would like to rate: ");
        String searchAuthor = keyboard.nextLine();

        // Integer to keep track of if we have completed the rating process.
        int found = 0;

        // Check if the book we are searching for is already in ratedList for us to update.
        for (int i = 0; i < ratedList.size(); i++) {
            String currentTitle = ratedList.get(i).getBook().getBook().getTitle();
            String currentAuthor = ratedList.get(i).getBook().getBook().getAuthor();
            // If the book is already in ratedList, get the new rating and update it.
            if (currentTitle.equals(searchTitle) && currentAuthor.equals(searchAuthor)) {
                // Mark that we have found the book.
                found = 1;
                int newRate = getNewRate();
                ratedList.get(i).setRate(newRate);
                System.out.println("Rate has been updated.");
                return;
            }
        }

        // If we did not find the book in ratedList, we will search masterList and add it to ratedList.
        if (found == 0) {
            for (int i = 0; i < masterList.size(); i++) {
                BookRead currentBookRead = masterList.get(i);
                String currentTitle = masterList.get(i).getBook().getTitle();
                String currentAuthor = masterList.get(i).getBook().getAuthor();

                // When we find the book in masterList, we will need to create BookReview object and add to ratedList.
                if (currentTitle.equals(searchTitle) && currentAuthor.equals(searchAuthor)) {
                    // Mark that we have found the book.
                    found = 1;
                    int newRate = getNewRate();
                    BookReview newReview = new BookReview(currentBookRead, newRate);
                    ratedList.addReviewBook(newReview);
                    System.out.println("Rate has been updated.");
                    return;
                }
            }
        }

        // If we reach this point, user did not enter a valid book in the library.
        System.out.println("The book you wish to update was not located in your library.");
	}

    /**
     * Helper method to prompt and retrieve an updated book ranking from the user.
     * @return the new rate of the user's book.
     */
    private int getNewRate() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like the rating of the book to be? (1 - 5): ");
        int newRate = keyboard.nextInt();
        while (newRate < 1 || newRate > 5) {
            System.out.println("Please enter a valid book rating (1 - 5): ");
            newRate = keyboard.nextInt();
        }
        return newRate;

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

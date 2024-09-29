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

	public void getBooks() {

	}

	/*
	 * Suggest a random unread book from the user's library for them to read.
	 */
	public void suggest() {
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

			// *** INCOMPLETE CODE BELOW (ISREAD METHOD DNE YET): DO WE WANT ANOTHER GETTER
			// FOR BOOKREAD READ STATUS? APPEARS TO BE ANTI-PATTERN. ***
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

		// List of potential books the user is looking for.
		ArrayList<Book> possibleBooks = new ArrayList<>();

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

		// If we are searching by title, we will iterate through masterList.
		if (searchMethod.equals("title")) {
			// First, ask for the title of the book to search for.
			System.out.println("Type the title of the book you are searching for: ");
			String searchTitle = keyboard.nextLine();

			for (int i = 0; i < masterList.size(); i++) {
				Book currentBook = masterList.get(i).getBook();

				// If the titles match, add it to the list of possible books.
				if (currentBook.getTitle().equals(searchTitle)) {
					possibleBooks.add(currentBook);
				}
			}
		}

		// If we are searching by author, we will iterate through masterList.
		if (searchMethod.equals("author")) {
			// First, ask for the title of the book to search for.
			System.out.println("Type the author of the book you are searching for: ");
			String searchAuthor = keyboard.nextLine();

			for (int i = 0; i < masterList.size(); i++) {
				Book currentBook = masterList.get(i).getBook();

				// If the titles match, add it to the list of possible books.
				if (currentBook.getAuthor().equals(searchAuthor)) {
					possibleBooks.add(currentBook);
				}
			}
		}

		// ***START OF INCOMPLETE CODE*** //
		// If we are searching by rate, we will iterate through ratedList.
		if (searchMethod.equals("title")) {
			// First, ask for the rate of the book to search for.
			System.out.println("Type the rate (1 - 5) of the book you are searching for: ");
			int searchRate = keyboard.nextInt();

			// *** NEED TO FIGURE OUT HOW WE ARE ACCESSING RATEDLIST'S TITLES/AUTHORS. ***
			// //
			for (int i = 0; i < ratedList.size(); i++) {
				Book currentBook = ratedList.get(i).getBook().getBook();

				// If the titles match, add it to the list of possible books.
				if (currentBook.getTitle().equals(searchTitle)) {
					possibleBooks.add(currentBook);
				}
			}
		}
		// ***END OF INCOMPLETE CODE*** //

		// Display all books which the user may have been searching for.
		// If there are no possible books, display alternate message.
		if (possibleBooks.size() == 0) {
			System.out.println("No books matching your search");
		} else {
			System.out.println("List of books matching your search: ");
			for (int i = 0; i < possibleBooks.size(); i++) {
				String title = possibleBooks.get(i).getTitle();
				String author = possibleBooks.get(i).getAuthor();

				System.out.println(title + ", by " + author + ".");
			}
		}
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

	public void rate() {
		// First, check if book is in ratedList to update the rate.
		// If not, find book in masterList and create a new object in ratedList with its
		// info.
		// Then add rate.

		// Ask user which book they would like to rate.
		// Could potentially use a searchByTitle() method here, meaning in search() we
		// could just call
		// helpers searchByTitle() searchByAuthor() searchByRate()?
		// Could help make code look more organized.
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

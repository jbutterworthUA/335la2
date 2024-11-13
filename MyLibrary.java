/*
 * Authors: Jason Butterworth (jbutterworth) and Dylan Carothers II (dylanacarothers).
 * Class Purpose: Running a text-based UI allowing user to get or add information
 * to a personal virtual library.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MyLibrary {

	private static LibrarySetup mainLibrary = new LibrarySetup();

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		boolean continueLoop = true;

		ArrayList<String> validSortMethods = new ArrayList<>();
        validSortMethods.add("title");
        validSortMethods.add("author");
        validSortMethods.add("read");
        validSortMethods.add("unread");

		System.out.println("Welcome to your library!");
		System.out.println("Enter a command or type 'showCommands' to print a list of possible commands.");
		System.out.println("Commands ARE case sensitive!");

		while (continueLoop) {
			String input = keyboard.next();

			if (input.equals("search")) {
				mainLibrary.search();
			} 

			else if (input.equals("addBook")) {
				// Ask user for appropriate info needed for book.
				System.out.println("Enter the title of the book to be added: ");
				String title = keyboard.nextLine();
				System.out.println("Enter the author of the book to be added: ");
				String author = keyboard.nextLine();
				mainLibrary.addBook(title, author);
			} 

			else if (input.equals("setToRead")) {
				mainLibrary.setToRead();
			} 

			else if (input.equals("rate")) {
				mainLibrary.rate();
			} 

			else if (input.equals("getBooks")) {
				System.out.println("How would you like your books sorted?\n(title, author, read, unread)?:");
        		input = keyboard.next();
        		String sortMethod = input.toLowerCase();
        		
       			while (!validSortMethods.contains(sortMethod)) {
            		System.out.println("Please enter a valid sorting method (title, author, read, unread): ");
            		input = keyboard.next();
            		sortMethod = input.toLowerCase();
        		}
				mainLibrary.getBooks(sortMethod);
			} 

			else if (input.equals("suggestRead")) {
				Book suggestion = mainLibrary.suggestRead();
				if (suggestion == null) {
					System.out.println("No unread books in your library!");
				}
				String title = suggestion.getTitle();
				String author = suggestion.getAuthor();
				// Display the suggestion message for the user.
				System.out.println("You should try reading " + title + ", by " + author + ".");
				
			} 

			else if (input.equals("addBooks")) {
				mainLibrary.addBooks();
			} 

			else if (input.equals("exit")) {
				continueLoop = false;
				System.out.println("Goodbye!");
			} 

			else if (input.equals("showCommands")) {
				System.out.println("possible commands are:");
				System.out.println("search");
				System.out.println("addBook");
				System.out.println("setToRead");
				System.out.println("rate");
				System.out.println("getBooks");
				System.out.println("suggestRead");
				System.out.println("addBooks");
				System.out.println("showCommands");
				System.out.println("exit");
			}
			
			System.out.println("----------------------------------");
			System.out.println("Enter next command or type 'showCommands' to print a list of possible commands.");
		}
	}

}

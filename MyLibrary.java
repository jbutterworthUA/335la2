/*
 * Authors: Jason Butterworth (jbutterworth) and Dylan Carothers II (dylanacarothers).
 * Class Purpose: Running a text-based UI allowing user to get or add information
 * to a personal virtual library.
 */

import java.util.Scanner;

public class MyLibrary {

	private static LibrarySetup mainLibrary = new LibrarySetup();

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		boolean continueLoop = true;

		System.out.println("Welcome to your library!");
		System.out.println("Enter a command or type 'showCommands' to print a list of possible commands.");
		System.out.println("Commands ARE case sensitive!");

		while (continueLoop) {
			String input = keyboard.next();

			if (input.equals("search")) {
				mainLibrary.search();
			} else if (input.equals("addBook")) {
				mainLibrary.addBook();
			} else if (input.equals("setToRead")) {
				mainLibrary.setToRead();
			} else if (input.equals("rate")) {
				mainLibrary.rate();
			} else if (input.equals("getBooks")) {
				mainLibrary.getBooks();
			} else if (input.equals("suggestRead")) {
				mainLibrary.suggestRead();
			} else if (input.equals("addBooks")) {
				mainLibrary.addBooks();
			} else if (input.equals("exit")) {
				continueLoop = false;
				System.out.println("Goodbye!");
			} else if (input.equals("showCommands")) {
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
		}
	}

}

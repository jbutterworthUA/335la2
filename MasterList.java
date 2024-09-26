import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
* Class which will hold our Master List of all books in library, regardless of read status.
* --Encapsulation info to be added.--
*/
public class MasterList {
    private ArrayList<BookRead> allBooks;

    /**
    * Constructor for our MasterList class. Will initialize our allBooks instance variable
    * as a newly created ArrayList of BookRead objects. (Objects holding Book obj + read status).
    */
    public MasterList() {
        allBooks = new ArrayList<BookRead>();
    }

    /**
    * Getter method to determine the number of total books in library.
    * @return int. Size of allBooks instance variable.
    */
    public int size() {
        return allBooks.size();
    }

    /**
    * Getter method to retrieve the BookRead object at a specific index in our library.
    * Will be useful when searching for attributes of particular book during library creation.
    * @param int. The index of the BookRead object we intend to return.
    * @return BookRead. The BookRead object at the given index.
    */
    public BookRead get(int idx) {
        return allBooks.get(idx);
    }

    /*
     * Method to read in file name from the user, parse its data, and add each
     * each book to the master list as a BookRead object.
     */
    public void addBooks() {
        // Prompt user for name of text file.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of the text file: ");
        String fileName = keyboard.nextLine();
        Scanner inFile = null;
        try {
            // Create file if possible.
            inFile = new Scanner(new File(fileName));
        }
        catch (Exception e){
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

            // BookRead object will be created by creating Book object in its parameter.
            // Allows us to work backwards to smallest class component in program.
            BookRead currentBook = new BookRead(new Book(title, author));
            
            // Add book to library only if it is not currently included.
            if (!allBooks.contains(currentBook)) {
                allBooks.add(currentBook);
            }
        }
    }

    /**
    * Method which allows user to add additional books individually rather than through text file.
    * Identical logic to addBooks(), without needing to loop through a file.
    */
    public void addBook() {
        // Ask user for appropriate info needed for book.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the title of the book to be added: ");
        String title = keyboard.nextLine();
        System.out.println("Enter the author of the book to be added: ");
        String author = keyboard.nextLine();
        BookRead currentBook = new BookRead(new Book(title, author));
            if (!allBooks.contains(currentBook)) {
                allBooks.add(currentBook);
            }
            else {
                System.out.println("Book already in library.");
            }  
    }
    
}

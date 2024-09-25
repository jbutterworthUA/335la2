import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MasterList {
    private ArrayList<BookRead> allBooks;

    public MasterList() {
        allBooks = new ArrayList<BookRead>();
    }

    public int size() {
        return allBooks.size();
    }

    public BookRead get(int idx) {
        return allBooks.get(idx);
    }

    /*
     * addBooks(fileName) -- Read in a file from the user and add
     * each book to the master list.
     */
    public void addBooks() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of the text file: ");
        String fileName = keyboard.nextLine();
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File(fileName));
        }
        catch (Exception e){
            System.out.println(fileName + " not found.");
            System.exit(1);
        }

        // Skip the first line of the file.
        inFile.nextLine();
        // Split file and create Book object for each line.
        while (inFile.hasNextLine()) {
            String currentLine = inFile.nextLine();
            String[] lineArray = currentLine.split(";");
            String title = lineArray[0];
            String author = lineArray[1];
            BookRead currentBook = new BookRead(new Book(title, author));
            if (!allBooks.contains(currentBook)) {
                allBooks.add(currentBook);
            }
        }
    }

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

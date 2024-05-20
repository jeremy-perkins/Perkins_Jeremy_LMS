import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Initiating scanner to be used as menu selector
        Scanner scn = new Scanner(System.in);
        // Initializing book class which will hold the values from our text files
        class Book {
            int bookId;
            String bookTitle;
            String bookAuthor;
        }

        // Initializing array to hold our book objects.
        Book[] library = new Book[50];

        // Pre populating our array
        for (int j = 0; j < library.length; j++) {
                    library[j] = new Book();
                }
        // Setting menu selector value
        int userIn = 0;

        // Printing menu for display
        System.out.println("-------------------Welcome to the Library Management System--------------------");
        System.out.println("Please use the data.txt file located in this folder to add books to the system.");
        System.out.println("Press the corresponding inputs to navigate the system.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Press 1 to view all books within the system.");
        System.out.println("Press 2 to to add books to the system.");
        System.out.println("Press 3 to remove a book from the system.");
        System.out.println("Press 4 to exit the program.");
        System.out.println("-------------------------------------------------------");

        // Menu operation logic
        while (userIn != 4) {
            userIn = scn.nextInt();
            int i;
            i=0;
            switch (userIn) {
                case 1:
                    int n = 0;
                    // Printing non-null book objects within the array
                    while (n<library.length) {
                    if (library[n].bookTitle != null) {
                        System.out.println("ID: " + library[n].bookId + " Title: " + library[n].bookTitle + " Author: " + library[n].bookAuthor);
                    }
                    n++;
                    }

                    // Resetting selector value
                    userIn = 0;
                    break;

                case 2:
                    // Initializing scanner to pull attributes from file
                    Scanner scnr = new Scanner(new File("data.txt"));
                    // Separating lines into usable attributes
                    scnr.useDelimiter(",|\\n");
                    // Overwriting book objects within array with new titles
                    while (scnr.hasNext()) {
                        library[i].bookId = scnr.nextInt();
                        library[i].bookTitle = scnr.next();
                        library[i].bookAuthor = scnr.next();

                        System.out.println("Added ID: " + library[i].bookId + " Title: " + library[i].bookTitle + " Author: " + library[i].bookAuthor);
                        i++;
                    }
                    scnr.close();
                    // Resetting selector value
                    userIn = 0;
                    break;

                case 3:
                    Scanner sr = new Scanner(System.in);
                    System.out.println("Please select a Book ID to remove from the system.");
                    // Selecting book object based on user input
                    int remove = sr.nextInt() - 1;
                    System.out.println("Removed ID: " + library[remove].bookId + " Title: " + library[remove].bookTitle + " Author: " + library[remove].bookAuthor);
                    // Removing values from selected book object
                    library[remove].bookId = 0;
                    library[remove].bookTitle = null;
                    library[remove].bookAuthor = null;
                    // Resetting selector value
                    userIn = 0;
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;
            }
        }
    }
}
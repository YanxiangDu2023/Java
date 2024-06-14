This is a simple console application that simulates a bookstore management system. It allows users to display books, add new books, remove books, and exit the application. Below is a detailed explanation of its functionality:

### Data Structures

An `ArrayList` is used to store book information. Each book's details are represented by an instance of the `Book` class.

#### `Book` Class
```java
package test13;

public class Book {
    private int bNo;      // Book number
    private String bName; // Book name
    private String bAuthor; // Author

    // Constructor
    public Book(int bNo, String bName, String bAuthor) {
        this.bNo = bNo;
        this.bName = bName;
        this.bAuthor = bAuthor;
    }

    // Getters and setters
    public int getBNo() {
        return bNo;
    }

    public void setBNo(int bNo) {
        this.bNo = bNo;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public String getBAuthor() {
        return bAuthor;
    }

    public void setBAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }
}
```

#### `test13` Class
```java
package test13;

import java.util.ArrayList;
import java.util.Scanner;

public class test13 {
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>(); // List to store books
        Scanner sc = new Scanner(System.in); // Scanner for user input

        while (true) { // Infinite loop until user chooses to exit
            // Print menu
            System.out.println("Welcome");
            System.out.println("1. Show books");
            System.out.println("2. Update books");
            System.out.println("3. Remove books");
            System.out.println("4. Exit the app");

            // Prompt user for choice
            System.out.println("Enter the serial number using the keyboard:");
            int choice = sc.nextInt(); // Get user input
            sc.nextLine(); // Clear newline character from buffer

            if (choice == 1) {
                // Show all books
                System.out.println("Bookstore - 1. Show books");
                for (int i = 0; i < list.size(); i++) {
                    Book b = list.get(i);
                    System.out.println(b.getBNo() + "---" + b.getBName() + "---" + b.getBAuthor());
                }
            } else if (choice == 2) {
                // Add new book
                System.out.println("Bookstore - 2. Update books");

                System.out.println("Enter the book number:");
                int bNo = sc.nextInt();
                sc.nextLine(); // Clear newline character

                System.out.println("Enter the book name:");
                String bName = sc.nextLine();

                System.out.println("Enter the book author:");
                String bAuthor = sc.nextLine();

                Book b = new Book(bNo, bName, bAuthor); // Create new book using constructor
                list.add(b); // Add to the list

            } else if (choice == 3) {
                // Remove book
                System.out.println("Bookstore - 3. Remove books");

                System.out.println("Enter the number of the book to be removed:");
                int delNo = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < list.size(); i++) {
                    Book b = list.get(i);
                    if (b.getBNo() == delNo) {
                        list.remove(b); // Remove book from list
                        System.out.println("Remove successfully");
                        break;
                    }
                }
            } else if (choice == 4) {
                // Exit the application
                System.out.println("Bookstore - 4. Exit the app");
                break;
            }
        }

        sc.close(); // Close scanner
    }
}
```

### Functionality Explanation

1. **Show Books**:
   - Iterates through the `list` and prints details (number, name, author) of each book.

2. **Add New Book**:
   - Prompts user for book number, name, and author.
   - Creates a new `Book` object using the provided details and adds it to the `list`.

3. **Remove Book**:
   - Asks user for the book number to be removed.
   - Searches through `list` for a book matching the given number and removes it.

4. **Exit the Application**:
   - When user selects option 4, exits the loop and terminates the program.

### Usage

- Run the program, and the user will see a menu.
- User can input a number corresponding to the desired operation.
- Depending on the choice, the program performs the corresponding action.

This program provides basic functionality for managing a bookstore inventory through a console interface.

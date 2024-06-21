// search book information based on the book number
// search all book information
// delete the specific book according to the number
// exit

package test20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayList list = new ArrayList(); // list outside the loop
        while (true) { // cycle
            // print menu
            System.out.println("Welcome");
            System.out.println("1. search book information based on the book number");
            System.out.println("2. search all book information");
            System.out.println("3. delete the specific book according to the number");
            System.out.println("4. Exit the app");

            // using Scanner
            Scanner sc = new Scanner(System.in); // create a scanner

            // Friendly tips
            System.out.println("Enter the serial number using the keyboard:");

            // Enter the serial number using the keyboard:
            int choice = sc.nextInt(); // Data is accepted after pressing enter

            if (choice == 1) {
                System.out.println("Enter the book number you want");
                // Check the collection
                int bno = sc.nextInt();

                Book b = findbookbybno(bno);
                // Determine if the book is found based on the result of b
                if (b == null) {
                    System.out.println("Book doesn't exist");
                } else { // Book exists
                    System.out.println("Found one book: " + b.getAuthor() + " " + b.getName() + " " + b.getPrice());
                }

            } else if (choice == 2) {
                ArrayList books = findbook();
                if (books.size() == 0) {
                    System.out.println("No books found");
                } else {
                    for (int i = 0; i <= books.size() - 1; i++) {
                        Book b = (Book) (books.get(i)); // Convert the found information to Book
                        System.out.println(b.getAuthor() + " " + b.getName() + " " + b.getPrice());
                    }
                }

            } else if (choice == 3) {
                // Enter the book number to delete
                System.out.println("Enter the book number you want to delete");
                int bno = sc.nextInt();
                int n = deleteBook(bno);
                if (n <= 0) {
                    System.out.println("Delete not successful");
                } else {
                    System.out.println("Delete successful");
                }

            } else if (choice == 4) {
                System.out.println("Bookstore - 4. Exit the app");
                break;
            }
        }
    }

    public static Book findbookbybno(int bno) throws ClassNotFoundException, SQLException {
        // Book is the return type of the method, indicating that this method will return a Book object.
        // findbookbybno is the name of the method, indicating searching for a book by book number.
        // (int bno) is the parameter of the method, indicating that an integer book number is passed in.

        // Package the above data into a Book object
        Book b = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        // Get connection
        String url = "jdbc:mysql://127.0.0.1:3306/bookstore?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        // Create session
        Statement sta = connection.createStatement();

        ResultSet rs = sta.executeQuery("select * from t_book1 where id =" + bno);
        // executeQuery() is a method of the Statement interface, used to execute SQL query statements (e.g., SELECT statements) and return a ResultSet object, which contains the data rows in the query result set.
        // ResultSet rs: The return value of the executeQuery() method is a ResultSet object, which contains the data result set retrieved from the database.
        // The ResultSet object can access the data in the query result set row by row through its methods. Usually, a while loop combined with the ResultSet.next() method is used to traverse each row of data in the query result.

        if (rs.next()) { // If there is only one result, use if to get it
            // Determine if there is a record
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            double price = rs.getDouble("price");

            b = new Book();
            b.setId(id);
            b.setAuthor(author);
            b.setPrice(price);
            b.setName(name);
        }

        // These methods are used to get the values of specific fields from the current ResultSet object rs. getInt("id"): Get the integer value of the column named "id".

        sta.close();
        connection.close();

        return b;
    }

    public static ArrayList findbook() throws ClassNotFoundException, SQLException { // search all information
        // If the findbook method returns an ArrayList object, the return type of the method should also be defined as ArrayList
        // Define a collection
        ArrayList list = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        // Get connection
        String url = "jdbc:mysql://127.0.0.1:3306/bookstore?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        // Create session
        Statement sta = connection.createStatement();

        ResultSet rs = sta.executeQuery("select * from t_book1");
        // executeQuery() is a method of the Statement interface, used to execute SQL query statements (e.g., SELECT statements) and return a ResultSet object, which contains the data rows in the query result set.
        // ResultSet rs: The return value of the executeQuery() method is a ResultSet object, which contains the data result set retrieved from the database.
        // The ResultSet object can access the data in the query result set row by row through its methods. Usually, a while loop combined with the ResultSet.next() method is used to traverse each row of data in the query result.

        while (rs.next()) { // If there is only one result, use if to get it
            // Determine if there is a record
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            double price = rs.getDouble("price");

            Book b = new Book();
            b.setId(id);
            b.setAuthor(author);
            b.setPrice(price);
            b.setName(name);

            list.add(b);
        }
        sta.close();
        connection.close();
        return list;
    }

    public static int deleteBook(int bno) throws ClassNotFoundException, SQLException {
        ArrayList list = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        // Get connection
        String url = "jdbc:mysql://127.0.0.1:3306/bookstore?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        // Create session
        Statement sta = connection.createStatement();

        int n = sta.executeUpdate("delete from t_book1 where id =" + bno);
        // executeUpdate is a method of the Statement interface, used to execute SQL statements such as INSERT, UPDATE, or DELETE, or SQL DDL statements (e.g., creating or deleting tables). This method returns an integer representing the number of rows affected (e.g., the number of rows inserted, updated, or deleted).
        // Mainly used for INSERT, UPDATE, and DELETE statements.
        // Returns an integer representing the number of rows affected.

        sta.close();
        connection.close();
        return n;
    }
}

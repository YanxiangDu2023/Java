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


Here's a brief overview of the improvements in test13update.java compared to test13.java:

1.Persistence (持久化存储):

test13update.java implements file handling and object serialization to persistently store book data. This ensures that the data remains saved even after the program terminates. In contrast, test13.java stores data only in memory, so data is lost when the program ends.

2.Code Structure (代码结构):

test13update.java is structured more modularly with methods handling file I/O operations and collection manipulations. This improves code organization and readability compared to test13.java, where all logic is contained within the main method, leading to longer and less maintainable code.

3.Exception Handling (异常处理):

test13update.java includes explicit exception handling for file operations (IOException) and object serialization (ClassNotFoundException). This enhances the robustness of the program, ensuring it handles potential errors gracefully. test13.java, on the other hand, lacks explicit exception handling, potentially causing the program to crash or behave unexpectedly in case of errors.

4.Collection Operations (集合操作):

In test13update.java, collection operations such as adding and removing books from the ArrayList are handled more effectively. For example, when removing a book, it avoids potential ConcurrentModificationException by correctly removing items from the collection.


#### `test13` Class
    
package test15;
import test15.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// book number book name book author
// 集合版的缺点：数据不能永久保存

public class test13update {
   
   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // ArrayList list = new ArrayList(); // list在循环外
        while(true){ // cycle

        // print menu
        System.out.println("Welcome");
        System.out.println("1. Show books");
        System.out.println("2. Update books");
        System.out.println("3. Remove books");
        System.out.println("4. Exit the app");

        // using Scanner
        Scanner sc = new Scanner(System.in); // 创建一个扫描器

        // Friendly tips
        System.out.println("Enter the serial number using the keyboard:");
        
        // Enter the serial number using the keyboard:
        int choice = sc.nextInt(); // 键盘录入后，必须回车，程序才可以接受数据

        if(choice == 1){ // 读取
            System.out.println("Bookstore - 1. Show books");
        
         

            File f = new File("/Users/amandadu/Desktop/coding/java/basic/test15/test.docx");// 从file中读取list


            
            if (f.exists() == true){ // 查看文件是否存在,f.exists()返回值是布尔值，true or false
            // 如果文件存在，证明之前的文件中已经有书籍了,需要将之前的集合读出来

            FileInputStream fis = new FileInputStream(f);
            // 创建一个FileInputStream对象fis，用于读取文件f的字节流。
            // FileInputStream是一个字节输入流，通常用于读取二进制数据。
            
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            // 将集合读取

            ArrayList list = (ArrayList)(ois.readObject()); // list 从文件中读取的集合
       
           

            for (int i = 0; i <= list.size()-1; i =i + 1){

                Book b = (Book)(list.get(i));
                System.out.println(b.getBNo()+ "---" + b.getBName() + "---" + b.getBAuthor());

            
            }
           }else{ //文件不存在 证明是第一次上新书籍
                // System.out.println("There are no new books at the moment. Please upload new books first.");
                // File f = new File("/Users/amandadu/Desktop/coding/java/basic/test15/test.docx"); //封装文件
                // ArrayList list = new ArrayList();
               
                // FileOutputStream fos = new FileOutputStream(f);
                
                // //创建一个FileOutputStream对象fos，用于将字节流写入文件f。
                // // FileOutputStream是一个字节输出流，通常用于写入二进制数据。
                
                // ObjectOutputStream oos = new ObjectOutputStream(fos);
    
                // // 创建一个ObjectOutputStream对象oos，将字节输出流fos转换为对象输出流。
                // // ObjectOutputStream可以序列化对象，即将对象转换为二进制数据并写入输出流。
    
                // // 将list 写出
                // oos.writeObject(list);
    
                // // 关闭流
                // oos.close(); //最外层关掉就行

                System.out.println("There are no books available.");

            }



            } else if(choice == 2){
            System.out.println("Bookstore - 2. Update books");

            // 从键盘录入书籍信息
             // 每上新一本书籍，就要创建一本书的对象
            System.out.println("Enter the book number");
            int bNo = sc.nextInt();
            sc.nextLine(); // 清除输入缓冲区中的换行符

            // 从键盘录入书籍的名称
            System.out.println("Enter the book name");
            String bName = sc.nextLine();

            // 从键盘录入书籍的作者
            System.out.println("Enter the book Author");
            String bAuthor = sc.nextLine(); // 使用nextline读取整行



            Book b = new Book(bNo,bName,bAuthor);
            // 在创建Book对象时，直接使用带参数的构造函数来初始化实例变量，去掉不必要的set方法调用。
            b.setBNo(bNo);
            b.setBName(bName);
            b.setBAuthor(bAuthor);
            
            File f = new File("/Users/amandadu/Desktop/coding/java/basic/test15/test.docx");// 从file中读取list

           
            if (f.exists() == true){ // 查看文件是否存在,f.exists()返回值是布尔值，true or false
                // 如果文件存在，证明之前的文件中已经有书籍了,需要将之前的集合读出来
    
                FileInputStream fis = new FileInputStream(f);
                // 创建一个FileInputStream对象fis，用于读取文件f的字节流。
                // FileInputStream是一个字节输入流，通常用于读取二进制数据。
                
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                // 将集合读取
    
                ArrayList list = (ArrayList)(ois.readObject()); // list 从文件中读取的集合
              

                //集合读取出来以后再增加新的书籍：
                list.add(b);

                // 将这个集合写出去

                FileOutputStream fos = new FileOutputStream(f);
                    
                    //创建一个FileOutputStream对象fos，用于将字节流写入文件f。
                    // FileOutputStream是一个字节输出流，通常用于写入二进制数据。
                    
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
        
                    // 创建一个ObjectOutputStream对象oos，将字节输出流fos转换为对象输出流。
                    // ObjectOutputStream可以序列化对象，即将对象转换为二进制数据并写入输出流。
        
                    // 将list 写出
                    oos.writeObject(list);
        
                    // 关闭流
                    oos.close(); //最外层关掉就行

       
                
                }else{ //文件不存在 证明是第一次上新书籍
                    // System.out.println("There are no new books at the moment. Please upload new books first.");
                    // File f = new File("/Users/amandadu/Desktop/coding/java/basic/test15/test.docx"); //封装文件
                    ArrayList list = new ArrayList();
                    list.add(b);
                   
                    FileOutputStream fos = new FileOutputStream(f);
                    
                    //创建一个FileOutputStream对象fos，用于将字节流写入文件f。
                    // FileOutputStream是一个字节输出流，通常用于写入二进制数据。
                    
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
        
                    // 创建一个ObjectOutputStream对象oos，将字节输出流fos转换为对象输出流。
                    // ObjectOutputStream可以序列化对象，即将对象转换为二进制数据并写入输出流。
        
                    // 将list 写出
                    oos.writeObject(list);
        
                    // 关闭流
                    oos.close(); //最外层关掉就行
    
                }

            // creat arraylist





        }else if(choice == 3){
            System.out.println("Bookstore - 3. Remove books");
            // 录入下架的书籍编号
            System.out.println("Enter the number of the book to be removed from the shelf");
            int delNo = sc.nextInt();
            sc.nextLine();
            ArrayList list = new ArrayList();
            for (int i =0; i<= list.size(); i = i+1){
                 Book b = (Book)(list.get(i));
                 if(b.getBNo()==delNo){// 从集合中移除
                    list.remove(b);
                    System.out.println("Remove successfully");
                    break;

                 }
            }

 



        }else if(choice == 4){
            System.out.println("Bookstore - 4. Exit the app");
            break;
        }


    }
}
    }

    



    
    




    
    




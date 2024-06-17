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

    



    
    


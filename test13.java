package test13;

import java.util.ArrayList;
import java.util.Scanner;

// book number book name book author

public class test13 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // list在循环外
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

        if(choice == 1){
            System.out.println("Bookstore - 1. Show books");
            // 对集合进行便利查看
            for (int i = 0; i <= list.size()-1; i =i + 1){

                Book b = (Book)(list.get(i));
                System.out.println(b.getBNo()+ "---" + b.getBName() + "---" + b.getBAuthor());

            
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

            // creat arraylist

            // ArrayList list = new ArrayList();
            list.add(b);


        }else if(choice == 3){
            System.out.println("Bookstore - 3. Remove books");
            // 录入下架的书籍编号
            System.out.println("Enter the number of the book to be removed from the shelf");
            int delNo = sc.nextInt();
            sc.nextLine();
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

    



    
    


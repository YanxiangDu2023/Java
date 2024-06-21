package test20;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/bookstore?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "root";
            
        Connection connection = DriverManager.getConnection(url, username, password);
        
        // 创建会话

        Statement sta = connection.createStatement();
        // 发送sql
        int i = sta.executeUpdate("INSERT INTO t_book1 (id,name,author,price) values (11,'red and black','Tangsida','49')");

        // 处理结果

        if (i>0){ // 证明对数据库的条数有影响
            System.out.println("insert sucessfully");

        }else{
            System.out.println("insert fail");
        }

        sta.close();
        connection.close();

    }

}
    


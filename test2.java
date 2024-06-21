package test20;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test2 {
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

        ResultSet rs = sta.executeQuery("select * from t_book1");
        // executeQuery() 是 Statement 接口的方法，用于执行SQL查询语句（例如 SELECT 语句）并返回一个 ResultSet 对象，该对象包含查询结果集中的数据行。
        // ResultSet rs: executeQuery() 方法的返回值是一个 ResultSet 对象，它包含了从数据库中检索到的数据结果集。
        // ResultSet 对象可以通过其方法逐行访问查询结果集中的数据。通常使用 while 循环结合 ResultSet.next() 方法来遍历查询结果的每一行数据。

        while(rs.next()){ //判断是否有记录存在
            System.out.println(rs.getInt("id") + "----" + rs.getString("name")+"----" +rs.getString("author")+"----"+rs.getDouble("price"));
        }
        // rs.next() 方法用于将 ResultSet 对象 rs 的游标移动到下一行数据，并返回 true 如果有更多的行存在，否则返回 false。
        // 因此，while (rs.next()) 表示当还有下一行数据时，执行循环体内的coding

        // 这些方法用于从当前 ResultSet 对象 rs 中获取特定字段的值。getInt("id"): 获取名为 "id" 的列的整数值。


   
        sta.close();
        connection.close();

    }

}
    


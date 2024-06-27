package test;

import mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Book;

import java.io.IOException;
import java.io.InputStream;

public class test3 {
    public static void main(String[] args) throws IOException {
        // 指定核心配置文件的路径； 从resource开始加载
        String resource = "mybatis.xml";
        //获取配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 加载配置文件，创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // String resource = "mybatis.xml";：指定了MyBatis配置文件的路径，这里假设配置文件位于项目的资源目录（src/main/resources）下。
        //InputStream inputStream = Resources.getResourceAsStream(resource);：通过MyBatis提供的Resources工具类加载配置文件，并获取配置文件的输入流。
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);：
        // 使用SqlSessionFactoryBuilder根据配置文件的输入流构建SqlSessionFactory，这是MyBatis的核心类之一，负责创建SqlSession实例。


        //通过工厂类获取一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 使用 sqlSessionFactory.openSession() 方法打开一个新的数据库会话（session）。
        // SqlSession 是 MyBatis 的核心对象之一，用于执行 SQL 命令和管理事务。

        // 动态代理模式，通过接口找到接口的实现类
        // 相当于 BookMapper mapper = BookMapper 接口=实现类 多态的一种

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book b = new Book();
        b.setId(11);
        b.setName("Red Sorghum");
        b.setAuthor("Mo Yan");
        b.setPrice(56);
        // insert
        int n = mapper.insertBook(b);
        if (n>0){
            System.out.println("Insert Successfully");

        }
        // 在 MyBatis 中，当你执行插入操作时，通常会返回一个 int 类型的值，这个值表示受影响的行数。具体来说：
        //
        //如果返回值是 1，则表示插入操作成功插入了一行记录。
        //如果返回值是 0，则表示插入操作没有插入任何行（可能是由于某种原因操作失败）。

        // delete
        Book b1 = new Book();
        b1.setId(8);

        int n1 = mapper.deleteBook(b1);
        if (n1>0){
            System.out.println("delete Successfully");

        }



        // 跟事务相关
        sqlSession.commit();

        //关闭资源
        sqlSession.close();



    }

}

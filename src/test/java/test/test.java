package test;

import mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test{

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

//      // MyBatis 使用动态代理模式，通过 sqlSession.getMapper(BookMapper.class) 方法获取 BookMapper 接口的实现类。
//      // 这个实现类是 MyBatis 在运行时自动生成的，能够执行接口中定义的 SQL 语句。

        List list = mapper.selectAllBooks();

        // 调用 BookMapper 接口中的 selectAllBooks 方法执行查询操作，返回查询结果的列表。
        // 是的，selectAllBooks 方法需要在 BookMapper 的 XML 映射文件中定义。MyBatis 会根据这个映射文件中的配置，执行对应的 SQL 查询并映射结果。

        // 遍历
        for (int i = 0; i<=list.size()-1; i = i+1){
            Book b = (Book)list.get(i);
            System.out.println(b.getName());

        }
        // 关闭资源
        sqlSession.close();

}

}

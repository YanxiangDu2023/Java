package mapper;

import pojo.Book;

import java.util.List;

public interface BookMapper {
    public abstract List selectAllBooks();
    public abstract Book selectOneBook(String name, String author);
    // 映射文件里面的id的名字必须跟SelectOneBook一样
    public abstract Book selectOneBook2(Book book); //全封装在一个对象里

    public abstract Book selectOneBook3(String name,Book book); //多个参数且参数里又有对象

    public abstract int insertBook(Book book);

    public abstract int deleteBook(Book book);



}

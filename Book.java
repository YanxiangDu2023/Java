package test20;

public class Book {
    // 实例变量
    private int Id;
    private String Name;
    private String Author;
    private double Price;
    

    // 构造方法，带有方法参数
    // public Book(int bno, String bName, String bAuthor) {
    //     // 使用this关键字区分实例变量和方法参数
    //     this.bno = bno;
    //     this.bName = bName;
    //     this.bAuthor = bAuthor;
    // }

    // Getter和Setter方法
    public void setAuthor(String author) {
        Author = author;
    }
    
    public void setName(String name) {
        Name = name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getAuthor() {
        return Author;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }
    public double getPrice() {
        return Price;
    }





// ### 解释

// 1. **实例变量**：`bno`、`bName`和`bAuthor`是在类`Book`中定义的实例变量。这些变量保存了每本书的编号、名称和作者。

// 2. **方法参数**：构造方法`Book(int bno, String bName, String bAuthor)`中的参数`bno`、`bName`和`bAuthor`用于初始化实例变量。在构造方法中，`this.bno`指的是实例变量，而`bno`指的是方法参数。通过使用`this`关键字，可以区分实例变量和方法参数。

// 3. **方法参数（在普通方法中）**：方法`printBookDetails`的参数`prefix`仅在该方法内有效，用于在打印书籍详细信息时作为前缀。

// ### 总结
// - 实例变量用于存储对象的状态，在整个类的范围内都可以访问。
// - 方法参数用于将数据传递给方法，只在方法内部有效。
// - 使用`this`关键字可以区分实例变量和方法参数，避免名称冲突。

    // 三个参数的构造器

    






}
    



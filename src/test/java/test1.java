public class test1 {
    public static void main(String[] ages){
        // 接口不能创建对象
        // Speak s = new Speak(); 这是错的
        // 可以创建实现类的对象
        Chinese ch = new Chinese();
        System.out.println(ch.AGE); // 访问常量
        ch.say(); // 调用方法

        American a = new American();
        a.say();
        System.out.println("-----------------------");

        // 通过接口实现多态；
        // 接口 = 实现类
        speak s = new Chinese();
        System.out.println(s.AGE);
        s.say(); // 表面调用的是接口的say方法，实际上走入到实现类的say方法中

        //多态的三要素
        // 1.继承 ===== 接口+实现
        // 2.重写 ===== 重写
        // 3.父类引用指向子类 ===== 接口 指向 实现类对象


    }
}

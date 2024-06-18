package test17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class testclient {// 客户端
    public static void main(String[] args) throws IOException {
        System.out.println("Client starts");
        // 套接字：指定服务器的ip和端口号

        Socket s = new Socket("192.168.31.111",8888);
        // 利用输出流传送数据
        // 创建一个 Socket 对象 s，指定连接的服务器IP地址（192.168.31.111）和端口号（8888）。
        // 这一步会尝试与服务器建立TCP连接。如果服务器在指定的IP和端口上监听，则连接成功；否则会抛出异常。

        OutputStream os =s.getOutputStream();

        // 从套接字对象 s 获取输出流 os。这个输出流用于向服务器发送数据。

        DataOutputStream dos = new DataOutputStream(os);
        // 用 DataOutputStream 包装输出流 os。DataOutputStream 提供了一些方便的方法，可以以一种更结构化的方式写数据。

        dos.writeUTF("hello service, this is client");


        // 对服务器返回的数据做一个处理
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        System.out.println("Server says " +str);


        // 依次关闭
        dis.close();
        is.close();
        dos.close();
        os.close();
        s.close();
        


        
    }
    
}

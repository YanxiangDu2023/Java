package test17;

// client send message to server, server needs to wait here first

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class testserver {
    public static void main(String[] args) throws IOException {
        // 套接字
        System.out.println("server starts");

        ServerSocket ss = new ServerSocket(8888);
        // 等待客户端发送数据

        Socket s = ss.accept();

        // 服务器感受到的是输入流

        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        // 接收客户端发送的数据
        String str = dis.readUTF();
        System.out.println("client says " + str);

        // 向客户端发送数据
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("Hello, client, I have received your message");

        

        // 流，网络资源关闭
        dos.close();
        os.close();
    
        dis.close();
        is.close();
        s.close();
        ss.close();

        
    }
    
}

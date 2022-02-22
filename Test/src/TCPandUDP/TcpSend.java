package TCPandUDP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TcpSend {
    public static void main(String[] args) throws IOException {
        send();
    }
    public static void send() throws IOException {
        Scanner s=new Scanner(System.in);
        //1.创建套接字，向服务端发送请求，等待接收
        Socket socket=new Socket("172.16.13.115",7777);
        //2.获得字节输出流
        OutputStream out=socket.getOutputStream();
        //3.写入数据
        out.write(s.nextLine().getBytes());
        //4.关闭
        out.close();
        socket.close();
    }
}

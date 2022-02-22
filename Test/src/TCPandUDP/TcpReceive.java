package TCPandUDP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class TcpReceive {
    public static void main(String[] args) throws IOException {
        receive();    }
    public static void receive() throws IOException {
        //FileOutputStream fos=new FileOutputStream("d://cpc.txt");
        //1.创建服务器套接字，广播端口号，等待客户端发送请求
        System.out.println("等待请求");
        ServerSocket ss=new ServerSocket(7777);
        //2.服务器接收客户端请求，通信链路创建成功
        Socket socket=ss.accept();
        System.out.println("接收到客户端请求，可以发送数据");
        //3.获取文件输入流
        InputStream in=socket.getInputStream();
        //4.读取数据
        byte[] bytes=new byte[1024];
        int i=in.read(bytes);
        //fos.write(bytes,0,i);
        System.out.println("接收到数据：  "+new String(bytes,0,i));
        //关闭
        in.close();
        socket.close();
        ss.close();
    }
}

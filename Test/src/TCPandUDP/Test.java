package TCPandUDP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端 ：负责读取从客户端发送过来的数据 ， 并把读取到的数据写入到本地文本  做持久化保存
public class Test {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(7777);

//		2.服务器接受客户端请求：通信链路创建成功
        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//		创建字符缓冲流：往a.txt中写入数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("D://fff.txt"));
//		4.读取数据
        String s;
        while((s=br.readLine())!=null) {
//			System.out.println(s);
            bw.write(s);
            bw.newLine();
            bw.flush();
        }

        //		5.关闭：后打开的先关闭
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();

    }
}
package homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpCline {
    public static void main(String[] args) throws Exception{
        //FileInputStream fis=new FileInputStream("d://cpc.txt");
        BufferedReader br=new BufferedReader(new FileReader("d://cpc.txt"));
        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String s;
        while ((s=br.readLine())!=null){
            bw.write(s);
            bw.newLine();//新写一行
            bw.flush();
        }
        socket.shutdownOutput();
        System.out.println("接收服务器端的消息");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
        bw.close();
        socket.close();
    }
}

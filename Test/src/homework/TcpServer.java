package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket socket=serverSocket.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new FileWriter("d://fff.txt"));
        String s;
        while ((s=br.readLine())!=null){
            bw.write(s);
            bw.newLine();//新写一行
            bw.flush();
        }
        System.out.println("响应给客户端");
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("远程传输成功");
        bufferedWriter.close();
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}

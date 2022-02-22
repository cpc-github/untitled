package TCPandUDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UdpSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        InetAddress address=InetAddress.getLocalHost();
        String str="你好";
        DatagramPacket dp=new DatagramPacket(str.getBytes(StandardCharsets.UTF_8),str.length(),address,9999);
        datagramSocket.send(dp);
        datagramSocket.close();
//        //创建数据包套接字
//        DatagramSocket datagramSocket=new DatagramSocket();
//        //	InetAddress address=InetAddress.getByName("172.16.13.100");
//        InetAddress inetAddress=InetAddress.getLocalHost();
//        String data=new String("你好");
//        DatagramPacket dp=new DatagramPacket(data.getBytes(),data.length(),inetAddress,9999);
//        //发送
//        System.out.println(data);
//        datagramSocket.send(dp);
//        datagramSocket.close();
        send();
    }
   public static void send() throws IOException {
       Scanner sc=new Scanner(System.in);
       DatagramSocket ds=new DatagramSocket();
       //InetAddress ia=InetAddress.getLocalHost();
       InetAddress ia=InetAddress.getByName("172.16.13.195");//将要发送的计算机的IP地址
       while (true){
           System.out.println("请输入：");
           String s=sc.nextLine();
           byte[] b=s.getBytes();
           DatagramPacket p=new DatagramPacket(b,b.length,ia,9999);
           ds.send(p);
       }
    }
}

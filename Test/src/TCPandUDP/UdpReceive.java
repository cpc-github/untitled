package TCPandUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.Date;

public class UdpReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(9999);
        byte[] bytes=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(dp);
        datagramSocket.close();
//        DatagramSocket datagramSocket=new DatagramSocket(9999);
//        byte[] b=new byte[1024];
//        DatagramPacket dp=new DatagramPacket(b,b.length);
//        datagramSocket.receive(dp);
//        System.out.println(new String(b,0,dp.getLength()));
//        datagramSocket.close();
        receive();

    }
    public static void receive() throws IOException {
        DatagramSocket ds=new DatagramSocket(9999);
        while (true){
            byte[] b=new byte[500];
            DatagramPacket p=new DatagramPacket(b,b.length);
            ds.receive(p);
            //获取实际长度
            String s=new String(b,0,p.getLength());
            System.out.println("发送方  "+new Date()+"     :"+s);
        }
    }
}

import java.io.*;
import java.net.InetAddress;

public class Day16 {
    public static void main(String[] args) throws IOException {
        InetAddress localhost=InetAddress.getLocalHost();
        System.out.println(localhost.getHostName());
        System.out.println(localhost.getHostAddress());
        InetAddress byName=InetAddress.getByName("DESKTOP-IEP6SH1");
        System.out.println(byName.getHostAddress());
        System.out.println(localhost.getHostName());
    }
}


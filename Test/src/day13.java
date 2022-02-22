import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 */
public class day13 {
    public static void main(String[] args) throws IOException {
        String s="空你几哇";
        byte[] bb=s.getBytes("gbk");
        String ss=new String(bb,"gbk");
        System.out.println(ss);
        //buffer();
        obj();
    }
    //字节缓冲流
    public static void buffer()throws IOException{
        FileInputStream fis=new FileInputStream("d://te.txt");
        BufferedInputStream bis=new BufferedInputStream(fis);
        byte[] b=new byte[10];
        int i=bis.read(b);
        System.out.println(new String(b));
    }
    public static void obj()throws IOException{
        FileOutputStream fis=new FileOutputStream("d://te.txt",true);
        ObjectOutput oop=new ObjectOutputStream(fis);
        User user=new User("asf",1);
        oop.writeObject(user);
    }

}
class User implements Serializable{
    String name;
    int id;
    public User(String n,int i){
        this.name=n;
        this.id=i;
    }
}
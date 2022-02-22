import java.io.*;


public class Day12 {
    public static void main(String[] args) throws IOException {
        字符();
    }
    public void 字节() throws IOException {
        FileInputStream fis=new FileInputStream("D://te.txt");
        FileOutputStream fos=new FileOutputStream("D://TT.png");
        byte[] b=new byte[24];
        int i=0;
        while ((i=fis.read(b))!=-1){
            fos.write(b,0,i);
            System.out.println(new String(b,0,i));

        }
        fos.flush();
        fos.close();
        fis.close();
    }
    public static void 字符() throws IOException {
        FileReader fr=new FileReader("d://te.txt");
        char[] chars=new char[10];
        int i=0;
        byte[] bb=new byte[10];
        while ((i=fr.read(chars))!=-1){
            System.out.println(i);
            System.out.println(new String(chars,0,i));
        }
    }
}

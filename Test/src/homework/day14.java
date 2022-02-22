package homework;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class day14 {
    public static void main(String[] args) throws Exception {
        Random r=new Random();
        System.out.println(Math.random());
        System.out.println(r.nextInt(50));
    }
//使用流技术将一张图片从F:\images目录下，
// 复制到D:\images目录下。
    public static void home1()throws Exception{
        FileInputStream fis=new FileInputStream("D://day14//swim.jpg");
        FileOutputStream fos=new FileOutputStream("D://day14//swim2.jpg");
        BufferedInputStream bis=new BufferedInputStream(fis);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        byte[] bytes=new byte[1024];
        int i=0;
        while ((i=bis.read(bytes))!=-1){
            bos.write(bytes);
        }
    }
//        编写java程序，往一个txt文件里写入学生的基本信息，
//        然后再读出这些信息，
//        最后把该文件拷贝到指定位置并在文件名前加入日期信息进行备份。
//        a.txt
//        test/2021年12月3日16时53分52秒 a.txt
    public static void home4() throws IOException {
        FileWriter fw=new FileWriter("D://day14//student.txt");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入学生信息");
        String str=scanner.nextLine();
        fw.write(str);
        fw.flush();
        fw.close();
        FileReader fr=new FileReader("D://day14//student.txt");
        FileWriter fw1=new FileWriter("D://day14//"+new Date().toString().replace(":","")+"student1.txt");
        char[] chars=new char[50];
        int j=1;
        while ((j=fr.read(chars))!=-1){
            System.out.println(chars);
            fw1.write(chars,0,j);
        }
        fw1.flush();
        fw1.close();
        fr.close();

    }
}
//创建两个线程,一个线程负责打印1-52,另一个线程打印A-Z。
//要求输出结果 1 A 2 B 3 C ...52 Z
class Thread1 extends Thread{
    Lock l;
    public Thread1(Lock l){
        this.l=l;
    }
    @Override
    public void run() {
        try {
            l.w1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread2 extends Thread{
    Lock l;
    public Thread2(Lock l){
        this.l=l;
    }
    @Override
    public void run() {
        try {
            l.wa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Lock{
    boolean flag;
    int close=0;
    public synchronized void w1() throws InterruptedException {
            for (int i = 1; i < 53; i++) {
                if (flag==false){
                    if (close!=1){
                        i--;
                    }
                    System.out.println(i);
                    if (close !=1) {
                        flag=true;
                    }else{
                        flag=false;
                    }
                }else {
                    this.wait();
                }
                this.notifyAll();
            }
        this.notifyAll();
    }
    public synchronized void wa() throws InterruptedException {
        int j=97;
        for (int i1=0;i1<26;i1++){
            if (flag){
                i1--;
                System.out.println((char) j);
                j++;
                if (i1<25){
                    flag=false;
                    if (j=='z'){
                        close=1;
                        break;
                    }
                }
            }else {
                this.wait();
            }
            this.notifyAll();
        }
        this.notifyAll();
    }
}





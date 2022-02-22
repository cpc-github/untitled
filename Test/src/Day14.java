public class Day14 {
    public static void main(String[] args) {
        MyThread myThread= new MyThread();
        MThread  mThread=new MThread();
        Thread thread=new Thread(mThread);
        myThread.start();
        //thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程"+i);
        }

    }

}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("____"+i);
        }
    }
}
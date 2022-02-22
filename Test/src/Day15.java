import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day15 {
    public static void main(String[] args) throws Exception {
        /*box box=new box();
        a a=new a(box);
        b b=new b(box);*/

//        Thread t1=new Thread(a);
//        Thread t2=new Thread(b);
//        t1.start();
//        t2.start();
        /*ExecutorService e= Executors.newFixedThreadPool(3);
        e.submit(a);
        e.submit(b);
        e.submit(new TaskA());*/
        TaskA taskA=new TaskA();
        taskA.call();
    }
}
class box{
    int a;
    boolean flag;
    public synchronized void put(){
        if (a==0){
            while (a!=9){
                a++;
                System.out.println(Thread.currentThread().getName()+"  "+this.a);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notifyAll();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    public synchronized void get(){
        if (a==9){
            while (a!=0){
                System.out.println(Thread.currentThread().getName()+"  "+this.a);
                a--;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notifyAll();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class a implements Runnable{
    private box box;
    public a(box box){
        this.box=box;
    }
    @Override
    public void run() {
        while (true){
            box.put();
        }

    }
}
class b implements Runnable{
    private box box;
    public b(box box){
        this.box=box;
    }
    @Override
    public void run() {
        while (true){
            box.get();
        }
    }
}
class TaskA implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"  "+"执行了");
        return null;
    }
}

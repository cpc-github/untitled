import java.util.Comparator;

public class Day18 {
    public static void main(String[] args) {
//        new Thread(()-> System.out.println("666")).start();
//        int a=new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        }.compare(20,30);
//        Comparator<Integer> comparator=(Integer o1,Integer o2)->o1-o2;
//        int b=comparator.compare(1,3);
//        System.out.println(b);

        eee((int a, int b) ->a+b);



    }
    public static void eee(Eatable eatable){
        int a=eatable.eat(1,2);
        System.out.println(a);
    }
}

interface Eatable{
    int eat(int a,int b);
}
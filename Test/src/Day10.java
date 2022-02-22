import javax.xml.crypto.Data;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Day10 {
    public static void main(String[] args) {
        String str=new String("ww");
        Object a=new Object();
        System.out.println(a instanceof String);
        int[] arr={2,8,1,6,9,2,0,11,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s =sdf.format(date);
        System.out.println(s);
    }
    public static void sort(int[] arr){
        for (int i = arr.length-1; i >0; i--) {
            for (int j=0;j<i;j++){
                if (arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void getAll(File filel){
        File[] files=filel.listFiles();
        for(File file:files){
            System.out.println(file.getName());
            if (file.getName().endsWith(".java")){
                System.out.println(file.getAbsolutePath());
            }if (file.isDirectory()){
                getAll(file);
            }
        }
    }
//    public static void getAll(File are){
//        File[] files=are.listFiles();
//        for(File file:files){
//            if (file.isFile()&&file.getName().equals("泡沫.txt")){
//                System.out.println(file.getAbsoluteFile());
//            }else {
//                getAll(file);
//            }
//        }
//    }
}

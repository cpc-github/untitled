import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Day17 {
    public static void main(String[] args) throws Exception {
        getMethod();
    }

    /**
     * 通过反射得到方法并执行
     * @throws Exception
     */
    public static void getMethod()throws Exception{
        Class c=Class.forName("Person");
        Object obj=c.getDeclaredConstructor().newInstance();
        //获得public方法
        Method method=c.getMethod("toString");
        Object o1=method.invoke(obj);
        System.out.println(o1);
        //获得private方法
        method=c.getDeclaredMethod("test", int.class);
        method.setAccessible(true);
        o1=method.invoke(obj,1);
    }
    /**
     * 通过反射获得构造方法并实例化对象
     * @throws Exception
     */
    public static void getConstructor()throws Exception{
        Class c=Class.forName("Person");        //  Class c=Person.class;
        //1.获取public构造方法
        Constructor[] constructors = c.getConstructors();
        //2.获取所有构造器
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        //3.根据参数获取对应的public构造器
        Constructor constructor1 = c.getConstructor(int.class);

        //实例化对象
        Person p=(Person) constructor1.newInstance(1);
        System.out.println(p);
        //根据参数获取对应的private构造器
        Constructor constructor2 = c.getDeclaredConstructor(int.class,String.class);
        //私有化构造器没有权限创建，需要得到权限
        constructor2.setAccessible(true);
        Person person=(Person) constructor2.newInstance(11,"xy");
        System.out.println(person);
    }
    /**
     * 通过反射修改属性
     * @throws Exception
     */
    public static void getField()throws Exception{
        Class c=Class.forName("Person");
        //通过反射得到构造方法，不是公共的
        Constructor con = c.getDeclaredConstructor();
        con.setAccessible(true);
        Object obj=con.newInstance();
        //得到属性并修改
        Field field=c.getField("age");
        field.set(obj,100);
        field=c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj,"崔鹏超");
        System.out.println(obj);
    }
}
class Person{
    public int age;
    private String name;
    Person(){}
    public Person(int age){
        this.age=age;
    }
    private Person(int age,String name){
        this.age=age;
        this.name=name;
    }

    private int test(int i){
        System.out.println(i);
        return i;
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
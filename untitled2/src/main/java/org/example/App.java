package org.example;

import org.example.util.Tom;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        Object obj=  1==2?new Integer(1):new Double(2.0);
        System.out.println(obj);
    }
}

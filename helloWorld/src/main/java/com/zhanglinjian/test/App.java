package com.zhanglinjian.test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        myThreadTh myTh1 = new myThreadTh();
        myThreadTh myTh2 = new myThreadTh();
        myTh1.start();
        myTh2.start();
        
        myThreadRn myRn1 = new myThreadRn();
        myThreadRn myRn2 = new myThreadRn();
        Thread thread1 = new Thread(myRn1);
        Thread thread2 = new Thread(myRn2);
        thread1.start();
        thread2.start();
    }
}

package com.zhanglinjian.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        //extends Thread
    	System.out.println( "extends Thread!" );
        myThreadTh myTh1 = new myThreadTh();
        myThreadTh myTh2 = new myThreadTh();
        myTh1.start();
        myTh2.start();
        
    	System.out.println( "a-------------------------a" );
    	
        //implement runnable
    	System.out.println( "implement runnable!" );        
        myThreadRn myRn1 = new myThreadRn();
        myThreadRn myRn2 = new myThreadRn();
        Thread thread1 = new Thread(myRn1);
        Thread thread2 = new Thread(myRn2);
        thread1.start();
        thread2.start();

    	System.out.println( "a-------------------------a" );
    	
    	//thread pool size
    	int taskSize = 5;
        
    	//create thread pool
    	ExecutorService pool = Executors.newFixedThreadPool(taskSize);
    	
    	//create some task object that return
    	List<Future> list = new ArrayList<Future>();
    	
    	for(int i = 0 ; i<taskSize ; i++){
    		 Callable c = new myCallable(i+" ");
    		 
    		 //excute task and fetch result
    		 Future f = pool.submit(c);
    		 
    		 list.add(f);   		 
    	}
    	//shutdown thread pool
    	pool.shutdown();
        
    	//fetch all pool thread excute result
    	for ( Future f : list){
    		//out print
    		System.out.println(">>>>" + f.get().toString());
    		
    	}
    		
    }
}

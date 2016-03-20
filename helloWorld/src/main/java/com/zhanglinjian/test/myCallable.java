package com.zhanglinjian.test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;

public class myCallable implements Callable<Object>{
	private String taskNum;
	
	myCallable (String taskNum){
		this.taskNum = taskNum;
	}
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("The task:"+taskNum+" is start to running!");
		Date dateTaska = new Date();
		Random rn = new Random();
		int sint = rn.nextInt(1000);
		System.out.println("sleep :"+sint+"ms!");
		Thread.sleep(sint);
		Date dateTaskb = new Date();
		long time = dateTaskb.getTime() - dateTaska.getTime();
		System.out.println("The task:"+taskNum+" is stop!");
	
		return "The thread task result:"+taskNum+" ,cost time["+time+"]ms";
	}

}

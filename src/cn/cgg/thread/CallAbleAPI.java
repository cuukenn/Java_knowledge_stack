package cn.cgg.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallAbleAPI implements Callable<String>{

	private String name;
	
	public CallAbleAPI(String name) {
		this.name=name;
	}
	@Override
	public String call() throws Exception {
		System.out.println("-------------线程"+this.name+"开始-------------");
		System.out.println(this.name);
		System.out.println("-------------线程"+this.name+"结束-------------");
		return new String("消息"+this.name);
	}
	
	public static void main(String[] args) {
		ExecutorService exc=Executors.newFixedThreadPool(10);
		ArrayList<Future<String>> arrayList=new ArrayList<Future<String>>();
		for(int i=0;i<10;i++)arrayList.add(exc.submit(new CallAbleAPI("callable:"+i)));
		boolean isDone = false;
        while (!isDone) {
            isDone = true;
            for (Future<String> future : arrayList) {
                if (!future.isDone()) {
                    isDone = false;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    break;
                }
            }
        }
        exc.shutdown();
	}
}

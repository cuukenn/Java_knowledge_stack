package cn.cgg.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import javafx.scene.chart.PieChart.Data;

public class ReentrantLockAPI {
	private static ReentrantLock lock;
	private static Condition condition;

	static {
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				lock.lock();
				Long old=new Date().getTime();
				System.out.println("----拿到了锁-----"+" "+old+" "+this);
				try {
					System.out.println("---等待一个信号-------" + this);
					condition.await();
					System.out.println("----拿到一个信号------" + this);
				} catch (Exception e) {
				} finally {
					System.out.println("----解锁-----"+this);
					System.out.println("历时："+(new Date().getTime()-old)+" "+this);
					lock.unlock();
					
				}
			}
		};
		Runnable task2 = new Runnable() {
			private Date date=new Date();
			@Override
			public void run() {
				lock.lock();
				Long old=new Date().getTime();
				System.out.println("----拿到了锁-----"+" "+old+" "+this);
				try {
					System.out.println("---发送一个信号-------" + this);
					condition.signal();
				} catch (Exception e) {
				} finally {
					System.out.println("----解锁-----"+this);
					System.out.println("历时："+(new Date().getTime()-old)+" "+this);
					lock.unlock();
				}
			}
		};
		executorService.submit(task1);
		executorService.submit(task2);
	}
}

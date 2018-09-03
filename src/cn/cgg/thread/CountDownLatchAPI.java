package cn.cgg.thread;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchAPI implements Runnable {
	private static int size = 100;
	private static CountDownLatch stopLatch = new CountDownLatch(size);
	private static CountDownLatch startLatch = new CountDownLatch(1);

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			startLatch.await();
			System.out.println("---开始运行主体----");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stopLatch.countDown();
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < size; i++) {
			new Thread(new CountDownLatchAPI()).start();
		}
		System.out.println(new Date().getTime());
		startLatch.countDown();
		stopLatch.await();
		System.out.println(new Date().getTime());
	}
}

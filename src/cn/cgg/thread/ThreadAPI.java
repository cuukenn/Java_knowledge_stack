package cn.cgg.thread;

public class ThreadAPI {
	private static Object o = new Object();

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					System.out.println("线程进入休眠" + Thread.currentThread().getName());
					try {
						Thread.currentThread().sleep(1000l);
						System.out.println("线程继续执行" + Thread.currentThread().getName());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread1 = new Thread(runnable, "first thread");
		Thread thread2 = new Thread(runnable, "Second thread");
		thread1.start();
		thread2.start();
	}
}

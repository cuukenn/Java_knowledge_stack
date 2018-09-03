package cn.cgg.server;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
	private ThreadPoolExecutor threadPools;
	private static ThreadPool threadPool;

	private ThreadPool() {
		threadPools = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}

	public static ThreadPool getIntance() {
		if (threadPool == null)
			threadPool = new ThreadPool();
		return threadPool;
	}
	
	public void addThread(Runnable runnable) {
		threadPools.submit(runnable);
	}
	
}

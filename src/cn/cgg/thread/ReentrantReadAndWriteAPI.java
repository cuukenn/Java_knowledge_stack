package cn.cgg.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadAndWriteAPI {
	private static ReentrantReadAndWriteAPI readAndWriteAPI;
	private static ReentrantReadWriteLock lock;
	private static ReadLock readLock;
	private static WriteLock writeLock;

	private Map<String, Object> map;

	static {
		lock = new ReentrantReadWriteLock();
		readLock = lock.readLock();
		writeLock = lock.writeLock();
	}
	
	{
		System.out.println("----实例化ReentrantReadAndWriteAPI----------");
	}

	private ReentrantReadAndWriteAPI() {
		System.out.println("----运行ReentrantReadAndWriteAPI构造方法---------");
		map = new HashMap<>();
	};

	public static ReentrantReadAndWriteAPI getInstance() {
		writeLock.lock();
		if (readAndWriteAPI == null)
			readAndWriteAPI = new ReentrantReadAndWriteAPI();
		writeLock.unlock();
		return readAndWriteAPI;
	}

	public Object read(String key) {
		readLock.lock();
		Object obj = null;
		try {
			obj = map.get(key);
			if (obj == null) {
				readLock.unlock();
				writeLock.lock();
				try {
					if (obj == null) {
						obj = "this is a data from disk";
					}
				} finally {
					readLock.lock();
					writeLock.unlock();
				}

			}
		} finally {
			readLock.unlock();
		}
		return obj;

	}

	public void write(String key, Object value) {
		writeLock.lock();
		try {
			map.put(key, value);
		} catch (Exception e) {
		} finally {
			writeLock.unlock();
		}

	}

	public static void main(String[] args) {
		ReentrantReadAndWriteAPI instance = ReentrantReadAndWriteAPI.getInstance();
		instance.write("a", "haha");
		System.out.println(instance.read("a"));
		System.out.println(instance.read("b"));
	}
}

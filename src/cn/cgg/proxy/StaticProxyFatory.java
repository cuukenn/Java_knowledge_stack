package cn.cgg.proxy;

import java.util.Date;

public class StaticProxyFatory implements MyInterface {
	private MyInterface myInterface;

	public StaticProxyFatory(MyInterface myInterface) {
		this.myInterface = myInterface;
	}

	@Override
	public void print() {
		System.out.println("开始运行方法  startTime=" + new Date().getTime());
		myInterface.print();
		System.out.println("结束运行方法  endTime=" + new Date().getTime());
	}

}

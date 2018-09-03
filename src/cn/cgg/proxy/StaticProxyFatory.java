package cn.cgg.proxy;

import java.util.Date;

public class StaticProxyFatory implements MyInterface {
	private MyInterface myInterface;

	public StaticProxyFatory(MyInterface myInterface) {
		this.myInterface = myInterface;
	}

	@Override
	public void print() {
		System.out.println("��ʼ���з���  startTime=" + new Date().getTime());
		myInterface.print();
		System.out.println("�������з���  endTime=" + new Date().getTime());
	}

}

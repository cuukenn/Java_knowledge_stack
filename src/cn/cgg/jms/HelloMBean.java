package cn.cgg.jms;

public interface HelloMBean {
	public void setName(String name);

	public String getName();

	public void printHello();

	public void printHello(String name);
}

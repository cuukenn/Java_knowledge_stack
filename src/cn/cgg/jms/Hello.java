package cn.cgg.jms;

public class Hello implements HelloMBean{
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printHello() {
		System.out.println(String.format("hello jms:%s",name));
		
	}
	@Override
	public void printHello(String name) {
		System.out.println(String.format("hello %s",name));
		
	}
	
}

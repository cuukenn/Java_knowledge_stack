package cn.cgg.proxy;

public class ProxyTest {
	public static void main(String[] args) {

		System.out.println("-----static proxy-------------");
		StaticProxyFatory staticProxyFatory = new StaticProxyFatory(new MyPrint());
		staticProxyFatory.print();
		System.out.println();

		System.out.println("-----dynamic proxy-------------");
		DynamicProxyFactory factory = new DynamicProxyFactory(MyPrint.class);
		MyInterface myInterface = (MyInterface) factory.newInstance();
		myInterface.print();
	}
}

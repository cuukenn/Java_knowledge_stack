package cn.cgg.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

public class DynamicProxyFactory {
	private Class<?> clazz;

	public DynamicProxyFactory(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Object newInstance() {
		Object object = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("开始运行方法" + method.getName() + " startTime=" + new Date().getTime());
				method.invoke(clazz.getDeclaredConstructor().newInstance(), args);
				System.out.println("结束运行方法" + method.getName() + " endTime=" + new Date().getTime());
				return null;
			}
		});
		return object;
	}
}

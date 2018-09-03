package cn.cgg.reference;

import java.lang.ref.WeakReference;
/**
 * <pre>
 * 弱引用是在第二次垃圾回收时回收，短时间内通过弱引用取对应的数据，可以取到，当执行过第二次垃圾回收时，将返回null。
弱引用主要用于监控对象是否已经被垃圾回收器标记为即将回收的垃圾，可以通过弱引用的isEnQueued方法返回对象是否被垃圾回收器标记。
 * </pre>
 * @author admin
 *
 */
public class WeakReferenceTest {
	public static void main(String[] args) {
		Object o=new Object();
		WeakReference<Object> reference = new WeakReference<Object>(o);
		o=null;
		System.out.println(reference.get());
		System.out.println(reference.isEnqueued());
	}
}

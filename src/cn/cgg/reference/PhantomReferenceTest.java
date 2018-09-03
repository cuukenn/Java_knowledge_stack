package cn.cgg.reference;

import java.lang.ref.PhantomReference;

public class PhantomReferenceTest {
	public static void main(String[] args) {
		Object o=new Object();
		PhantomReference<Object> reference=new PhantomReference<Object>(o, null);
		o=null;
		System.out.println(reference.get());
		System.out.println(reference.isEnqueued());
	}
}

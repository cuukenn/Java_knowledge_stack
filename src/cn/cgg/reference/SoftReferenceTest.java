package cn.cgg.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {
	public static void main(String[] args) {
		Object o=new Object();
		SoftReference<Object> reference=new SoftReference<Object>(o);
		o=null;
		System.out.println(reference.get());
		System.out.println(reference.enqueue());
	}
}

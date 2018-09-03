package cn.cgg.reference;

import java.security.Principal;

public class SturdyReference {
	public static void main(String[] args) {
		Object o=new Object();
		System.out.println(o.hashCode());
	}
}

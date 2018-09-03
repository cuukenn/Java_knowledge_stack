package cn.cgg.outofmemery;

import java.util.ArrayList;

public class Heapoverflow {
	public static void main(String[] args) {
		
		ArrayList<String> array = new ArrayList<>(10000_00000);
		for (int i = 0; i < 10000_00000; i++) {
			array.add(Integer.toString(i));
			if (i % 10000 == 0) {
				System.out.println(i);
			}
		}
	}
}

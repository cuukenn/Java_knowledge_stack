package cn.cgg.outofmemery;

public class StackOverflow {
	public static void main(String[] args) throws Exception {
		new StackOverflow().miao();
	}

	public void miao() {
		long time = System.currentTimeMillis();
		miao();
	}
}
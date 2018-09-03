package cn.cgg.designmode;

public class TestSimgleInstance {
	public static void main(String[] args) {
		SimgleInstance instance = SimgleInstance.getInstance();
		instance.print();
		System.out.println(instance);
	}
}

class SimgleInstance {
	private static volatile SimgleInstance instance = null;

	public static SimgleInstance getInstance() {
		synchronized (TestSimgleInstance.class) {
			if (instance == null) {
				instance = new SimgleInstance();
			}
		}
		return instance;
	}

	private SimgleInstance() {
	};

	public void print() {
		System.out.println("µ¥ÀýÄ£Ê½");
	}
}

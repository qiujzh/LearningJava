package threadcore;

public class Main {

	public static void main(String[] args){
		MyThread mt = new MyThread();
//		mt.setName("B");
		Thread t = new Thread(mt);
		t.setName("A");
		t.start();
	}
}

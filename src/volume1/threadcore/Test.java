package volume1.threadcore;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Sub main = new Sub();
		
		MyThread t1 = new MyThread(main);
		MyThread t2 = new MyThread(main);
		t1.start();
		t2.start();
	}
	
}

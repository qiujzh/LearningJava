package volume1.threadcore;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread t = new MyThread();
		t.start();
		Thread.sleep(5000);
		t.suspend();
		System.out.println(System.currentTimeMillis()+"    "+t.getI());
		Thread.sleep(5000);
		System.out.println(System.currentTimeMillis()+"    "+t.getI());
		t.resume();
		Thread.sleep(5000);
		t.suspend();
		System.out.println(System.currentTimeMillis()+"    "+t.getI());
		Thread.sleep(5000);
		System.out.println(System.currentTimeMillis()+"    "+t.getI());
	}

}

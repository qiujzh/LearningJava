package volume1;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread();
		Thread t = new Thread(t1);
		System.out.println(t.isAlive());
		t.setName("A");
		t.start();
		System.out.println(t.isAlive());
		try {
			Thread.sleep(5000);
			System.out.println(t.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

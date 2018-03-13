package volume1.threadcore;

public class Main {

	synchronized public void f1(){
		System.out.println("main f1 begin");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main f1 end");
	}
	
}

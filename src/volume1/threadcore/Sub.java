package volume1.threadcore;

public class Sub extends Main {
	
	

	@Override
	public synchronized void f1() {
		// TODO Auto-generated method stub
		super.f1();
	}

	public void f2(){
		System.out.println("main f2 begin");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main f2 end");
	}
}

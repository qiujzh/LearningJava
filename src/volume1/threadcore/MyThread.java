package volume1.threadcore;

public class MyThread extends Thread{
	private Sub sub;
	
	public MyThread(Sub sub) {
		super();
		this.sub = sub;
	}

	@Override
	public void run(){
		sub.f1();
	}
}

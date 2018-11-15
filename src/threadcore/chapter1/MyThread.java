package threadcore.chapter1;

public class MyThread extends Thread{
	
	public MyThread() {
		System.out.println("MyThread begin");
		System.out.println("----MyThread--Thread.currentThread().getName()��" + Thread.currentThread().getName());
		System.out.println("----MyThread--this.getName()��" + this.getName());
		System.out.println("MyThread end");
	}

	@Override
	public void run(){
		System.out.println("run begin");
		System.out.println("----run--Thread.currentThread().getName()��" + Thread.currentThread().getName());
		System.out.println("----run--this.getName()��" + this.getName());
		System.out.println("run end");
	}
}

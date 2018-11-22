package threadcore.chapter1;
/**
 * 
 * @author qiujzh
 * @date 2018年11月15日
 * @description main()方法
 */
public class Main {

	public static void main(String[] args) throws Exception{
		System.out.println("begin");
		for(int i = 0; i < 10; i++){
			if(i == 5){
				throw new Exception("123");
			}
			System.out.println("i = "+ i);
		}
		System.out.println("end");
//		exceptionInterruptDemo1();
//		exceptionInterruptDemo();
//		isInterruptedDemo();
//		interruptedDemo();
//		getIdDemo();
//		sleepDemo();
//		isAliveDemo();
//		currentThreadDemo();
	}
	public static void currentThreadDemo(){
		MyThread mt = new MyThread();
//		mt.setName("B");
		Thread t = new Thread(mt);
		t.setName("A");
		t.start();
	}
	public static void isAliveDemo(){
		IsAliveThread iat = new IsAliveThread();
		System.out.println("main begin: " + iat.isAlive());
		iat.start();
		//Thread.sleep(2000);
		System.out.println("main end: " + iat.isAlive());
	}
	public static void sleepDemo(){
		SleepThread st = new SleepThread();
		System.out.println("begin " + System.currentTimeMillis());
//		st.run();
		st.start();
		System.out.println("end " + System.currentTimeMillis());
	}
	public static void getIdDemo(){
		Long threadId = Thread.currentThread().getId();
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName +": " + threadId);
	}
	public static void interruptedDemo(){
		InterruptedThread it = new InterruptedThread();
		it.start();
//		it.interrupt();
		Thread.currentThread().interrupt();//中断main方法
		System.out.println(it.interrupted());
		System.out.println(it.interrupted());
	}
	public static void isInterruptedDemo(){
		IsInterruptedThread iit = new IsInterruptedThread();
		iit.start();
		iit.interrupt();
		System.out.println(iit.isInterrupted());
		System.out.println(iit.isInterrupted());
	}
	public static void exceptionInterruptDemo(){
		ExceptionInterruptThread eit = new ExceptionInterruptThread();
		eit.start();
		try {
			eit.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eit.interrupt();
		System.out.println("main end");
	}
	/**
	 * 在sleep过程中被中断
	 */
	public static void exceptionInterruptDemo1(){
		System.out.println("main begin");
		InterruptedThread1 thread = new InterruptedThread1();
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
		System.out.println("main end");
	}
}

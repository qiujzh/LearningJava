package threadcore.chapter1;
/**
 * 
 * @author qiujzh
 * @date 2018年11月15日
 * @description main()方法
 */
public class Main {

	public static void main(String[] args){
		currentThreadDemo();
//		isAliveDemo();
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
}

package threadcore.chapter1;
/**
 * @description 线程在sleep过程中被中断，抛出异常
 * @author qiujzh
 *
 */

public class InterruptedThread1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run begin");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("沉睡过程中被中断，抛出异常，线程终止");
			e.printStackTrace();
		}
		System.out.println("run end");
		while(true){
			System.out.println("wa hahahahahahah");
		}
	}
}

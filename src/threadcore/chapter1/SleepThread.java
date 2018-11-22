package threadcore.chapter1;

/**
 * @author qiujzh
 * @date 2018年11月16日
 * @description sleep()方法使用
 */
public class SleepThread extends Thread {

	@Override
	public void run() {
		System.out.println("run threadName = " + this.currentThread().getName() + " begin");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("run threadName = " + this.currentThread().getName() + " end");
	}
}

package threadcore.chapter1;

/**
 * @author qiujzh
 * @date 2018��11��16��
 * @description sleep()����ʹ��
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

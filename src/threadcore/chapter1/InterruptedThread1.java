package threadcore.chapter1;
/**
 * @description �߳���sleep�����б��жϣ��׳��쳣
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
			System.out.println("��˯�����б��жϣ��׳��쳣���߳���ֹ");
			e.printStackTrace();
		}
		System.out.println("run end");
		while(true){
			System.out.println("wa hahahahahahah");
		}
	}
}

package threadcore.chapter1;

/**
 * @author qiujzh
 * @date 2018��11��15��
 * @description isAlive()����ʹ��
 */
public class IsAliveThread extends Thread {
	@Override
	public void run(){
		System.out.println("run: " + this.isAlive());
	}
}

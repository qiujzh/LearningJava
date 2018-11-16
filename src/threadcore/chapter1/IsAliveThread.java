package threadcore.chapter1;

/**
 * @author qiujzh
 * @date 2018年11月15日
 * @description isAlive()方法使用
 */
public class IsAliveThread extends Thread {
	@Override
	public void run(){
		System.out.println("run: " + this.isAlive());
	}
}

package threadcore.chapter1;
/**
 * @author qiujzh
 * @date 2018年11月15日
 * @description currentThread()方法使用
 */
public class MyThread extends Thread{
	/**
	 * @return
	 */
	public MyThread() {
		System.out.println("MyThread begin");
		System.out.println("----MyThread--Thread.currentThread().getName()：" + Thread.currentThread().getName());
		System.out.println("----MyThread--this.getName()：" + this.getName());
		System.out.println("MyThread end");
	}

	@Override
	public void run(){
		System.out.println("run begin");
		System.out.println("----run--Thread.currentThread().getName()：" + Thread.currentThread().getName());
		System.out.println("----run--this.getName()：" + this.getName());
		System.out.println("run end");
	}
}

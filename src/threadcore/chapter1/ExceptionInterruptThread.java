package threadcore.chapter1;

public class ExceptionInterruptThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i = 0; i < 5000; i++){
				if(this.interrupted()){
					System.out.println("线程被终止，抛出异常来结束线程");
					throw new InterruptedException();
				}
				System.out.println("i = " + i);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("异常已抛出，线程真的结束了");
		}
		System.out.println("============");
	}
	
}

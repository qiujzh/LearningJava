package threadcore.chapter1;

public class InterruptedThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 500; i++){
			System.out.println("i = " + i);
		}
	}
}

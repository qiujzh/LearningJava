package threadcore.chapter1;

public class ExceptionInterruptThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i = 0; i < 5000; i++){
				if(this.interrupted()){
					System.out.println("�̱߳���ֹ���׳��쳣�������߳�");
					throw new InterruptedException();
				}
				System.out.println("i = " + i);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("�쳣���׳����߳���Ľ�����");
		}
		System.out.println("============");
	}
	
}

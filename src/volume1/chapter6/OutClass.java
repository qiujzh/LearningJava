package volume1.chapter6;

public class OutClass {
	static class InnerClass1{
		public void method1(InnerClass2 class2){
			synchronized(class2){
				System.out.println(Thread.currentThread().getName()+" ����InnerClass1��method1����");
				for(int i = 0; i < 10; i++){
					System.out.println("i = "+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" �뿪InnerClass1��method1����");
			}
		}
		synchronized public void method2(){
				System.out.println(Thread.currentThread().getName()+" ����InnerClass1��method2����");
				for(int j = 0; j < 10; j++){
					System.out.println("j = "+j);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" �뿪InnerClass1��method2����");
		}
	}
	static class InnerClass2{
		public static void method1(){
			synchronized(InnerClass2.class){
				System.out.println(Thread.currentThread().getName()+" ����InnerClass2��method1����");
				for(int k = 0; k < 10; k++){
					System.out.println("k = "+k);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" �뿪InnerClass2��method1����");
			}
			
		}
	}
		
}

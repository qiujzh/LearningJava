package volume1.chapter6;

public abstract class Dog implements Animal {
	
	public abstract void barking(); 
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("eating");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("runing");
	}

}

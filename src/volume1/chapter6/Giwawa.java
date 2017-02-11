package volume1.chapter6;

import java.util.Date;

public class Giwawa extends Dog implements Cloneable{
	public String name;
	public int age;
	public Date birthday;
	public Giwawa(){
		super();
	}
	public Giwawa(String name,int age){
		this.name = name;
		this.age = age;
		this.birthday = new Date();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Giwawa clone = (Giwawa) super.clone();
		clone.birthday = (Date) birthday.clone();
		return clone;
	}
	@Override
	public void barking() {
		// TODO Auto-generated method stub
		System.out.println("barking: Giwawa! Giwawa!");
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Giwawa dog1 = new Giwawa("Marry",2);
		System.out.println(dog1.getName()+"  "+dog1.getAge()+"  "+dog1.getBirthday());// print Marry 2 2017
		Giwawa dog2 = dog1;
		dog2.setName("Lucas");
		dog2.setAge(3);
		dog2.getBirthday().setYear(116);
		System.out.println(dog1.getName()+"  "+dog1.getAge()+"  "+dog1.getBirthday());// print Lucas 3 2016
		System.out.println(dog2.getName()+"  "+dog2.getAge()+"  "+dog2.getBirthday());//print Lucas 3 2016
		
		Giwawa dog3 = (Giwawa) dog1.clone();
		dog3.setName("Penny");
		dog3.setAge(4);
		dog3.getBirthday().setYear(110);
		System.out.println(dog1.getName()+"  "+dog1.getAge()+"  "+dog1.getBirthday());// print Lucas 3 2010
		System.out.println(dog3.getName()+"  "+dog3.getAge()+"  "+dog3.getBirthday());//print Penny 4 2010
	}
}

package volume1.chapter13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		System.out.println(System.currentTimeMillis());
		for(int i=0;i<10000000;i++){
			list.add(i+"");
		}
		
//		for(int i=0;i<5000000;i++){
//			list.get(i);
//		}
		System.out.println(System.currentTimeMillis());
	}

}

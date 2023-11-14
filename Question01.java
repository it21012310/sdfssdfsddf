



































































































////////////////////////////////////////////////Threads
//starPattern1

package paperDis;

public class Pattern01 extends Thread{
	
	
	private Object lock;
	private String pattern;
	private int count;
	
	public Pattern01(Object lock, String pattern, int count) {
		super();
		this.lock = lock;
		this.pattern = pattern;
		this.count = count;
	}
	
	public void run() {
		
		synchronized (lock) {
			for(int i = 0; i < count; i++) {
				System.out.print("Pattern 01 Thread =");
				for(int j = 0; j < count - i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < i+1; j++) {
					System.out.print(pattern + " ");
				}
				System.out.println();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

}



//starPattern2
package paperDis;

public class Pattern02 extends Thread{
	
	
	private Object lock;
	private String pattern;
	private int count;
	
	public Pattern02(Object lock, String pattern, int count) {
		super();
		this.lock = lock;
		this.pattern = pattern;
		this.count = count;
	}
	
	public void run() {
		
		synchronized (lock) {
			for(int i = 0; i < count; i++) {
				System.out.print("Pattern 02 Thread =");
				for(int j = 0; j < count - i; j++) {
					System.out.print(" ");
				}
				for(int j = 0; j < i+1; j++) {
					System.out.print(pattern + " ");
				}
				System.out.println();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

}


//startPatternMain


package paperDis;

import java.util.Scanner;

public class Main {
	
public static void main(String[] args) {
		
		Object lock = new Object();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter pattern 1 =");
		String p1 = sc.next(); 
		
		System.out.println("Enter pattern 2 =");
		String p2 = sc.next(); 
		
		System.out.println("Enter count  =");
		int c1 = sc.nextInt(); 
		
		Pattern01 t1 = new Pattern01(lock,p1,c1);
		Pattern02 t2 = new Pattern02(lock,p2,c1);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}






///////////////////////////////Abstract
//Item


package first;


public abstract class Item {
	
	private int itemNo;
	private String des;
	private double unitPrice;
	public Item(int itemNo, String des, double unitPrice) {
		
		this.itemNo = itemNo;
		this.des = des;
		this.unitPrice = unitPrice;
	}
	
	public void Display() {
		System.out.println(itemNo);
		System.out.println(des);
		System.out.println(unitPrice);
		
	}
          
	
}
 
 
 //Book
 
 


package first;

public class Book extends Item {
	
	private String publisher;
	private String category;
	private int pages;
	
	public Book(int itemNo, String des, double unitPrice, String publisher, String category, int pages) {
		super(itemNo, des, unitPrice);
		this.publisher = publisher;
		this.category = category;
		this.pages = pages;
	}

	@Override
	public void Display() {
		// TODO Auto-generated method stub
		super.Display();
		System.out.println(publisher);
		System.out.println(category);
		System.out.println(pages);
	}
	
	
	
	

	
}

//Car


package first;

public class Car extends Item {
	
	private String model;
	private String type;
	
	public Car(int itemNo, String des, double unitPrice, String model, String type) {
		super(itemNo, des, unitPrice);
		this.model = model;
		this.type = type;
	}

	@Override
	public void Display() {
		super.Display();
		
		System.out.println(model);
		System.out.println(type);
	}
	
	
	

}


//maninApp




package first;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		
	ArrayList<Item> arrList = new ArrayList<>();
	
	Book b1 = new Book(1, "book1", 100.0, "abc", "story", 120);
	Book b2 = new Book(2, "book2", 130.0, "agf", "edu", 400);
	
	Car c1 = new Car(1, "car1", 10000.34, "toyota", "f");
	Car c2 = new Car(2, "car2", 134450.34, "Benz", "s");
	
	arrList.add(b1);
	arrList.add(b2);
	arrList.add(c1);
	arrList.add(c2 );
	
	for (Item item : arrList) {
		item.Display();
		System.out.println(" ");
	}
	
	}

}





/////////////////////////////ArrayList


package paper2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ques1 {
	public static void main(String[] args) {
		
		ArrayList<Integer> number = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numbers :");
		int num;
		while(true) {
			num = sc.nextInt();
			if(num == 0) {
				break;
			}
			number.add(num);
		}
		
		for(int i=0; i < number.size(); i++) {
			if(number.get(i)%2 == 0 ) {
				number.remove(i);
				i--;
			}
		}
		
		System.out.println(number);
	}
	
	
}



//Pair


package paper22;

public class Pair <T,U>{

	T First;
	U Second;
	public Pair(T first, U second) {
		super();
		First = first;
		Second = second;
	}
	public T getFirst() {
		return First;
	}
	public U getSecond() {
		return Second;
	}
	
	
	
}


//package paper22;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pair<String,Integer> p1 = new Pair<>("Test1",42);
		Pair<Double,String> p2 = new Pair<>(34.45,"Test2") ;
		
		System.out.println(p1.getFirst());
		System.out.println(p1.getSecond());
		System.out.println(p2.getFirst());
		System.out.println(p2.getSecond());
		
	}

}





/////////////HashMap

//Book

package Ques03;

public class Book <T,U>{
	
	private T bookTitle;
	private U BookISBN;
	
	public Book(T bookTitle, U bookISBN) {
		super();
		this.bookTitle = bookTitle;
		BookISBN = bookISBN;
	}

	public U getBookISBN() {
		return BookISBN;
	} 

	
}


//Library

package Ques03;

import java.util.HashMap;

public class Library {
	public static void main(String[] args) {
		HashMap<Integer,Book<?,?>> Books = new HashMap<>();
		
		Book<String, String> Book1 = new Book<>("ISBN324","Harry Potter");
		Books.put(1,Book1);
		
		Book<String, Integer> Book2 = new Book<>("Harry Potter",3243);
		Books.put(2,Book2);
		
		for(int id: Books.keySet()) {
			Book<?,?>value = Books.get(id);
			
			System.out.println("Book ID is: " + id + " and the ISBN is" + value.getBookISBN());
	}

	
	}
	
	
	
}
























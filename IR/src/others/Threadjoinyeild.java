package others;


public class Threadjoinyeild {
	public static void main(String[] args) {
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();		
		t2.start();
//
//		try {
//			t.join();//相当于方法调用
//		} 
//		catch (InterruptedException e) {
//			
//		}
	}
}

class MyThread2 implements Runnable {
	public void run() {
		for(int i = 1; i <= 10; i++) {
			if(i % 5 == 0) Thread.yield();
			System.out.println("I am child"+ i );	
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			return;
		}
	}
}
class T1 implements Runnable {
	public void run() {
		for(int i = 1; i < 1000; i++) {	
			System.out.println("T1"+ i );	
		}
	}
}
class T2 implements Runnable {
	public void run() {
		for(int i = 1; i < 1000; i++) {	
			System.out.println("------T2"+ i );	
		}
	}
}

package others;

import java.util.Date;

//r.run();纯方法调用
//start 线程启动 

//被override的方法不能抛出与被override的方法不同的异常
//static的方法可以通过Classname.method 直接取


public class ThreadTest{
	public static void main(String[] args) {
		MyThread r = new MyThread();
		//线程启动 方法2 extends thread 直接r.start();
		//r.start();
		//线程启动 方法1implement runnbale 
		Thread t = new Thread(r);
		t.start();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {}
//		t.interrupt();
		for (int i = 0 ; i < 1000 ; i++) {
			System.out.println("in main thread"+ i);
		}
		//main 一结束 线程就结束
		r.shutDown();
		
	}


}

//1启动线程的两个方法
//class Runner1 extends Thread {
//2 flag结束线程的好的方法 better than interrupt
//class MyThread implements Runnable {
//	public void run() {
//		while(true) {
//			System.out.println("=====" + new Date());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				System.out.println("mythread  interupt");
//				return;
//			}
//		}
//	}
//}

class MyThread implements Runnable {
	public boolean flag = true;
	public void run() {
		int i = 0;
		while(flag) {
			System.out.println("=====" + i++);
		}
	}
	public void shutDown() {
		this.flag = false;
	}
}

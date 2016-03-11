package others;

public class ThreadSync implements Runnable{
	Timmer mytimer = new Timmer();
	public static void main(String[] args) {

		ThreadSync test = new ThreadSync();
		//下面这种写法会产生两个timer 我们要的只是一个
//		Thread t1 = new Thread(new ThreadSync());
//		Thread t2 = new Thread(new ThreadSync());
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);

		t1.setName("t1");
		t2.setName("t2");

		t1.start();

		t2.start();
	}
	@Override
	public void run() {
		mytimer.add(Thread.currentThread().getName());
	}

}

//synchronized的两种写法
class Timmer {
	int num = 0;
	public synchronized void add( String name) {
//	public void add( String name) {
//		synchronized(this) {
			num++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
			System.out.println(name + "you are No." + num);
//		}
	}
}

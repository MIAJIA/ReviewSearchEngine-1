package others;

public class ProducerConsumer {
	public static void main(String[] args){
		SynStack ss = new SynStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(c).start();
		
	}
	
}
class bread {
	int id;
	bread(int id) {
		this.id = id;
	}
	public String toString() {
		return "Bread" + id;
	}
}

class SynStack {
	int index = 0;
	bread[] arrB = new bread[6];
	public synchronized void push(bread b) throws InterruptedException {
		while(index == arrB.length - 1){
			//当前的 正在访问该对象的thread wait； 只有synchronized才有wait
			//wait 时候锁就不在归我所有了； sleep相反
			this.wait();
		}
		this.notify();
		arrB[index] = b;
		index++;
	}
	public synchronized bread pop() throws InterruptedException {
		while(index == 0){
			this.wait();
		}
		this.notify();
		index--;
		return arrB[index];
	}
	
}

class Producer implements Runnable {
	SynStack ss = null;
	Producer(SynStack ss) {
		this.ss = ss;
	}
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			bread b  = new bread(i);
			System.out.println("produce"+ i+"th");
			try {
				ss.push(b);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class Consumer implements Runnable {
	SynStack ss = null;
	Consumer(SynStack ss) {
		this.ss = ss;
	}
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			bread b;
			try {
				b = ss.pop();
				System.out.println("consume"+ i+"th");
				System.out.println(b);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
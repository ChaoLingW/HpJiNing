package com.hpe.java3;

//模拟卖票，三个窗口卖票100

/*
 * 方式二：使用同步方法，被synchronized修饰的方法
 * 将操作共享数据的代码放到一个被synchronized修饰的方法中，这样就可以保证，当一个线程调用此方法时，其他线程无法调用此方法，直到此线程执行完此方法
 * 
 * 使用同步方法的锁：this
 */
class Window4 implements Runnable {

	Object obj = new Object();
	int ticket = 100;

	@Override
	public void run() {

		// 卖票(循环-->票数大于0)
		while (true) {

			boolean res = saleTicket();

			if (!res)
				break;

		}
	}

	public synchronized boolean saleTicket() {
		if (ticket > 0) {
			// 卖票
			System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket);
			ticket--;// 票数减一
		}
		return ticket > 0 ? true : false;
	}
}

public class WindowTest4 {

	public static void main(String[] args) {

		Window2 w = new Window2();

		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		t1.start();
		t2.start();
		t3.start();

	}

}

package com.hpe.java2;

//模拟卖票，三个窗口卖票100

class Window2 implements Runnable{
	
	int ticket = 100;

	@Override
	public void run() {

		//卖票(循环-->票数大于0)
		while(true){
			if(ticket>0){
				//卖票
				System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket);
				ticket--;//票数减一
			}else
				break;
		}
	}
}

public class WindowTest {

	public static void main(String[] args) {

		Window2 w= new Window2();
		
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

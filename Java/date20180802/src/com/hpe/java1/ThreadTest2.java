package com.hpe.java1;

//Thread的常用方法
//1.start()：启动线程并调用相应的run()方法
//2.run():子线程要执行的代码放到run方法中
//3.currentThread(),静态方法，得到当前的线程
//4.getName():获取线程的名字
//5.setName()：设置线程名
//6.yield():调用此方法的线程释放当前CPU的执行权
//7.join():在A线程中调用B线程的join方法，表示当执行到此方法，A线程停止执行，直到B线程完成,A线程再接着join之后的代码执行
//8.isAlive():当前线程是否存活
//9.sleep(long L):让当前线程睡眠L毫秒数
//10.wait(),notify/notifyAll()-->Object
//11.getPriority()-->得到当前线程的优先级
//12.setPriority()-->设置当前线程的优先级（1-10）;默认为5 越大优先级越高-->获取CPU资源的概率越大

//1.创建继承Thread类的子类
class MyThread1 extends Thread {
	
	// 2.重写run()方法，run方法中就是子线程要完成的功能
	@Override
	public void run() {
		
		for (int i = 1; i <= 100; i++) {
			/*try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println(Thread.currentThread().getPriority());
			System.out.println(Thread.currentThread().getName() + ":" + i);
		
		}
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {

		//3.创建Thread子类的对象
		MyThread1 m1 = new MyThread1();
		
		m1.setName("子线程1");//设置线程的名称
		m1.setPriority(10);
		m1.start();//启动子线程，必须调用start();同一个线程只能start一次
		
		Thread.currentThread().setName("主线程");

		for(int i = 1; i <= 100; i++){
			System.out.println(Thread.currentThread().getPriority() + "!");
			System.out.println(Thread.currentThread().getName() + ":" +i);
//			if(i%10 == 0)
//				Thread.currentThread().yield();
		
			/*try {
				if(i == 20)
					m1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		
		}
		//System.out.println(m1.isAlive());
	}

}

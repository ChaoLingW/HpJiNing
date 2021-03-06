package com.hpe.exec;

/*
 * 银行有一个账户
 * 有两个储户分别向同一个账户存3000，每人每次存1000，存3次
 * 每次存完打印账户余额
 */
/*
 * 是否存在多线程：是，有两个储户
 * 有没有共享数据：有，同一个账户
 * 考虑线程同步
 */
//账户
class Account{
	
	//余额
	double balance;
	
	public synchronized void save(double money){
		notify();
		balance += money;
		System.out.println(Thread.currentThread().getName()+":"+balance);
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Customer extends Thread{
	
	Account account;
	
	public Customer(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 3; i++){
			account.save(1000);
		}
	}
	
}

public class AccountTest {

	public static void main(String[] args) {

		Account account = new Account();
		Customer c1 = new Customer(account);
		Customer c2 = new Customer(account);
		
		c1.setName("张三");
		c2.setName("李四");
		
		c1.start();
		c2.start();
		
	}

}

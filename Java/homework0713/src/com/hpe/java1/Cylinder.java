package com.hpe.java1;

/**
 * 
 * @author chaoling
 * @date 2018年7月13日下午5:42:42
 * @Description
 */
/*编写一个圆柱体类Cylinder，它继承于上面的Circle类。还拥有：
①一个成员变量
double hight（私有，浮点型）；  // 圆柱体的高；
②构造方法
Cylinder (double r, double  h )           //创建Circle对象时将半径初始化为r
③ 成员方法
double getVolume( )             //获取圆柱体的体积
void  showVolume( )             //将圆柱体的体积输出到屏幕
编写应用程序，创建类的对象，分别设置圆的半径、圆柱体的高，计算并显示圆半径、圆面积、圆周长，圆柱体的体积。
*/
public class Cylinder extends Circle{
	
	private double hight;	//圆柱体的高

	//将半径初始化为r，高设置为r
	public Cylinder(double r,double h) {
		super(r);
		this.hight = h;
	}
	
	public Cylinder() {
		super();
	}

	public Cylinder(double r) {
		super(r);
	}

	//获取圆柱体的体积
	public double getVolume(){
		return this.getArea()*this.hight;
	}
	
	//输出圆柱体的体积
	public void showVolume(){
		System.out.println("圆柱的体积为：" + this.getVolume());
	}
	
}

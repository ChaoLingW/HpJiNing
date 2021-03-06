package com.hpe.java3;

/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午7:15:43
 * @Description
 */
public class BulletProofDoor extends Door implements BulletSafe{

	@Override
	public void bulletProof() {
		System.out.println("防防弹");
	}

	@Override
	public void open() {
		System.out.println("BulletProofDoor open");
	}

	@Override
	public void close() {
		System.out.println("BulletProofDoor close");
	}
}

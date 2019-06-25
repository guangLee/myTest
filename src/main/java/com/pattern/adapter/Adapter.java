package com.pattern.adapter;

/**
 * 适配器 (类适配器方式)
 * (相当于usb和ps/2的转接器)
 * @author Administrator
 *
 * Java是单继承的，所以继承这种写法不好，会导致该类无法再继承别的类
 *
 * Adapter2 采用构造器引用的方法比较好
 *
 */
public class Adapter extends Adaptee implements Target {
	
	
	@Override
	public void handleReq() {
		super.request();
	}
	
}

package com.pattern.templatemethod;

/**
 * 抽象类的存在就是为了这个 模板方法模式，
 * 开发四五年了，才知道这个，真实白活了这些年，哈哈
 */
public class Client {
	public static void main(String[] args) {
		BankTemplateMethod btm = new DrawMoney();
		btm.process();
		
		//采用匿名内部类
		BankTemplateMethod btm2 = new BankTemplateMethod() {
			
			@Override
			public void transact() {
				System.out.println("我要存钱！");
			}
		};
		btm2.process();
		
		BankTemplateMethod btm3 = new BankTemplateMethod() {
			@Override
			public void transact() {
				System.out.println("我要理财！我这里有2000万韩币");
			}
		};
		
		btm3.process();
		
	}
}



class DrawMoney extends BankTemplateMethod {

	@Override
	public void transact() {
		System.out.println("我要取款！！！");
	}
	
}

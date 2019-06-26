package com.pattern.templatemethod;

public abstract class BankTemplateMethod {
	//具体方法
	public void takeNumber(){
		System.out.println("取号排队");
	}

	//办理具体的业务	//钩子方法
	public abstract void transact();
	
	public void evaluate(){
		System.out.println("反馈评分");
	}

	/**
	 * 模板方法！！！
	 * final关键字很重要，说明该方法不能被子类重写
	 * 从而保重子类在执行此方法时，会用父类的
	 */
	public final void process(){
		this.takeNumber();

		this.transact();

		this.evaluate();
	}
	
}

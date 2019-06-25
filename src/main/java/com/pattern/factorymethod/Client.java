package com.pattern.factorymethod;

/**
 * 奥迪和比亚迪，为他们分别创建一个工厂，继承自汽车工厂
 *
 * 后期，又来了一辆奔驰，那么不需要修改原来的工厂代码，只要新增一个奔驰工厂就可以了
 *
 * 相比于“简单工厂模式”，工厂方法把工厂又抽象了一层，一个总的工厂下面，有很多不同的专门工厂
 *
 * 工厂方法模式 缺点就是，类变多了
 */
public class Client {
	public static void main(String[] args) {
		Car c1 = new AudiFactory().createCar();
		Car c2 = new BydFactory().createCar();
		
		c1.run();
		c2.run();
	}
}

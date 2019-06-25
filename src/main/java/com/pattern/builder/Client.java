package com.pattern.builder;

/**
 * 我们要建造一个复杂的产品，需要装配很多子组件，有很多步骤需要处理
 *
 * 分离了对象子组件的单独构造（Builder）和装配（Director），从而可以构造出复杂的对象，
 *
 * 建造模式：某个对象的构建过程复杂的情况下使用
 *
 * 由于实现了构建和装配的解耦，不同的构建器，相同的装配，也可以做出不同的对象，
 *
 * 相同的构建器，不同的装配顺序，也可以做出不同的对象，
 *
 * 也就是实现了构建算法，装配算法的解耦，实现了更好的复用
 *
 *
 */
public class Client {
	public static void main(String[] args) {
		
		AirShipDirector director = new SxtAirshipDirector(new SxtAirShipBuilder());

		AirShip ship = director.directAirShip();
		
		System.out.println(ship.getEngine().getName());
		
		ship.launch();
	}
}
package com.huaxia.designpattern.factory;

public class FactoryPatternTester {

	public static void main(String[] args) {
		Computer computer = ComputerFactory.getComputer("PC", "8G", "500G", "intel i7");
		System.out.println(computer instanceof PC);
		System.out.println(computer instanceof Server);
		System.out.println(computer.getClass().getName());

		computer = ComputerFactory.getComputer("com.huaxia.designpattern.factory.Server");
		System.out.println(computer.getClass().getName());
	}
}

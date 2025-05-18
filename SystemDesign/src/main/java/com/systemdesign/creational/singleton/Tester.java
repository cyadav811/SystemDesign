package com.systemDesign.creational.singleton;

public class Tester {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = DataBaseConnection.getInstance();
		
		DataBaseConnection dbConnection2 = DataBaseConnection.getInstance();
		
		DataBaseConnection dbConnection3 = DataBaseConnection.getInstance();
		
		
		System.out.println(dbConnection.hashCode()+" "+dbConnection2.hashCode()+ " "+dbConnection3.hashCode());
		
		Singleton sig = Singleton.INSTANCE;
		sig.doSomething();
	}
}
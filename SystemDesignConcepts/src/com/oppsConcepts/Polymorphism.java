package com.oppsConcepts;

public class Polymorphism {
	
	public static void main(String[] args) {
		Student p1 = new Student();
		
		//This willl give a compile time error because in both the overloaded methods 
		// null can be passed and due to that the compiler is confused 
		// Method overloading is compile time  polymorphism. 
		//p1.create(null); 
		
		// Creation of the object is done at the runtime that's why it is runtime polymorphism....
		// if we are overriding a method then in such a condition it will be a runtime polymorphism. 
		
		Person p2 = new Professor();
		//  this method will work fine because the at runtime the parent object is preferred and gives.
		// the parent class implementation and this method is not overriden. 
		p2.create(null);
		
		//If we override a method then the method in the parent class is erased ( or there is no use 
		// of the method till we create an object of the parent class itself. )
		
		//Method overriding is runtime polymorphism...
		
	}

}

class Person{
	private String name;
	private String email;
	private String phoneNumber;
	
	public void create(Long o) {
		System.out.println("NO");
	}
	
}

class Student extends Person{
	
	
	public void create(Long o) {
		System.out.println("NO");
	}
	
	public void create(String o) {
		System.out.println("Yes");
	}
}
class Professor extends Person{
	
	
	public void create(String o) {
		System.out.println("Yes");
	}
}
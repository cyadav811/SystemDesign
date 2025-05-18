package com.systemDesign.solidprinciples;


/*
 * The Liskov Substitution Principle is one of the SOLID principles of object-oriented design,
 * introduced by Barbara Liskov. According to this principle, objects of a superclass should be
 * replaceable with objects of a subclass without affecting the correctness of the program. 
 * This means that the subclass should extend the capabilities of the superclass, not break them.
 *   
 *  1. The derived class should enhance the functionality of the base class.
    2. The subclass should not remove behavior that is expected by the base class.
     3. The client code should be able to use a subclass object just like a superclass object 
     without knowing the difference.
     
     Runtime polymorphism (method overriding) is closely related to the Liskov Substitution Principle.
     When we override a method in a subclass, we should ensure that the subclass can be used interchangeably
     with the superclass without altering the behavior expected by the superclass.
 */
public class LiskovSubstitution {

	  public static void main(String[] args) {
	        Bird bird = new Sparrow();
	        bird.fly();  // This works as expected

	        bird = new Ostrich();
	        bird.fly();  // This throws an exception, violating LSP
	    }
}


class Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    @Override
    void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends Bird {
    @Override
    void fly() {
        // Violation of Liskov Substitution Principle
        throw new UnsupportedOperationException("Ostrich can't fly");
        }
    }

/*
 * In this example, the Ostrich class violates the Liskov Substitution Principle because an Ostrich 
 * cannot fly, whereas the base class Bird expects all birds to fly. Thus, replacing a Bird object with
 *  an Ostrich object can break the program.
 */
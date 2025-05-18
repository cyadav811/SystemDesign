package com.systemdesign.solidprinciples;


public class Assignment {
    public static void main(String[] args) {
        Dog dog = new Dog(new FastWalking(), new FastSpeaking());
        dog.walk();
        dog.speak();
        
        Peacock peacock = new Peacock(new SlowWalking(), new SlowSpeaking(), new Fly());
        peacock.walk();
        peacock.speak();
        peacock.fly();
        
        Fish fish = new Fish(new Swim());
        fish.swim();
        
        Frog frog = new Frog(new FastWalking(), new SlowSpeaking(), new Swim());
        frog.walk();
        frog.speak();
        frog.swim();
    }
}

class Animal{
    private String name;
    private String weight;
    private String colour;

    // Constructor, getters, and setters omitted for brevity.
}

class Dog extends Animal {
    private WalkingBehaviour walkingBehaviour;
    private SpeakingBehaviour speakingBehaviour;

    public Dog(WalkingBehaviour walkingBehaviour, SpeakingBehaviour speakingBehaviour) {
        this.walkingBehaviour = walkingBehaviour;
        this.speakingBehaviour = speakingBehaviour;
    }

    public void walk() {
        walkingBehaviour.walk();
    }

    public void speak() {
        speakingBehaviour.speak();
    }
}

class Peacock extends Animal {
    private WalkingBehaviour walkingBehaviour;
    private SpeakingBehaviour speakingBehaviour;
    private FlyingBehaviour flyingBehaviour;

    public Peacock(WalkingBehaviour walkingBehaviour, SpeakingBehaviour speakingBehaviour, FlyingBehaviour flyingBehaviour) {
        this.walkingBehaviour = walkingBehaviour;
        this.speakingBehaviour = speakingBehaviour;
        this.flyingBehaviour = flyingBehaviour;
    }

    public void walk() {
        walkingBehaviour.walk();
    }

    public void speak() {
        speakingBehaviour.speak();
    }

    public void fly() {
        flyingBehaviour.fly();
    }
}

class Fish extends Animal {
    private SwimmingBehaviour swimmingBehaviour;

    public Fish(SwimmingBehaviour swimmingBehaviour) {
        this.swimmingBehaviour = swimmingBehaviour;
    }

    public void swim() {
        swimmingBehaviour.swim();
    }
}

class Frog extends Animal {
    private WalkingBehaviour walkingBehaviour;
    private SpeakingBehaviour speakingBehaviour;
    private SwimmingBehaviour swimmingBehaviour;

    public Frog(WalkingBehaviour walkingBehaviour, SpeakingBehaviour speakingBehaviour, SwimmingBehaviour swimmingBehaviour) {
        this.walkingBehaviour = walkingBehaviour;
        this.speakingBehaviour = speakingBehaviour;
        this.swimmingBehaviour = swimmingBehaviour;
    }

    public void walk() {
        walkingBehaviour.walk();
    }

    public void speak() {
        speakingBehaviour.speak();
    }

    public void swim() {
        swimmingBehaviour.swim();
    }
}

interface WalkingBehaviour {
    void walk();
}

class SlowWalking implements WalkingBehaviour {
    @Override
    public void walk() {
        System.out.println("Animal is having a Slow walking behaviour");    
    }   
}

class FastWalking implements WalkingBehaviour {
    @Override
    public void walk() {
        System.out.println("Animal is having a fast walking behaviour");    
    }   
}

interface SpeakingBehaviour {
    void speak();
}

class SlowSpeaking implements SpeakingBehaviour {
    @Override
    public void speak() {
        System.out.println("Slow speaking animal"); 
    }
}

class FastSpeaking implements SpeakingBehaviour {
    @Override
    public void speak() {
        System.out.println("Fast speaking animal"); 
    }
}

interface FlyingBehaviour {
    void fly();
}

class Fly implements FlyingBehaviour {
    @Override
    public void fly() {
        System.out.println("Animal can fly");   
    }   
}

interface SwimmingBehaviour {
    void swim();
}

class Swim implements SwimmingBehaviour {
    @Override
    public void swim() {
        System.out.println("Animal can swim");  
    }   
}

/*
 * Single Responsibility Principle (SRP): Each class has a single responsibility. The Animal subclasses
 *  don't need to manage their own behavior logic; they delegate it to behavior classes.

Open/Closed Principle (OCP): Classes are open for extension but closed for modification. You can add
 new behaviors without changing the existing classes. For example, if you need a new type of walking
  behavior, you just create a new class that implements the WalkingBehaviour interface.

Interface Segregation Principle (ISP): Classes depend on small, specific interfaces rather than
 one large interface. This avoids forcing classes to implement methods they don’t need.

Dependency Inversion Principle (DIP): High-level modules (like Dog, Peacock, Fish, etc.) do not depend
 on low-level modules (specific behaviors) directly. Instead, they depend on abstractions (interfaces),
  making the system more flexible and easier to maintain.

Flexibility and Testability: By using dependency injection, you can easily swap out behavior
 implementations without changing the classes. This makes the system highly flexible and easy to test,
  as you can inject mock behaviors for testing purposes.
 */


// In this implementation we are overriding the methods for every animal for example if 
// two animals is having exactly same behavior then in such a condition we are rewriting the code 
// again and again...
/*
 * Lack of Flexibility: In this code, the behaviors like walk(), fly(), etc., are hardcoded within
 *  the animal classes (Dog, Peacock, etc.). This makes it difficult to change the behavior without modifying
 *   the class itself.

Violation of the Interface Segregation Principle (ISP): Some classes were forced to implement interfaces 
they didn't need. For example, Fish implements SwimingBehaviour but was incorrectly forced to implement
 fly(). This is a clear violation of ISP, which states that no client should be forced to depend on methods
  it does not use.

Difficult to Extend: If you wanted to add a new behavior or modify an existing one, you would have to change
 the existing classes. This approach goes against the Open/Closed Principle (OCP), which states that classes
  should be open for extension but closed for modification.

Hard to Test: Hardcoding behaviors makes it difficult to unit test classes in isolation. You'd need to test
 the entire class along with all its behaviors, which isn't efficient or effective.

By using dependency injection and smaller interfaces, you achieve:
 */

/*
public class Assignment {

public static void main(String[] args) {
	
}
}

class Animal{

// physical attributes that we have to use in the case of the animal and we 
// can use them in subclasses for avoiding rewriting the same code. 
private String name;
private String weight;
private String colour;
}

class Dog extends Animal implements WalkingBehaviour,SpeakingBehaviour {

@Override
public void speak() {
	// TODO Auto-generated method stub
	
}

@Override
public void walk() {
	// TODO Auto-generated method stub
	
}

}

class Picock extends Animal implements WalkingBehaviour,SpeakingBehaviour,FlyingBehaviour {

@Override
public void speak() {
	
}

@Override
public void walk() {
}

@Override
public void fly() {
	// TODO Auto-generated method stub
	
}

}

class Fish extends Animal implements SwimingBehaviour {

@Override
public void fly() {
	// TODO Auto-generated method stub
	
}

}

class Frog extends Animal implements SwimingBehaviour,WalkingBehaviour,SpeakingBehaviour{

@Override
public void speak() {
	// TODO Auto-generated method stub
	
}

@Override
public void walk() {
	// TODO Auto-generated method stub
	
}

@Override
public void fly() {
	// TODO Auto-generated method stub
	
}

}


interface WalkingBehaviour{
public void walk() ;
}

class SlowWalking implements  WalkingBehaviour{
@Override
public void walk() {
	System.out.println("Animal is having a Slow walking behaviour");	
}	
}

class FastWalking implements WalkingBehaviour{
@Override
public void walk() {
	System.out.println("Animal is having a fast walking behaviour");	
}	
}

interface SpeakingBehaviour{
public void speak();
}
class SlowSpeaking implements SpeakingBehaviour{
@Override
public void speak() {
	System.out.println("Slow speaking animal");	
}
}

class FastSpeaking implements SpeakingBehaviour{
@Override
public void speak() {
	System.out.println("Fast speaking animal");	
}
}

interface FlyingBehaviour{
public void fly();
}

class Fly implements FlyingBehaviour{
@Override
public void fly() {
	System.out.println("Animal can fly");	
}	
}


interface SwimingBehaviour{
public void fly();
}

class Swim implements SwimingBehaviour{
@Override
public void fly() {
	System.out.println("Animal can Swim");	
}	
}*/
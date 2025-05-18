package com.systemDesign.creational.singleton;

public class DataBaseConnection {
	
	//Eager Initialization
	//private static DataBaseConnection databaseConnection= new DataBaseConnection();
	
	private static DataBaseConnection instance;
	
	private DataBaseConnection() {}
	
//	public static DataBaseConnection getInstance() {
//		if(instance==null) {
//			//Lazy Initialization
//			instance =new DataBaseConnection();
//			return instance;
//		}
//		else return instance;
//	}
	
//	//thread safe singleton Structure
//	public static synchronized DataBaseConnection getInstance() {
//		if(instance==null) {
//			//Lazy Initialization
//			instance =new DataBaseConnection();
//			return instance;
//		}
//		else return instance;
//	}
	
	//Double-Checked Locking
	//This method reduces the overhead of acquiring a lock by first checking the instance without synchronization.
	 public static DataBaseConnection getInstance() {
	        if (instance == null) {
	            synchronized (DataBaseConnection.class) {
	                if (instance == null) {
	                    instance = new DataBaseConnection();
	                }
	            }
	        }
	        return instance;
	    }
}



//This is the most effective way of implementing Singleton as it provides serialization mechanism out of the box.
//The enum Singleton in Java inherently provides a thread-safe and effective way to ensure a single instance
enum Singleton {
    INSTANCE;

    // You can add your methods here
    public void doSomething() {
        // Initialization code here
    }
}

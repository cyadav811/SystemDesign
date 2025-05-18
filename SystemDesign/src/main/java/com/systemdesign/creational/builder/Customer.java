package com.systemDesign.creational.builder;

public class Customer {
	
	
	private final String name;
	private final String email;
	private final Integer id;
	
	private Customer(Builder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.id = builder.id;
	}
	
	public class Builder {
		
		private  String name;
		private  String email;
		private  Integer id;
		
		
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
	
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		public Customer build() {
           
			return new Customer(this);
			
		}
		
	}
	
	
	public static void main(String... args) {
		 Customer cust = new Customer.Builder()
	                .setEmail("dd")
	                .setId(111)
	                .setName("chandra")
	                .build(); 
	}

}

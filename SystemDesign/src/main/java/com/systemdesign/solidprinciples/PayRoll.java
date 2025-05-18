package com.systemdesign.solidprinciples;

import java.util.Map;
import java.util.HashMap;

public class PayRoll {

	
	
}




interface TaxConfig{
	public Map<String,Double> getTaxPercentage();
	
}

class TaxConfigImpl implements TaxConfig{

	@Override
	public Map<String, Double> getTaxPercentage() {
		Map<String,Double> taxPercentage = new HashMap<>();
		
		taxPercentage.put("Permanent.GST", 0.18);
		taxPercentage.put("Permanent.STATE", 0.09);
		
		
		return taxPercentage;
	}
	
}



interface TaxCal{
	
	public double calculateTax(Employe emp);
}
class PartTimeTaxCal implements TaxCal{

	@Override
	public double calculateTax(Employe emp) {
		double salary = emp.getSalary();
		return 0.0;
		
		 
	}
	
}

class Employe{
	private String name;
	private String email;
	private double salary;
	
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employe(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

class PartTime extends Employe{
	
	public PartTime(String name, String email) {
		super(name,email);
		
	}
}
class FullTime extends Employe{
	public FullTime(String name, String email) {
		super(name,email);
		
	}
}

class InternEmp extends Employe{
	public InternEmp(String name, String email) {
		super(name,email);
		
	}
}
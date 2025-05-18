package com.systemdesign.solidprinciples;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

// Main Payroll Management System class
public class PayRollManagementSystem {
    public static void main(String[] args) {
        TaxCalculatorFactory taxCalculatorFactory = new TaxCalculatorFactory(new InMemoryTaxConfiguration());

        Employee partTimeEmployee = new PartTimeEmployee("John Doe", "john@example.com", "PT123", 3000);
        Employee permanentEmployee = new PermanentEmployee("Jane Doe", "jane@example.com", "PE123", 5000);
        Employee intern = new Intern("Tom Smith", "tom@example.com", "IN123", 1000);

        TaxCalculator partTimeTaxCalculator = taxCalculatorFactory.getTaxCalculator(partTimeEmployee);
        TaxCalculator permanentTaxCalculator = taxCalculatorFactory.getTaxCalculator(permanentEmployee);
        TaxCalculator internTaxCalculator = taxCalculatorFactory.getTaxCalculator(intern);

        System.out.println("Part-Time Employee In-Hand Salary: " + partTimeEmployee.calculateInHandSalary(partTimeTaxCalculator));
        System.out.println("Permanent Employee In-Hand Salary: " + permanentEmployee.calculateInHandSalary(permanentTaxCalculator));
        System.out.println("Intern In-Hand Salary: " + intern.calculateInHandSalary(internTaxCalculator));
    }
}

// Configuration interface to hold tax rates
interface TaxConfiguration {
    double getTaxRate(String taxType, String employeeType);
}

// In-memory implementation of TaxConfiguration
class InMemoryTaxConfiguration implements TaxConfiguration {
    private static final Map<String, Double> taxRates = new HashMap<>();

    static {
        // Configure tax rates here
        taxRates.put("ProfessionalTax.PartTime", 0.10);
        taxRates.put("ProfessionalTax.Permanent", 0.15);
        taxRates.put("ProfessionalTax.Intern", 0.05);
        taxRates.put("ProfessionalTax.OnContract", 0.15);

        taxRates.put("EducationalTax.PartTime", 0.02);
        taxRates.put("EducationalTax.Permanent", 0.02);
        taxRates.put("EducationalTax.Intern", 0.0); // No educational tax for interns
        taxRates.put("EducationalTax.OnContract", 0.02);

        taxRates.put("StateTax.PartTime", 0.0); // No state tax for part-time employees
        taxRates.put("StateTax.Permanent", 0.03);
        taxRates.put("StateTax.Intern", 0.03);
        taxRates.put("StateTax.OnContract", 0.0);

        taxRates.put("GST.PartTime", 0.18);
        taxRates.put("GST.Permanent", 0.18);
        taxRates.put("GST.Intern", 0.0); // No GST for interns
        taxRates.put("GST.OnContract", 0.18);
        
        
    }

    @Override
    public double getTaxRate(String taxType, String employeeType) {
        return taxRates.getOrDefault(taxType + "." + employeeType, 0.0);
    }
}

// Abstract Employee class
abstract class Employee {
    private String name;
    private String email;
    private String id;
    private double salary;

    public Employee(String name, String email, String id, double salary) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateInHandSalary(TaxCalculator taxCalculator) {
        double totalTax = taxCalculator.calculateTax(this);
        return salary - totalTax;
    }
}

// Concrete employee classes
class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, String email, String id, double salary) {
        super(name, email, id, salary);
    }
}

class PermanentEmployee extends Employee {
    public PermanentEmployee(String name, String email, String id, double salary) {
        super(name, email, id, salary);
    }
}

class Intern extends Employee {
    public Intern(String name, String email, String id, double salary) {
        super(name, email, id, salary);
    }
}

// TaxCalculator interface
interface TaxCalculator {
    double calculateTax(Employee employee);
}



// Abstract TaxCalculator class to avoid duplicacy
abstract class AbstractTaxCalculator implements TaxCalculator {
    private TaxConfiguration taxConfiguration;

    public AbstractTaxCalculator(TaxConfiguration taxConfiguration) {
        this.taxConfiguration = taxConfiguration;
    }

    @Override
    public double calculateTax(Employee employee) {
        double salary = employee.getSalary();
        double professionalTax = salary * taxConfiguration.getTaxRate("ProfessionalTax", getEmployeeType());
        double educationalTax = salary * taxConfiguration.getTaxRate("EducationalTax", getEmployeeType());
        double stateTax = salary * taxConfiguration.getTaxRate("StateTax", getEmployeeType());
        double gst = salary * taxConfiguration.getTaxRate("GST", getEmployeeType());
        return professionalTax + educationalTax + stateTax + gst;
    }

    protected abstract String getEmployeeType();
}

// Concrete tax calculator classes
class PartTimeTaxCalculator extends AbstractTaxCalculator {
    public PartTimeTaxCalculator(TaxConfiguration taxConfiguration) {
        super(taxConfiguration);
    }

    @Override
    protected String getEmployeeType() {
        return "PartTime";
    }
}

class OnContractTaxCalculator extends AbstractTaxCalculator{

	public OnContractTaxCalculator(TaxConfiguration taxConfiguration) {
		super(taxConfiguration);
	}

	@Override
	protected String getEmployeeType() {
		return "OnContract";
	}
	
}

class PermanentTaxCalculator extends AbstractTaxCalculator {
    public PermanentTaxCalculator(TaxConfiguration taxConfiguration) {
        super(taxConfiguration);
    }

    @Override
    protected String getEmployeeType() {
        return "Permanent";
    }
}

class InternTaxCalculator extends AbstractTaxCalculator {
    public InternTaxCalculator(TaxConfiguration taxConfiguration) {
        super(taxConfiguration);
    }

    @Override
    protected String getEmployeeType() {
        return "Intern";
    }
}

// Factory Pattern to create TaxCalculator instances
class TaxCalculatorFactory {
    private TaxConfiguration taxConfiguration;

    public TaxCalculatorFactory(TaxConfiguration taxConfiguration) {
        this.taxConfiguration = taxConfiguration;
    }

    public TaxCalculator getTaxCalculator(Employee employee) {
        if (employee instanceof PartTimeEmployee) {
            return new PartTimeTaxCalculator(taxConfiguration);
        } else if (employee instanceof PermanentEmployee) {
            return new PermanentTaxCalculator(taxConfiguration);
        } else if (employee instanceof Intern) {
            return new InternTaxCalculator(taxConfiguration);
        } else {
            throw new IllegalArgumentException("Unknown employee type");
        }
    }
}

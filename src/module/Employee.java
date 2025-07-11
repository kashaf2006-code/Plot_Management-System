package module;

import java.security.PublicKey;

public class Employee {
	    private String firstName;
	    private String lastName;
	    private int salary;
	    private String cnic;
	    private String designation;
        private int empID;//unique id for file serching anf filtering
	    // Constructor with only required fields
	    public Employee(String firstName, String lastName, int salary, String designation, int empID) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.salary = salary;
	        this.designation = designation;
	        this.empID=empID;
	    }

	    // Getters
	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public int getSalary() {
	        return salary;
	    }

	    public String getCnic() {
	        return cnic;
	    }

	    public String getDesignation() {
	        return designation;
	    }
	    public int getempID() {
	        return empID;
	    } 

	    // Setters
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }

	    public void setCnic(String cnic) {
	        this.cnic = cnic;
	    }

	    public void setDesignation(String designation) {
	        this.designation = designation;
	 
	      	    }  
	    public void setempID(int empID) {
	        this.empID=empID;
	    }
	    //some important mehtods
	        
	        //update salary
	    public void updateSalary(int newsalary) {
	    	this.salary=newsalary;
	    	System.out.println("The salary has been updated to "+newsalary);
	    }
	    // method to add CNIC or other Additional information for future
	    public void addAdditionalInfo(String cnic) {
	   this.cnic = cnic;
	   System.out.println("The cnic is added successfully");
	    }


//display Info
	    @Override
	    public String toString() {
	        return "Employee: " + firstName + " " + lastName +
	               "\nSalary: " + salary +
	               "\nDesignation: " + designation +
	               "\nCNIC: " + cnic;
	    }

		
}



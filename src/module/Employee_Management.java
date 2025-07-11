package module;
import java.util.ArrayList;

public class Employee_Management {
// this class will contain the objects of employee class and all related mehotds
private	 ArrayList<Employee> employeeobj=   new ArrayList<Employee>();// this array list will contain all the objects of employee class
// getter method for accesing employeeobj
public ArrayList<Employee> getAllEmployees() {
    return employeeobj;
}

boolean empyee_added=false;// check if employee is added succesfully
	
	FileHandling empFileHandler;
 
	//now creating a constuctor of employee management so that whenever it's open it restorre all data from file into array list
	public Employee_Management() {
		//creating object of FileHandling
	 empFileHandler= new FileHandling();
	
	//this will make file data store in array
	employeeobj=empFileHandler.readFromFile();
}
	
	public boolean addEmployee(String f_name, String l_name, int salary, String designation, int uniqueID) {
	    for (Employee emp : employeeobj) {//so we are using for loop ofr accesing arraylist
		if (emp.getempID()==uniqueID) {
	   	//	System.out.println("The employee already exist");
	   	return empyee_added=false;
	   	}}
	   
			Employee employees= new Employee(f_name, l_name, salary, designation, uniqueID);
			employeeobj.add(employees);//adding the employee in my arraylist
			//now adding object data into file
		      empFileHandler.AddtotheFile(employees, true);
		      
			return empyee_added=true;
	}
	// deleting method
    public void delEmployee(String f_name, String l_name, int uniqueID) {
        boolean removed = employeeobj.removeIf(emp ->
            emp.getFirstName().equalsIgnoreCase(f_name) &&
            emp.getLastName().equalsIgnoreCase(l_name) &&
            emp.getempID() == uniqueID
            
        );
        if (removed) {
            System.out.println("The employee has been removed.");
            empFileHandler.UpdateTotheFile(employeeobj, false);
        } else {
            System.out.println("Employee not found.");
        }
    }
           //function to search the loop
	   public Employee searchEmployee(int uniqueid, String f_name) {
		   for (Employee emp : employeeobj) {
		    	if (emp.getFirstName().equalsIgnoreCase(f_name) && (emp.getempID() == uniqueid)) {
System.out.println("The employee is found");
// this will display all the information related to that employee 
return emp;
		}
		    }
					System.out.println("Employee is not found");
					return null;}

	    // function to list all employees
	    public void listEmployee() {
	        if (employeeobj.isEmpty()) {
	            System.out.println("No employees found.");
	        } else {
	            System.out.println("List of Employees:");
	            for (Employee emp : employeeobj) {
	                System.out.println(emp.toString());
	                System.out.println("-------------------------");
	            }
	        }
	    }			
	    public void upgradingInfo(String designation, int salary, int uniqueid) {
	        Employee foundEmployee = null;

	        // Search for the employee by ID
	        for (Employee emp : employeeobj) {
	            if (emp.getempID() == uniqueid) {
	                foundEmployee = emp;
	                break;  // We found the employee, no need to continue loop
	            }
	        }

	        if (foundEmployee != null) {
	            System.out.println("The employee is found. Updating info...");
	            foundEmployee.setDesignation(designation);
	            foundEmployee.setSalary(salary);
	            System.out.println("Update successful.");
	            
	            //now passing our information or updated arraylist again to file mehtod to update it
	            empFileHandler.UpdateTotheFile(employeeobj, false);

	            
	        } else {
	            System.out.println("Employee not found.");
	        }
	    }

}	   
	   
	   

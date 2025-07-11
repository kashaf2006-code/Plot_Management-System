package module;
import java.time.LocalDate;

public class Expense {
    private String generalExpense;     // e.g., "Salary", "Food"
    private double amount;
    private LocalDate date;
    private String description;
    private String employeeId;         // optional: only for salary

    public Expense(String generalExpense, double amount, LocalDate date, String description) {
  
    	this.generalExpense = generalExpense;
        this.amount = amount;
        this.date = date;
        this.description = description;
       
        this.employeeId = null;  // optional field
        
    }

    public Expense( String generalExpense, double amount, LocalDate date, String description, String employeeId) {
        this(generalExpense, amount, date, description);
        this.employeeId = employeeId;
    }
   

    public String getGeneralExpense() {
        return generalExpense;
    }

    public void setGeneralExpense(String generalExpense) {
        this.generalExpense = generalExpense;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
  
   
}


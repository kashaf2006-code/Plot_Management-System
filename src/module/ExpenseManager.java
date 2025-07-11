package module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {
	//creating total amount to set  the complete record of expense
	private double totalExpense=0;  
	public void setTotalExpense(double totalExpense) {
			this.totalExpense=totalExpense;
		}

	    public double getTotalExpense() {
	        return totalExpense;
	    }
    //scanner object
    Scanner sc = new Scanner(System.in);
    // first creating arraylist that will store the expense class objects
    ArrayList<Expense> expenselist;
    FileHandling_2 expenseFileHandling_2;

    public ExpenseManager() {
        expenselist = new ArrayList<>();
        // THis is the object of filehandling
        expenseFileHandling_2 = new FileHandling_2();
        expenselist = expenseFileHandling_2.loadExpenses(); // ✅ Load expenses when app starts
    }

    // feature to add expense
    public boolean addExpense(Expense e) {
        expenselist.add(e);
        // we have to write it in file
        expenseFileHandling_2.addExpensetotheFile(e);
        return true;
    }

    public boolean delExpense(String exptype, double amount, LocalDate date) {
        for (int i = 0; i < expenselist.size(); i++) {
            Expense e = expenselist.get(i);
            if ((e.getGeneralExpense().equalsIgnoreCase(exptype) && e.getDate()==date)||(e.getAmount()==amount)) {
                expenselist.remove(i);
                System.out.println("Expense deleted.");
                expenseFileHandling_2.saveAllExpense(expenselist, false);
                return true;
            }
        }
        System.out.println("Expense not found.");
        return false;
    }
public int index=0;
    // method to display all expense to user
    public ArrayList<Expense> displayAllExpenses() {
        // first checking if expense is not empty
        if (expenselist.isEmpty()) {
            System.out.println("No expenses recorded.");
            return expenselist;
        }

        System.out.printf("%-6s %-15s %-10s %-12s %-25s %-10s%n",
            "Index", "Type", "Amount", "Date", "Description", "Emp ID");

		for (int i = 0; i < expenselist.size(); i++) {
            Expense e = expenselist.get(i);  
            System.out.printf("%-6d %-15s %-10.2f %-12s %-25s %-10s%n",
                i,
                e.getGeneralExpense(),
                e.getAmount(),
                e.getDate(),
                e.getDescription(),
                e.getEmployeeId() == null ? "" : e.getEmployeeId());
        totalExpense+=e.getAmount();
        }
        System.out.println("Total Expense is:"+totalExpense);
        return expenselist;
    }

    public boolean updateExpense(int index, Expense newExpense) {
        if (index >= 0 && index < expenselist.size()) {
            expenselist.set(index, newExpense);
            System.out.println(index);
            expenseFileHandling_2.saveAllExpense(expenselist, false);
            return true;
        }
        return false;
    }

    // public Expense getExpenseBySerial(int index) {
    //     for (Expense e : expenselist) {
    //         if (e.getSerialNo() == serialNo) {
    //             System.out.println(e);
    //             return e;
    //         }
    //     }
    //     return null;
    // }

 // In ExpenseManager.java
    public void deleteAllExpense() {
        expenselist.clear();// completly delete the file
        expenseFileHandling_2.saveAllExpense(expenselist, false);
    }
    
}

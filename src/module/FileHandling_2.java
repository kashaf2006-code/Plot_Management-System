package module;

import java.io.*;
import java.lang.classfile.BufWriter;
import java.security.PublicKey;
import java.security.DrbgParameters.NextBytes;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.event.TreeWillExpandListener;

public class FileHandling_2 {
    private File expenseRecord = new File("ExpenseRecord.csv");

    public FileHandling_2() {
    	//checking if the file exist if not then created
        try {
            if (expenseRecord.exists()) {
                System.out.println("The file " + expenseRecord.getName() + " already exists.");
            } else {
                if (expenseRecord.createNewFile()) {
                    System.out.println("File created: " + expenseRecord.getName());
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(expenseRecord))) {
                        bw.write("Expense Type,Amount,Date,Description,EmployeeId");
                        bw.newLine();
                    }
                } else {
                    System.out.println("Failed to create the file.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while initializing the expense file.");
            e.printStackTrace();
        }
}
    //method to read or load the file of expense when the app starts
 // method to read or load the file of expense when the app starts
    public ArrayList<Expense> loadExpenses() {
        ArrayList<Expense> expenselist = new ArrayList<>(); // list to store all expenses

        try (BufferedReader br = new BufferedReader(new FileReader(expenseRecord))) {
            String linedata;

            while ((linedata = br.readLine()) != null) {
                // Skip empty lines
                if (linedata.trim().isEmpty())
                    continue;

                // case sensitivity and flexibility and skipping of header row
                if (linedata.startsWith("Expense Type"))
                    continue;

                // Split line into fields
                String[] fields = linedata.split(",", -1);  // ✅ Fix: keep empty fields like ""

                try {
                    // skipping uncomplete lines or currupted lines
                	if (fields.length != 5) {
                        System.out.println("Skipping invalid or incomplete line: " + linedata);
                        continue;
                    }
                     
                    String generalExpense = fields[0].trim();         // expense type
                    double amount = Double.parseDouble(fields[1].trim());//amount
                    LocalDate date =LocalDate.parse(fields[2].trim());                   // date as string (can convert to LocalDate later)
                    String description = fields[3].trim();            // expense description
                    String empId = fields[4].trim();   // employee ID

                    // add the expense object to list (constructor order must match CSV)
                    Expense exp = new Expense(generalExpense, amount, date, description, empId);
                    expenselist.add(exp);
                 System.out.println("The file has succesfully loaded.");
                 

                } catch (Exception e) {
                    // handle any parsing or conversion issues
                    System.out.println("Error processing line: " + linedata);
                }
            }

        } catch (Exception e) {
            // handle file reading errors
            System.out.println("Error reading the expense file.");
            e.printStackTrace();
        }

        return expenselist;
    }
    public void addExpensetotheFile(Expense expense) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.expenseRecord, true))) {
            // Write the new expense in CSV format
            bw.write(
                expense.getGeneralExpense() + "," +
                expense.getAmount() + "," +
                expense.getDate() + "," +
                expense.getDescription() + "," +
                (expense.getEmployeeId() != null ? expense.getEmployeeId() : "")
            );
            bw.newLine(); // move to next line after writing
            System.out.println("Expense successfully added to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the expense to the file.");
            e.printStackTrace();
        }
    }
  //we are creating this function so that it will save all file again if user wants to
  //this function will be used for both deleting and updating of files
  public void saveAllExpense(ArrayList<Expense> expenseRecord, boolean append) {
      try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(this.expenseRecord, append))) {

          /* when user will give false then we are using not operator to make it true because we only want header to apply when 
             we are overwriting like update saving all */
          if (!append) {
              // first writing the header line
              bWriter.write("Expense Type,Amount,Date,Description,EmployeeId");
              bWriter.newLine();
          }

          // moved total amount inside method to avoid accumulation across calls
          double totalamount = 0;

          // Write each record again
          // starting by using loop
          for (Expense e : expenseRecord) {
              bWriter.write(
                  e.getGeneralExpense() + "," +
                  e.getAmount() + "," +
                  e.getDate() + "," +
                  e.getDescription() + "," +
                  (e.getEmployeeId() != null ? e.getEmployeeId() : "")
              );
              // moving to the next line
              bWriter.newLine();
              totalamount += e.getAmount();
          }

          // writing the total expense at the end even if the list is empty
          bWriter.write(",,,TOTAL EXPENSE," + String.format("%.2f", totalamount));
          bWriter.newLine();

      } catch (IOException e) {
          System.out.println("Some error in writing the saved file. Try Again");
      }
  }


}
  

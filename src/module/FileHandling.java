package module;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandling {
    //creating a file named employees.csv
    File EmployeeRecords = new File("employees.csv");  // creating a filr namr employee.csv
    File clientRecords = new File("Client.csv"); // creating a file of cliens for saving records
    public static void main(String[] args) {
        new FileHandling();
        
    }

    public FileHandling() {
        // TODO Auto-generated constructor stub

        try {
            // creating the file if it does not exist in the system
            if (EmployeeRecords.createNewFile()) {
                // this m=built in function will create new file if not created 
                System.out.println("The file has been created succesfully " + EmployeeRecords.getName());
                try {
					BufferedWriter bw= new BufferedWriter( new FileWriter(EmployeeRecords));
					bw.write("FirstName,LastName,Salary,Designation,EmpID");
					bw.newLine();
					bw.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("There is an error in writing the header line");
				}
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            // Handle exceptions if there is an error during file creation
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // System.out.println(EmployeeRecords.getAbsolutePath());//just checking the path
    }

    // We have to create like a read function that will convert our file into arraylist whenever we open our application 
    public ArrayList<Employee> readFromFile() {
        ArrayList<Employee> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(EmployeeRecords))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty())
                    continue;

                // Skip header row (case-insensitive and flexible)
                String lower = line.toLowerCase();
                if (lower.contains("firstname") && lower.contains("salary"))
                    continue;

                // Split line into fields
                String[] fields = line.split(",");

                if (fields.length != 5) {
                    System.out.println("Skipping corrupt or incomplete line: " + line);
                    continue;
                }

                try {
                    String fName = fields[0].trim();
                    String lName = fields[1].trim();
                    int salary = Integer.parseInt(fields[2].trim());
                    String designation = fields[3].trim();
                    int empID = Integer.parseInt(fields[4].trim());

                    Employee emp = new Employee(fName, lName, salary, designation, empID);
                    employeeList.add(emp);

                } catch (NumberFormatException e) {
                    System.out.println("Skipping line due to number format issue: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Employee file not found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading the employee file: " + e.getMessage());
        }

        return employeeList;
    }


    // we are creating this separate class because to reduce repetition of file handling 
    public void AddtotheFile(Employee emps, Boolean append) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(EmployeeRecords, append))) {
            // we are using buffer because it is used for efficiency; append=true means adding new things every time
        	String line = emps.getFirstName() + "," + emps.getLastName() + "," +
                    emps.getSalary() + "," + emps.getDesignation() + "," + emps.getempID();

            bf.write(line); // we are now writing the data 
            bf.newLine(); // add a new line for next record

            System.out.println("Employee data saved successfully.");
        } catch (Exception e) {
            System.out.println("Error in writing your data in employee records");
            System.out.println(e.getMessage());
        }
    }

    public void UpdateTotheFile(ArrayList<Employee> employeelist , Boolean append) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(EmployeeRecords, append))) {
            // we are using buffer because it is used for efficiency; append=true means adding new things every time
            bf.write("FirstName,LastName,Salary,Designation,EmpID");
            bf.newLine();
            for (Employee emp :employeelist ) {
                String line = emp.getFirstName() + "," + emp.getLastName() + "," +
                        emp.getSalary() + "," + emp.getDesignation() + "," + emp.getempID();
                bf.write(line);
                bf.newLine();
            }
            System.out.println("Employee file updated successfully.");
        } catch (Exception e) {
            System.out.println("Error in writing your data in employee records");
            System.out.println(e.getMessage());
        }
    }
// for client
    //method to check if file is created
    public void createClientfile() {
        try {
            if (clientRecords.createNewFile()) {
                System.out.println("Your File is created " + clientRecords);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(clientRecords))) {
                    bw.write("FirstName,LastName,PlotNumber,TotalAmount,CNIC,AreaPlot");
                    bw.newLine();
                }
            } else {
                System.out.println("your file already exists");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    //method to load all data from file to arraylist
    public ArrayList<Client> readFromClientFile() {
        ArrayList<Client> clientList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(clientRecords))) {
            String line;
            br.readLine();
            // used for skipping blank lines
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] fields = line.split(",");
                if (fields.length != 6) {
                    System.out.println("Skipping corrupt line: " + line);
                    continue;
                }

                String firstName = fields[0].trim();
                String lastName = fields[1].trim();
                int plotNumber = Integer.parseInt(fields[2].trim());
                int totalAmount = Integer.parseInt(fields[3].trim());
                String cnic = fields[4].trim();
                double areaPlot = Double.parseDouble(fields[5].trim());

                Client client = new Client(firstName, lastName, plotNumber, totalAmount);
                client.setCnic(cnic.equals("null") ? null : cnic);
                client.setAreaplot(areaPlot);

                clientList.add(client);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading client file: " + e.getMessage());
        }
        //now creating a method tp add the record to

        return clientList;
    }

    public void addToTheClient(Client client, boolean append) {
        try (BufferedWriter bwc = new BufferedWriter(new FileWriter(clientRecords, append))) {
            String line = client.getFirstName() + "," + client.getLastname() + "," +
                          client.getPlotnumber() + "," + client.getTotalmount() + "," +
                          (client.getCnic() == null ? "null" : client.getCnic()) + "," +
                          client.getAreaplot();
            //write whole data in file
            bwc.write(line);
            bwc.newLine();//add new line for new record
            System.out.println("Client data saved successfully.");
        } catch (Exception e) {
            System.out.println("Error in writing your data in client records");
            System.out.println(e.getMessage());
        }
    }

    // function for uploaing upgradation to the client file
    public void updateClientFile(ArrayList<Client> clientList, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(clientRecords, append))) {
            bw.write("FirstName,LastName,PlotNumber,TotalAmount,CNIC,AreaPlot");
            bw.newLine();
            for (Client client : clientList) {
                String line = client.getFirstName() + "," +
                              client.getLastname() + "," +
                              client.getPlotnumber() + "," +
                              client.getTotalmount() + "," +
                              (client.getCnic() == null ? "null" : client.getCnic()) + "," +
                              client.getAreaplot();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Client file updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating client file: " + e.getMessage());
        }
    }

}

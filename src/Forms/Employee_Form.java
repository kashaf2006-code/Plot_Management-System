package Forms;

import javax.swing.*;

import module.Employee;
import module.Employee_Management;

import java.awt.*;

public class Employee_Form extends JPanel {
    public Employee_Form(Employee_Management manager) {
        setLayout(new GridLayout(6,2,10,10));  // 5 rows , 2 column and 10 pixel horixonatl and vertical gap
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));// setting the borders

        JLabel firstnameLabel = new JLabel("Firstname");
        JTextField firstnameField = new JTextField("Khalid", 10);
        JLabel lastnameLabel = new JLabel("Lastname");
        JTextField lastnameField = new JTextField("Hussain", 15);
        JLabel salaryLabel = new JLabel("Salary");
        JTextField salaryField = new JTextField("1000", 15);
        JLabel designationLabel = new JLabel("Designation");
        JTextField designationField = new JTextField("Manager", 15);
        
        
     
        JLabel employee_idJLabel = new JLabel("Employee ID");
        JTextField employee_idField=new JTextField(5);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(120, 35));

        //creating action listenner
        submitButton.addActionListener(e -> {
            String firstname = firstnameField.getText().trim();
            String lastname = lastnameField.getText().trim();
            String salaryText = salaryField.getText().trim();
            String designation = designationField.getText().trim();
            String empIdText = employee_idField.getText().trim();

            if (firstname.isEmpty() || lastname.isEmpty() || salaryText.isEmpty() || designation.isEmpty() || empIdText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int salary = 0;
            int empid = 0;

            try {
                salary = Integer.parseInt(salaryText);
                empid = Integer.parseInt(empIdText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Salary and Employee ID must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean checker = manager.addEmployee(firstname, lastname, salary, designation, empid);

            if (checker) {
                JOptionPane.showMessageDialog(this, "The employee is successfully created.");
            } else {
                JOptionPane.showMessageDialog(this, "The employee already exists in our system.");
            }
        });

   JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
   buttonPanel.add(submitButton);

        add(firstnameLabel);
        add(firstnameField);
        add(lastnameLabel);
        add(lastnameField);
        add(salaryLabel);
        add(salaryField);
        add(designationLabel);
        add(designationField);
        add(employee_idJLabel);
        add(employee_idField);
        add(new JLabel("")); // empty cell for alignment (left cell
        add(buttonPanel);
        
    }
}

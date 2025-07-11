package Forms;

import javax.swing.JFrame;
import module.Employee_Management;

public class TestForms extends JFrame {
    public TestForms() {
        setTitle("Test Employee Form");
        setSize(500, 400); // Slightly wider for padding
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the Employee_Management object
        Employee_Management manager = new Employee_Management();

        // Create the Employee_Form and pass the manager
        Employee_Form employeeForm = new Employee_Form(manager);

        // Add the employee form panel to the frame
        add(employeeForm);
    }

    public static void main(String[] args) {


        // Create and show the frame
        TestForms frame = new TestForms();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}

package Forms;

import javax.swing.*;

import module.Employee;
import module.Employee_Management;

import java.awt.*;
import java.security.PublicKey;


public class Employee_Panel extends JPanel {	
//	Employee_Management Main_manager=new Employee_Management();
	Employee_Form employee_Form= new Employee_Form(null);
	//this is th emethod which has the design of the button of side bar easy to scale, resuable and less messy
	private JButton createSidebarButton(String text) {
		JButton button=new JButton(text);
		button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    button.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
	    button.setBackground(new Color(230, 230, 230));  // default grey
	    button.setForeground(Color.BLACK);
	    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    button.setFocusPainted(false);//remove the dotted line when button is clicked
//this is the hover effect when the button is clicked
	    button.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            button.setBackground(new Color(190, 190, 190)); // on hover
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            button.setBackground(new Color(220, 220, 220)); // normal
	        }
	    });
return button;
	}
public Employee_Panel(Employee_Management Main_manager,JPanel cardcontainer, CardLayout cards) {
	
setBackground(Color.white);
setBorder(getBorder());
// we have to divide the layout in two section
setLayout( new BorderLayout());
//first child where all the menu button will be
JPanel sidebar= new JPanel();
sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS)); 
sidebar.setPreferredSize(new Dimension(250, 0)); // 25% width
sidebar.setBackground(new Color(245, 245, 245)); // #f5f5f5
sidebar.setBorder(getBorder());

//title of side bar panel
JLabel sidebartitleJLabel=new JLabel("Features");
sidebartitleJLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
sidebartitleJLabel.setForeground(Color.DARK_GRAY);
sidebartitleJLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
sidebartitleJLabel.add(Box.createVerticalStrut(10));
sidebar.add(sidebartitleJLabel);
//button in side bar
JButton addEmpButton = createSidebarButton("Add Employee");
JButton delEmpButton = createSidebarButton("Delete Employee");
JButton searchButton = createSidebarButton("Search Employee");
JButton displayEmpButton = createSidebarButton("Display all Employee");
JButton updateButton = createSidebarButton("Update Employee");
JButton backButton = createSidebarButton("Back");


sidebar.add(addEmpButton);
sidebar.add(Box.createVerticalStrut(50)); // gap

sidebar.add(delEmpButton);
sidebar.add(Box.createVerticalStrut(50));
sidebar.add(searchButton);
sidebar.add(Box.createVerticalStrut(50));
sidebar.add(displayEmpButton);sidebar.add(Box.createVerticalStrut(50));

sidebar.add(updateButton);
sidebar.add(Box.createVerticalStrut(50));

sidebar.add(backButton);
sidebar.add(Box.createVerticalStrut(50));

add(sidebar, BorderLayout.WEST);

// now creating screen type panel where all view option will be created
JPanel dynamicPanel = new JPanel();
dynamicPanel.setBackground(Color.WHITE); // or any subtle color
dynamicPanel.setLayout(new CardLayout()); // for screen switching
add(dynamicPanel, BorderLayout.CENTER);
// creating default panel
JPanel defaultPanel = new JPanel();
defaultPanel.setBackground(Color.WHITE); // Or any color you prefer

JLabel welcomeLabel = new JLabel("Welcome to Employee Management Panel");
welcomeLabel.setForeground(Color.DARK_GRAY);
welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(18f));

defaultPanel.add(welcomeLabel);
dynamicPanel.add(defaultPanel, "default");
CardLayout cl = (CardLayout) dynamicPanel.getLayout();
cl.show(dynamicPanel, "default");


//Search Panel this will display the require employee
JPanel searchPanel = new JPanel();
searchPanel.setBackground(Color.WHITE);
searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // align center with spacing

JLabel idLabel = new JLabel("Enter Unique ID:");
JTextField idField = new JTextField(15);

JLabel nameLabel = new JLabel("Enter First Name:");
JTextField nameField = new JTextField(15);

JButton searchNowButton = new JButton("Search");

searchPanel.add(idLabel); searchPanel.add(idField);
searchPanel.add(nameLabel); searchPanel.add(nameField);
searchPanel.add(new JLabel()); searchPanel.add(searchNowButton);

//Result panel to show search result
JPanel resultPanel = new JPanel();
resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
resultPanel.setBackground(Color.WHITE);

//Add resultPanel to searchPanel so it's part of the screen
searchPanel.add(resultPanel);

// search button in sidebar actionlistner
searchButton.addActionListener(e -> {
	CardLayout c2=(CardLayout) dynamicPanel.getLayout();//this means that c1 will get layout manager of dynamic panel
    c2.show(dynamicPanel, "search"); // this will diplay the panel with same name in dynamic panel
    });
// now serach now button
searchNowButton.addActionListener(e -> {
	String firstname=nameField.getText();
	String unique_id=idField.getText();

    // Validate input
    if (firstname.isEmpty() || unique_id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both ID and First Name.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int empId;
    try {
        empId = Integer.parseInt(unique_id);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "ID must be a number and error in converting it .", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Perform search
    Employee emp = Main_manager.searchEmployee(empId, firstname);

    resultPanel.removeAll(); // clear old results

    if (emp != null) {
        // Show details in resultPanel
        resultPanel.add(new JLabel("Employee Found:"));
        resultPanel.add(new JLabel("ID: " + emp.getempID()));
        resultPanel.add(new JLabel("Name: " + emp.getFirstName() + " " + emp.getLastName()));
        resultPanel.add(new JLabel("Designation: " + emp.getDesignation()));
        resultPanel.add(new JLabel("Salary: " + emp.getSalary()));
    } else {
        JOptionPane.showMessageDialog(this, "Employee not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

    resultPanel.revalidate();
    resultPanel.repaint();
    // Validate input
  });

dynamicPanel.add(searchPanel, "search");

//add delete employee panel
JPanel delempPanel = new JPanel();
delempPanel.setBackground(Color.WHITE);
delempPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // align center with spacing
JLabel nameLabeldel = new JLabel("Enter First Name:");
JTextField nameFielddel = new JTextField(15);
 JLabel lastnameLabel= new JLabel("Enter Last Name");
 JTextField lastnamedelField= new JTextField(15);

JLabel idLabeldel = new JLabel("Enter Unique ID:");
JTextField idFielddel = new JTextField(15);

JButton delnowbutton = new JButton("delete");
//adding the delete options which are rquired

delempPanel.add(nameLabeldel); delempPanel.add(nameFielddel);
delempPanel.add(lastnameLabel);delempPanel.add(lastnamedelField);
delempPanel.add(idLabeldel); delempPanel.add(idFielddel);
delempPanel.add(new JLabel()); delempPanel.add(delnowbutton);
// adding the delete panel into dyanamic panel
dynamicPanel.add(delempPanel,"Delete");
//now adding action listener to the delete employee button option
delEmpButton.addActionListener(e -> {
	CardLayout c3=(CardLayout) dynamicPanel.getLayout();
    c3.show(dynamicPanel, "Delete");
});
//adding action listner of delete now button after entering the unique id and first name 
delnowbutton.addActionListener(e -> {
	String firstnamedelString=nameFielddel.getText().toLowerCase().trim();
	String lastnamedelString=lastnamedelField.getText().trim().toLowerCase();
	String employeeidString=idFielddel.getText();
	
	int employeeid=0;
	try {
		employeeid=Integer.parseInt(employeeidString);
	} catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Employee ID must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
return;
	}
	// 1. Call delete method
	Main_manager.delEmployee(firstnamedelString, lastnamedelString, employeeid);

	// 2. Show success message
	JOptionPane.showMessageDialog(this, "Employee deleted .", "Delete Result", JOptionPane.INFORMATION_MESSAGE);
    return;
});

// now display button stuff is done

//new panel for displaying all employees
//Display All Employees Panel
JPanel displayAllEmpPanel = new JPanel(new BorderLayout());
displayAllEmpPanel.setBackground(Color.WHITE);

//Scrollable container to hold the list
JPanel employeeListPanel = new JPanel();
employeeListPanel.setLayout(new BoxLayout(employeeListPanel, BoxLayout.Y_AXIS));
employeeListPanel.setBackground(Color.WHITE);

//Add scroll pane
JScrollPane scrollPane = new JScrollPane(employeeListPanel);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollPane.setBorder(null); // Remove ugly border
displayAllEmpPanel.add(scrollPane, BorderLayout.CENTER);

//Add to dynamic panel
dynamicPanel.add(displayAllEmpPanel, "Display");

//Button Action: Show All Employees
displayEmpButton.addActionListener(e -> {
 employeeListPanel.removeAll(); // clear previous results

 if (Main_manager.getAllEmployees().isEmpty()) {
     employeeListPanel.add(new JLabel("No employees found."));
 } else {
     for (Employee emp : Main_manager.getAllEmployees()) {
         JPanel empPanel = new JPanel(new GridLayout(0, 1));
         empPanel.setBackground(new Color(245, 245, 245));
         empPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

         empPanel.add(new JLabel("First Name: " + emp.getFirstName()));
         empPanel.add(new JLabel("Last Name: " + emp.getLastName()));
         empPanel.add(new JLabel("Salary: " + emp.getSalary()));
         empPanel.add(new JLabel("Designation: " + emp.getDesignation()));
         empPanel.add(new JLabel("Employee ID: " + emp.getempID()));

         empPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
         empPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, empPanel.getPreferredSize().height));
         employeeListPanel.add(empPanel);
         employeeListPanel.add(Box.createVerticalStrut(10)); // spacing
     }
 }

 employeeListPanel.revalidate();
 employeeListPanel.repaint();

 CardLayout cld = (CardLayout) dynamicPanel.getLayout();
 cld.show(dynamicPanel, "Display");
});
//Update Panel added in future
//adding employee form into dynamic panel
dynamicPanel.add(employee_Form,"Employee Add Form");
addEmpButton.addActionListener(e -> {
	CardLayout cadd=(CardLayout) dynamicPanel.getLayout();
	cadd.show(dynamicPanel,"Employee Add Form");
});
// Back
backButton.addActionListener(e -> {
	cards.show(cardcontainer,"DASHBOARD");
});
}
}
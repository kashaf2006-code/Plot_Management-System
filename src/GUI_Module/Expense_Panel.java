package GUI_Module;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.nio.channels.SelectableChannel;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.*;

import module.Expense;
import module.ExpenseManager;

public class Expense_Panel extends JPanel {
	//method for displaying label for user
	public JLabel displayLabel(String text,Color textColor) {
		JLabel label=new JLabel(text);
		label.setForeground(textColor);
		label.setFont(new Font("Segoe UI", Font.BOLD, 22));
		 label.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
		    label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding
		    return label;
	}

	//proper styling of buttons
	private JButton createStyledButton(String text, Color bgColor, Color hoverColor) {
	    JButton button = new JButton(text);
	    button.setFont(new Font("Segoe UI", Font.BOLD, 22));
	    button.setBackground(bgColor);
	    button.setForeground(Color.WHITE);
	    button.setFocusPainted(false);
	    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

	    button.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            button.setBackground(hoverColor);
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            button.setBackground(bgColor);
	        }
	    });

	    return button;
	}

    public Expense_Panel(JPanel cardContainer, CardLayout cards, ExpenseManager expenseManager) {
//expense main class
    	
    	setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ==== Sidebar Panel ====
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(250, 0)); // ~25% width
        sidebar.setBackground(new Color(230, 249, 230)); // Light green (#e6f9e6)
        add(sidebar, BorderLayout.WEST);

        // Sidebar Title
        JLabel title = new JLabel("Expense Features");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.DARK_GRAY);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(title);
        sidebar.add(Box.createVerticalStrut(30));

        // ==== Sidebar Buttons ====
        JButton addExpenseBtn = new JButton("Add Expense");
        JButton deleteExpenseBtn = new JButton("Delete Expense");
        JButton displayExpenseBtn = new JButton("Display Expense");
        JButton updateExpenseBtn = new JButton("Update");
        JButton backBtn = new JButton("Back");

        JButton[] buttons = {
            addExpenseBtn, deleteExpenseBtn, displayExpenseBtn, updateExpenseBtn, backBtn
        };

        for (JButton btn : buttons) {
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            sidebar.add(btn);
            sidebar.add(Box.createVerticalStrut(30));
        }

        // ==== Dynamic Panel ====
        JPanel dynamicPanel = new JPanel(new CardLayout());
        dynamicPanel.setBackground(Color.WHITE);
        add(dynamicPanel, BorderLayout.CENTER);

        // ==== Default Welcome Panel ====
        JPanel defaultPanel = new JPanel();
        defaultPanel.setBackground(Color.WHITE);
        JLabel welcomeLabel = new JLabel("Welcome to Expense Panel");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        welcomeLabel.setForeground(new Color(0, 102, 51)); // Deep green tone
        defaultPanel.add(welcomeLabel);
        dynamicPanel.add(defaultPanel, "default");

        // Show default panel initially
        CardLayout cl = (CardLayout) dynamicPanel.getLayout();
        cl.show(dynamicPanel, "default");
        // jpanel for adding expense
        JPanel addexpenseJPanel=new JPanel();
        addexpenseJPanel.setLayout(new GridBagLayout());
        addexpenseJPanel.setBackground(Color.white);
       
       GridBagConstraints gbcExpAdd= new GridBagConstraints();
       gbcExpAdd.insets = new Insets(10, 10, 10, 10); // padding
       gbcExpAdd.fill = GridBagConstraints.HORIZONTAL;
       gbcExpAdd.anchor = GridBagConstraints.WEST;

       Font labelFontadd = new Font("Segoe UI", Font.BOLD, 24);
       Font fieldFontadd = new Font("Segoe UI", Font.PLAIN, 22);
       

    // ✅ HEADING — at the top, centered, large font
    gbcExpAdd.gridx = 0;
    gbcExpAdd.gridy = 0;
    gbcExpAdd.gridwidth = 2; // span across two columns (if form uses labels + fields)
  

    // 🔁 Reset for other fields
    gbcExpAdd.anchor = GridBagConstraints.WEST;
    gbcExpAdd.gridwidth = 1;

    // ✅ Expense Type Label — row 1
    gbcExpAdd.gridx = 0;
    gbcExpAdd.gridy = 1;
    JLabel expensetypeJLabel = new JLabel("Expense Type:");
    expensetypeJLabel.setFont(labelFontadd);
    addexpenseJPanel.add(expensetypeJLabel, gbcExpAdd);

    //expense combo box
    gbcExpAdd.gridx = 1;
    gbcExpAdd.gridy=1;
    String[] expensetypeString= {"Salary","Food","Electricity","Bonus Salary","Appliance expemse"};
    JComboBox<String> expensetypeComboBox=new JComboBox<String>(expensetypeString);
    expensetypeComboBox.setFont(fieldFontadd);
    addexpenseJPanel.add(expensetypeComboBox,gbcExpAdd);
    // if from combo box salary is selected than employee id should be visible
    //amount of expense
    gbcExpAdd.gridx=0;
    gbcExpAdd.gridy=2;
    JLabel amountJLabel=new JLabel("Amount:");
    amountJLabel.setFont(labelFontadd);
    addexpenseJPanel.add(amountJLabel,gbcExpAdd);
    //amount test field  
    gbcExpAdd.gridx=1;//col
    gbcExpAdd.gridy=2;//row
    JTextField amountField=new JTextField(10);
    amountField.setFont(fieldFontadd);
    addexpenseJPanel.add(amountField,gbcExpAdd);
    //add expense panel to dynamic 
    dynamicPanel.add(addexpenseJPanel,"Add Expense");
    // date field and label
 // Date Label
    gbcExpAdd.gridx = 0;
    gbcExpAdd.gridy = 3;
    JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
    dateLabel.setFont(labelFontadd);
    addexpenseJPanel.add(dateLabel, gbcExpAdd);

    // Date Field (User Input)
    gbcExpAdd.gridx = 1;
    gbcExpAdd.gridy = 3;
    JTextField dateField = new JTextField(10);
    dateField.setFont(fieldFontadd);
    addexpenseJPanel.add(dateField, gbcExpAdd);
 // Description Label
    gbcExpAdd.gridx = 0;
    gbcExpAdd.gridy = 4;
    JLabel descriptionLabel = new JLabel("Description:");
    descriptionLabel.setFont(labelFontadd);
    addexpenseJPanel.add(descriptionLabel, gbcExpAdd);

    // Description Field
    gbcExpAdd.gridx = 1;
    gbcExpAdd.gridy = 4;
    JTextField descriptionField = new JTextField(20);
    descriptionField.setFont(fieldFontadd);
    addexpenseJPanel.add(descriptionField, gbcExpAdd);

    
    
 // Employee ID Label
    gbcExpAdd.gridx = 0;
    gbcExpAdd.gridy = 5;
    JLabel employeeIdLabel = new JLabel("Employee ID:");
    employeeIdLabel.setFont(labelFontadd);
    employeeIdLabel.setVisible(false); // initially hidden
    addexpenseJPanel.add(employeeIdLabel, gbcExpAdd);

    // Employee ID TextField
    gbcExpAdd.gridx = 1;
    gbcExpAdd.gridy = 5;
    JTextField employeeIdField = new JTextField(10);
    employeeIdField.setFont(fieldFontadd);
    employeeIdField.setVisible(false); // initially hidden
    addexpenseJPanel.add(employeeIdField, gbcExpAdd);
// iteam listener on jcombo box
    expensetypeComboBox.addItemListener(e -> {
        if (e.getStateChange() == ItemEvent.SELECTED) {// means if something is selected
            String selected = (String) expensetypeComboBox.getSelectedItem();//creating a string which will store the selected item
            boolean isSalaryType = selected.equals("Salary") || selected.equals("Bonus Salary");
//            if boolean is true then selected salarytype 
            employeeIdLabel.setVisible(isSalaryType);
            employeeIdField.setVisible(isSalaryType);

//            // Update the panel layout
//            addexpenseJPanel.revalidate();
//            addexpenseJPanel.repaint();
        }
    });
    // add expense button
    gbcExpAdd.gridx=1;
    gbcExpAdd.gridy=6;
    gbcExpAdd.gridwidth=1;
    JButton addNowExpButton = createStyledButton(
    	    "Add Expense",
    	    new Color(34, 139, 34),    // ForestGreen
    	    new Color(0, 200, 83)      // Brighter green on hover
    	);
    addexpenseJPanel.add(addNowExpButton,gbcExpAdd);
    //Action listener of add now expense button
    addNowExpButton.addActionListener(e -> {
     
            String expenseType = (String) expensetypeComboBox.getSelectedItem();// getting item from combobox
            String amountText = amountField.getText().trim();
            String dateText = dateField.getText().trim();
            String description = descriptionField.getText().trim().toLowerCase();
            String employeeidString = employeeIdField.getText().trim();
            
int employeeid=0;
double amount;
//1) Parse and validate amount on its own
try {
    amount = Double.parseDouble(amountText);
    if (amount <= 0) {
        JOptionPane.showMessageDialog(this,
            "Amount must be greater than 0.");
        return;
    }
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(this,
        "There is issue in converting into double variable");
    return;
}
try {
	if (expensetypeComboBox.getSelectedItem()=="salary"||expensetypeComboBox.getSelectedItem()=="Bonus salary") {
		employeeid=Integer.parseInt(employeeidString);
	}
	
} catch (NumberFormatException e2) {
	  JOptionPane.showMessageDialog(this,"There is issue in converting into integar variable of employeeid");
		    return;
}

          // Validate and convert date
            LocalDate date;
            try {
                date = LocalDate.parse(dateText);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Use YYYY-MM-DD.");
                return;
            }

            // If Salary or Bonus Salary, employee ID must be filled
            if ((expenseType.equals("Salary") || expenseType.equals("Bonus Salary")) && employeeidString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Employee ID is required for Salary/Bonus Salary.");
                return;
            }
            //first create the expense objects
         Expense  expensesObjects =new Expense(expenseType, amount, date, description);
           Boolean checker=  expenseManager.addExpense(expensesObjects);
           if (checker) {
        	   JOptionPane.showMessageDialog(this, "Expense added successfully!");
        	    
        	    // Optionally: clear fields after successful add
        	    amountField.setText("");
        	    dateField.setText("");
        	    descriptionField.setText("");
        	    employeeIdField.setText("");
        	} else {
        	    JOptionPane.showMessageDialog(this, "Failed to add expense. Please try again.");
        	}
    });
    //DELETE expense panel
    JPanel delexpPanel=new JPanel();
    delexpPanel.setBackground(new Color(250, 245, 245));
    delexpPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbcDelExp = new GridBagConstraints();
    gbcDelExp.insets = new Insets(10, 10, 10, 10);
    gbcDelExp.fill = GridBagConstraints.HORIZONTAL;
    gbcDelExp.anchor = GridBagConstraints.WEST;

    Font labelFont = new Font("Segoe UI", Font.BOLD, 24);
    Font fieldFont = new Font("Segoe UI", Font.PLAIN, 22);

    // ✅ Heading
    gbcDelExp.gridx = 0;
    gbcDelExp.gridy = 0;
    gbcDelExp.gridwidth = 2;
    JLabel deleteHeading = new JLabel("Fill the required fields to delete any expense");
    deleteHeading.setFont(new Font("Segoe UI", Font.BOLD, 26));
    deleteHeading.setForeground(new Color(153, 0, 0)); // deep red tone
    delexpPanel.add(deleteHeading, gbcDelExp);

    // reset for next fields
    gbcDelExp.gridwidth = 1;

    // ✅ Expense Type
    gbcDelExp.gridx = 0;
    gbcDelExp.gridy = 1;
    JLabel delTypeLabel = new JLabel("Expense Type:");
    delTypeLabel.setFont(labelFont);
    delexpPanel.add(delTypeLabel, gbcDelExp);

    gbcDelExp.gridx = 1;
    String[] delExpenseTypes = { "Salary", "Food", "Electricity", "Bonus Salary", "Appliance Expense" };
    JComboBox<String> delTypeComboBox = new JComboBox<>(delExpenseTypes);
    delTypeComboBox.setFont(fieldFont);
    delexpPanel.add(delTypeComboBox, gbcDelExp);

    // ✅ Amount
    gbcDelExp.gridx = 0;
    gbcDelExp.gridy = 2;
    JLabel delAmountLabel = new JLabel("Amount:");
    delAmountLabel.setFont(labelFont);
    delexpPanel.add(delAmountLabel, gbcDelExp);

    gbcDelExp.gridx = 1;
    JTextField delAmountField = new JTextField(10);
    delAmountField.setFont(fieldFont);
    delexpPanel.add(delAmountField, gbcDelExp);

    // ✅ Date
    gbcDelExp.gridx = 0;
    gbcDelExp.gridy = 3;
    JLabel delDateLabel = new JLabel("Date (YYYY-MM-DD):");
    delDateLabel.setFont(labelFont);
    delexpPanel.add(delDateLabel, gbcDelExp);

    gbcDelExp.gridx = 1;
    JTextField delDateField = new JTextField(10);
    delDateField.setFont(fieldFont);
    delexpPanel.add(delDateField, gbcDelExp);

 // ✅ Delete Now Button
    gbcDelExp.gridx = 0;
    gbcDelExp.gridy = 4;
    gbcDelExp.gridwidth = 1;

    JButton deleteNowBtn = createStyledButton(
        "Delete Now",
        new Color(178, 34, 34),    // Firebrick red
        new Color(220, 20, 60)     // Crimson on hover
    );

    // ✅ Delete All Button
    JButton delAllExpButton = createStyledButton(
        "Delete All",
        new Color(255, 87, 34),     // Orange
        new Color(255, 0, 0)        // Reddish hover
    );

    // Add action listener for Delete Now
    deleteNowBtn.addActionListener(e -> {
        String selectedType = (String) delTypeComboBox.getSelectedItem();
        String amountText = delAmountField.getText().trim();
        String dateText = delDateField.getText().trim();

        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than 0.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount format.");
            return;
        }

        LocalDate date;
        try {
            date = LocalDate.parse(dateText);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD.");
            return;
        }

        boolean checker = expenseManager.delExpense(selectedType, amount, date);
        if (checker) {
           displayLabel("The expense is deleted successfully",Color.green);
        } else {
            JOptionPane.showMessageDialog(this, "The expense was not deleted. Please try again.");
        }
    });

    // Add action listener for Delete All
    delAllExpButton.addActionListener(e -> {
        int result = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete all expense records?\nThis action cannot be undone.",
            "Confirm Deletion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (result == JOptionPane.YES_OPTION) {
            expenseManager.deleteAllExpense();

            JLabel msg = displayLabel("All expense records deleted.", Color.RED);
            gbcDelExp.gridx = 0;
            gbcDelExp.gridy = 5;
            gbcDelExp.gridwidth = 2;
            delexpPanel.add(msg, gbcDelExp);
            delexpPanel.revalidate();
            delexpPanel.repaint();
        }
    });

    // === Add both buttons side by side ===
    gbcDelExp.gridx = 0;
    gbcDelExp.gridy = 4;
    gbcDelExp.gridwidth = 1;
    delexpPanel.add(deleteNowBtn, gbcDelExp);

    gbcDelExp.gridx = 1;//col
    gbcDelExp.gridy = 4;//row
    delexpPanel.add(delAllExpButton, gbcDelExp);
    //adding the whole panel
   dynamicPanel.add(delexpPanel,"Delete Expense");
   JPanel displayExpensePanel = new JPanel();
   displayExpensePanel.setLayout(new BorderLayout());
   displayExpensePanel.setBackground(new Color(245, 255, 245)); // Soft mint background

   // Heading
   JLabel heading = new JLabel("All Expenses");
   heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
   heading.setForeground(new Color(0, 102, 51)); // Deep green
   heading.setHorizontalAlignment(SwingConstants.CENTER);
   heading.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
   displayExpensePanel.add(heading, BorderLayout.NORTH);

   // Scrollable content panel
   JPanel expensesContainer = new JPanel();
   expensesContainer.setLayout(new BoxLayout(expensesContainer, BoxLayout.Y_AXIS));
   expensesContainer.setBackground(new Color(245, 255, 245));

   ArrayList<Expense> allExpenses = expenseManager.displayAllExpenses(); // Make sure this method exists

   for (Expense expense : allExpenses) {
       JPanel expenseCard = new JPanel(new GridLayout(0, 1));
       expenseCard.setBackground(Color.WHITE);
       expenseCard.setBorder(BorderFactory.createCompoundBorder(
           BorderFactory.createLineBorder(new Color(200, 230, 200)),
           BorderFactory.createEmptyBorder(10, 10, 10, 10)
       ));

       JLabel typeLabel = new JLabel("Type: " + expense.getGeneralExpense());
       JLabel amountLabel = new JLabel("Amount: " + expense.getAmount());
       JLabel dateLabelDisplay = new JLabel("Date: " + expense.getDate().toString());
       JLabel descLabel = new JLabel("Description: " + expense.getDescription());
       Font cardFont = new Font("Segoe UI", Font.PLAIN, 18);
       for (JLabel label : new JLabel[]{typeLabel, amountLabel, dateLabelDisplay, descLabel,}) {
           label.setFont(cardFont);
           expenseCard.add(label);
       }
       //setting the label
     
       expensesContainer.add(expenseCard);       //adding separetly so that it appear on last

       expensesContainer.add(Box.createVerticalStrut(10));
   }

   JScrollPane scrollPane = new JScrollPane(expensesContainer);
   scrollPane.setBorder(null);
   scrollPane.getVerticalScrollBar().setUnitIncrement(16); // smoother scrolling
   JLabel totalExpenseJLabel=new JLabel("Total Expense:"+expenseManager.getTotalExpense());
  totalExpenseJLabel.setFont(labelFont);
       expensesContainer.add(totalExpenseJLabel);
   displayExpensePanel.add(scrollPane, BorderLayout.CENTER);

   // Add to dynamic panel
   dynamicPanel.add(displayExpensePanel, "Display Expense");





    
        // === Button Actions (to be linked later to your forms/panels) ===
        addExpenseBtn.addActionListener(e -> cl.show(dynamicPanel, "Add Expense"));
        deleteExpenseBtn.addActionListener(e -> cl.show(dynamicPanel, "Delete Expense"));
        displayExpenseBtn.addActionListener(e -> cl.show(dynamicPanel, "Display Expense"));
        updateExpenseBtn.addActionListener(e -> cl.show(dynamicPanel, "Update Expense"));
        backBtn.addActionListener(e -> cards.show(cardContainer, "DASHBOARD"));
    }
}

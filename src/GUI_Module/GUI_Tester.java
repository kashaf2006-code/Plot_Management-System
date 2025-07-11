package GUI_Module;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Forms.Client_Panel;
import module.ClientManagement;
import module.ExpenseManager;

public class GUI_Tester {
	  public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            // Frame setup
	            JFrame frame = new JFrame("Plot Management - Expense Module");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	            // Create CardLayout and card container
	            CardLayout cards = new CardLayout();
	            JPanel cardContainer = new JPanel(cards);
ExpenseManager expenseManager=new ExpenseManager();
	            // Create and add Client_Panel instead of Employee_Panel
                         Expense_Panel expense_Panel=new Expense_Panel(cardContainer, cards, expenseManager);
cardContainer.add(expense_Panel, "Expense");
	            // Show the Client panel
	            cards.show(cardContainer, "Expense");

	            // Set up frame
	            frame.setContentPane(cardContainer);
	            frame.setSize(1000, 700); // recommended size
	            frame.setLocationRelativeTo(null); // center on screen
	            frame.setVisible(true);
	        });
	    }
		
}

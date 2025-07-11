package Forms;

import java.awt.CardLayout;
import javax.swing.*;

import module.ClientManagement;

public class TesterLoginpage {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Frame setup
            JFrame frame = new JFrame("Plot Management - Client Module");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create CardLayout and card container
            CardLayout cards = new CardLayout();
            JPanel cardContainer = new JPanel(cards);
ClientManagement cleintmanagerClientManagement=new ClientManagement();
            // Create and add Client_Panel instead of Employee_Panel
            Client_Panel clientPanel = new Client_Panel(cardContainer, cards,cleintmanagerClientManagement);
            cardContainer.add(clientPanel, "CLIENT");

            // Show the Client panel
            cards.show(cardContainer, "CLIENT");

            // Set up frame
            frame.setContentPane(cardContainer);
            frame.setSize(1000, 700); // recommended size
            frame.setLocationRelativeTo(null); // center on screen
            frame.setVisible(true);
        });
    }
}

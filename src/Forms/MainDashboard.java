package Forms;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.*;

public class MainDashboard extends JLayeredPane {
    private Image backgroundImage;

    public MainDashboard(JPanel cardContainer, CardLayout cards) {
        // Load background image
        URL imageUrl = getClass().getResource("/Images_Project/buildigimage.jpg");
        if (imageUrl == null) {
            System.out.println("❌ Image not found!");
        } else {
            System.out.println("✅ Image loaded from: " + imageUrl);
            backgroundImage = new ImageIcon(imageUrl).getImage();
        }

        setLayout(null); // use absolute layout for full control
        setPreferredSize(new Dimension(800, 600));

        // Create background label
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel, JLayeredPane.DEFAULT_LAYER); // bottom layer

        // Create transparent panel to hold content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(true);
        contentPanel.setBackground(new Color(0, 0, 0, 90)); // glass effect
        contentPanel.setBounds(150, 50, 500, 500); // Adjust as needed
        add(contentPanel, JLayeredPane.PALETTE_LAYER); // upper layer

        // Heading
        JLabel heading = new JLabel("Plot Management System", SwingConstants.CENTER);
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(new Color(245, 245, 245)); // Almost white
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        contentPanel.add(heading);

        // Welcome
        JLabel welcomeLabel = new JLabel("WELCOME Mr.Khalid Hussain Rahujo.", SwingConstants.CENTER);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        welcomeLabel.setForeground(new Color(200, 200, 200)); // light gray
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        contentPanel.add(welcomeLabel);

        // Buttons
        contentPanel.add(createStyledButton("\uD83D\uDC64  Client", cardContainer, cards));
        contentPanel.add(createStyledButton("\uD83D\uDC68\u200D\uD83D\uDCBC  Employee", cardContainer, cards));
        contentPanel.add(createStyledButton("\uD83D\uDCB0  Expenses", cardContainer, cards));
        contentPanel.add(createStyledButton("\uD83D\uDCC8  Sales Recovery", cardContainer, cards));
        contentPanel.add(createStyledButton("\uD83D\uDEAA  Exit", cardContainer, cards));
    }

    private JButton createStyledButton(String text, JPanel cardContainer, CardLayout cards) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(new Color(60, 64, 72));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setMaximumSize(new Dimension(300, 50));

        // Action handlers for each button
        if (text.contains("Employee")) {
            button.addActionListener(e -> cards.show(cardContainer, "EMPLOYEE"));
        } else if (text.contains("Client")) {
            button.addActionListener(e -> cards.show(cardContainer, "CLIENT"));
        } else if (text.contains("Expenses")) {
            button.addActionListener(e -> cards.show(cardContainer, "EXPENSES"));
        } else if (text.contains("Sales")) {
            button.addActionListener(e -> cards.show(cardContainer, "SALES"));
        } else if (text.contains("Exit")) {
            button.addActionListener(e -> System.exit(0));
        }

        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(80, 85, 95));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(60, 64, 72));
            }
        });

        return button;
    }
 }

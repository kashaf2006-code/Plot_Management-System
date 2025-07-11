package Forms;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JPanel {
    public LoginPage(JPanel cardContainer, CardLayout cards) {
        // setting the layout null for custom layout
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(450, 400));

        // creating the important components
        JLabel mainheading = new JLabel("Plot Management System");
        mainheading.setFont(new Font("Arial", Font.BOLD, 24));
        mainheading.setForeground(Color.blue);
        mainheading.setBounds(100, 30, 300, 50); // x start from left y = 0 is top
        add(mainheading);

        // adding the label for login page heading
        JLabel loginpage = new JLabel("Login page");
        loginpage.setFont(new Font("Arial", Font.BOLD, 20));
        loginpage.setForeground(Color.blue);
        loginpage.setBounds(180, 70, 250, 40);
        add(loginpage);

        JLabel userNameJ = new JLabel("Username");
        userNameJ.setBounds(50, 130, 100, 30);
        userNameJ.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField username = new JTextField(15);
        username.setFont(new Font("Arial", Font.PLAIN, 16)); // Increased font size
        username.setBounds(160, 130, 200, 30);

        add(userNameJ);
        add(username);

        // jpassword field
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setBounds(50, 180, 100, 30);
        add(password);

        JPasswordField password_user = new JPasswordField(15);
        password_user.setFont(new Font("Arial", Font.PLAIN, 16)); // Increased font size
        password_user.setBounds(160, 180, 200, 30);
        add(password_user);

        // password checklist
        JCheckBox showPasswordCheck;

        showPasswordCheck = new JCheckBox("Show Password");
        showPasswordCheck.setBounds(160, 220, 150, 20);
        showPasswordCheck.setBackground(Color.WHITE);
        showPasswordCheck.addActionListener(e -> {
            if (showPasswordCheck.isSelected()) {
                password_user.setEchoChar((char) 0);
            } else {
                password_user.setEchoChar('*');
            }
        });
        add(showPasswordCheck);

        // Login button
        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.BOLD, 16));
        loginBtn.setBounds(160, 260, 200, 35);
        add(loginBtn);

        // ✅ Green/Red message panel
        JPanel messagePanel = new JPanel();
        messagePanel.setBounds(80, 310, 320, 30);
        messagePanel.setBackground(Color.WHITE);
        messagePanel.setLayout(null);
        add(messagePanel);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 5, 270, 25);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messagePanel.add(messageLabel);

        // action listener of login button
        loginBtn.addActionListener(e -> {
            String user = username.getText();
            String pass = String.valueOf(password_user.getPassword());

            // condition
            if ((user.equals("khalid@123") && pass.equals("121212")) || user.equals("kashaf@123")) {
                messageLabel.setText("Login successful!");
                messagePanel.setBackground(new Color(0, 153, 0)); // green
                messageLabel.setForeground(Color.WHITE);

                // transfer to main dashpanel
                cards.show(cardContainer, "DASHBOARD");

            } else {
                messageLabel.setText("Incorrect username or password.");
                messagePanel.setBackground(Color.RED);
                messageLabel.setForeground(Color.WHITE);
            }
        });
    }
}

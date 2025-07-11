package Forms;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import module.Client;
import module.ClientManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client_Form extends JPanel {

	private static final long serialVersionUID = 1L;
  Client_Form(ClientManagement cm) {
		Color bgColor = new Color(245, 245, 245);
		Color textColor = new Color(50, 50, 50);
//setting the background color
		setBackground(bgColor);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{33, 92, 136, 89, 136, 102, 7, 115, 7, 0};
		gridBagLayout.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel_1 = new JLabel("Firstname");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		// Firstname TextField
		JTextField firstname = new JTextField("kashaf");
		firstname.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_firstname = new GridBagConstraints();
		gbc_firstname.gridwidth = 3;
		gbc_firstname.fill = GridBagConstraints.HORIZONTAL; // 👈 makes it stretch
		gbc_firstname.weightx = 1.0; // 👈 gives it extra space
		gbc_firstname.anchor = GridBagConstraints.NORTHWEST;
		gbc_firstname.insets = new Insets(0, 0, 5, 5);
		gbc_firstname.gridx = 3;
		gbc_firstname.gridy = 1;
		add(firstname, gbc_firstname);

		// Lastname TextField
		JTextField lastname = new JTextField("fatima");
		lastname.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lastname = new GridBagConstraints();
		gbc_lastname.gridwidth = 3;
		gbc_lastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastname.weightx = 1.0;
		gbc_lastname.anchor = GridBagConstraints.NORTHWEST;
		gbc_lastname.insets = new Insets(0, 0, 5, 5);
		gbc_lastname.gridx = 3;
		gbc_lastname.gridy = 4;
		add(lastname, gbc_lastname);

		// PlotNumber TextField
		JTextField plotnumber = new JTextField();
		plotnumber.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_plotnumber = new GridBagConstraints();
		gbc_plotnumber.gridwidth = 3;
		gbc_plotnumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_plotnumber.weightx = 1.0;
		gbc_plotnumber.anchor = GridBagConstraints.NORTHWEST;
		gbc_plotnumber.insets = new Insets(0, 0, 5, 5);
		gbc_plotnumber.gridx = 3;
		gbc_plotnumber.gridy = 6;
		add(plotnumber, gbc_plotnumber);

		// TotalAmount TextField
		JTextField totalamounTextField = new JTextField();
		totalamounTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_totalamounTextField = new GridBagConstraints();
		gbc_totalamounTextField.gridwidth = 3;
		gbc_totalamounTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalamounTextField.weightx = 1.0;
		gbc_totalamounTextField.anchor = GridBagConstraints.NORTHWEST;
		gbc_totalamounTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalamounTextField.gridx = 3;
		gbc_totalamounTextField.gridy = 8;
		add(totalamounTextField, gbc_totalamounTextField);


		JLabel lastnameLabel = new JLabel("Lastname");
		lastnameLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		GridBagConstraints gbc_lastnameLabel = new GridBagConstraints();
		gbc_lastnameLabel.anchor = GridBagConstraints.WEST;
		gbc_lastnameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastnameLabel.gridx = 1;
		gbc_lastnameLabel.gridy = 4;
		add(lastnameLabel, gbc_lastnameLabel);

		

		JLabel plotnuJLabel = new JLabel("PlotNumber");
		plotnuJLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_plotnuJLabel = new GridBagConstraints();
		gbc_plotnuJLabel.anchor = GridBagConstraints.WEST;
		gbc_plotnuJLabel.insets = new Insets(0, 0, 5, 5);
		gbc_plotnuJLabel.gridx = 1;
		gbc_plotnuJLabel.gridy = 6;
		add(plotnuJLabel, gbc_plotnuJLabel);


		JLabel totalamountJLabel = new JLabel("Total amount");
		totalamountJLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		GridBagConstraints gbc_totalamountJLabel = new GridBagConstraints();
		gbc_totalamountJLabel.anchor = GridBagConstraints.WEST;
		gbc_totalamountJLabel.insets = new Insets(0, 0, 5, 5);
		gbc_totalamountJLabel.gridx = 1;
		gbc_totalamountJLabel.gridy = 8;
		add(totalamountJLabel, gbc_totalamountJLabel);
//button
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setPreferredSize(new java.awt.Dimension(150, 40)); // 👈 Bigger button
		
				//converting all the input to desire variable
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Get trimmed input values
						String firstnameString = firstname.getText().trim().toLowerCase();
						String lastnameString = lastname.getText().trim().toLowerCase();
						String plotno = plotnumber.getText().trim();
						String totalamountString = totalamounTextField.getText().trim();

						// Check for empty input fields first
						if (firstnameString.isEmpty() || lastnameString.isEmpty() || plotno.isEmpty() || totalamountString.isEmpty()) {
							JOptionPane.showMessageDialog(Client_Form.this, "❗ Please fill all the input fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
							return;
						}

						try {
							int plotNumberInt = Integer.parseInt(plotno);
							int totalAmountInt = Integer.parseInt(totalamountString);

							// Create client and add it using ClientManagement
//							Client client = new Client(firstnameString, lastnameString, plotNumberInt, totalAmountInt);
							boolean checker = cm.addClient(firstnameString, lastnameString, plotNumberInt, totalAmountInt);

							if (checker) {
								JOptionPane.showMessageDialog(Client_Form.this, "✅ Client added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
								// Optionally clear fields
								firstname.setText("");
								lastname.setText("");
								plotnumber.setText("");
								totalamounTextField.setText("");
							} else {
								JOptionPane.showMessageDialog(Client_Form.this, "⚠️ Client already exists or could not be added.", "Duplicate", JOptionPane.WARNING_MESSAGE);
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(Client_Form.this, "❗ Please enter valid numbers for Plot Number and Total Amount.", "Format Error", JOptionPane.ERROR_MESSAGE);
						} catch (Exception ex) {
						    ex.printStackTrace(); // 👈 This shows the actual error in console
						    JOptionPane.showMessageDialog(Client_Form.this, "❌ Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}

					}
				});

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 11;
		add(btnNewButton, gbc_btnNewButton);
	}

}

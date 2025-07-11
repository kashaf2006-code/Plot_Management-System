package Forms;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.lang.classfile.attribute.InnerClassesAttribute;
import java.util.ArrayList;

import javax.swing.*;

import module.Client;
import module.ClientManagement;

public class Client_Panel extends JPanel{
	// Constructor
    public Client_Panel(JPanel cardContainer, CardLayout cards, ClientManagement clientmanager) {
     	Client_Form client_Form = new Client_Form(clientmanager); // ✅ Right
   setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Sidebar Panel (left)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(250, 0)); // 25% of width
        sidebar.setBackground(new Color(224, 247, 250)); // soft blue

        // Sidebar Title
        JLabel title = new JLabel("Client Features");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.DARK_GRAY);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(title);
        sidebar.add(Box.createVerticalStrut(30));

        // Sidebar Buttons
        JButton addClientBtn = new JButton("Add Client");
        JButton deleteClientBtn = new JButton("Delete Client");
        JButton searchClientBtn = new JButton("Search Client");
        JButton displayAllClientsBtn = new JButton("Display All Clients");
        JButton updateClientBtn = new JButton("Update Client");
        JButton backBtn = new JButton("Back");

        // Set preferred button size and font (no color for now)
        JButton[] buttons = { addClientBtn, deleteClientBtn, searchClientBtn, displayAllClientsBtn, updateClientBtn, backBtn };
        for (JButton btn : buttons) {
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            sidebar.add(btn);
            sidebar.add(Box.createVerticalStrut(30));
        }

        add(sidebar, BorderLayout.WEST);

        // Dynamic Panel (center)
        JPanel dynamicPanel = new JPanel(new CardLayout());
        dynamicPanel.setBackground(Color.WHITE);
        add(dynamicPanel, BorderLayout.CENTER);

        // Default screen in dynamic panel
        JPanel defaultPanel = new JPanel();
        defaultPanel.setBackground(Color.WHITE);
        JLabel welcomeLabel = new JLabel("Welcome to Client Management Panel");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        welcomeLabel.setForeground(Color.DARK_GRAY);
        defaultPanel.add(welcomeLabel);
        dynamicPanel.add(defaultPanel, "default");

        // Show default panel
        CardLayout cl = (CardLayout) dynamicPanel.getLayout();
        cl.show(dynamicPanel, "default");
//
//        // Placeholder panels for each function
//      JPanel addPanel = new JPanel(); addPanel.add(new JLabel("Add Client Form Coming Soon"));
      dynamicPanel.add(client_Form, "Add Client");
   // The panel of deleting an client
      JPanel delPanel = new JPanel();
      // -- delete panel layout setup --
      delPanel.setLayout(new GridBagLayout());
      GridBagConstraints gbcdel = new GridBagConstraints();
      gbcdel.insets = new Insets(10, 10, 10, 10); // padding
      gbcdel.fill = GridBagConstraints.HORIZONTAL;
      gbcdel.anchor = GridBagConstraints.WEST;

      Font labelFontdel = new Font("Segoe UI", Font.BOLD, 20);
      Font fieldFontdel = new Font("Segoe UI", Font.PLAIN, 18);

      gbcdel.gridx = 0;
      gbcdel.gridy = 0;
      gbcdel.gridwidth = 2;
      JLabel headingdel = new JLabel("Fill the form if you want to delete the client");
      headingdel.setFont(labelFontdel);
      delPanel.add(headingdel, gbcdel);

      // First Name
      gbcdel.gridwidth = 1;
      gbcdel.gridx = 0;
      gbcdel.gridy = 1;
      JLabel fnameLabeldel = new JLabel("First Name:");
      fnameLabeldel.setFont(labelFontdel);
      delPanel.add(fnameLabeldel, gbcdel);

      gbcdel.gridx = 1;
      JTextField fnameFielddel = new JTextField(15);
      fnameFielddel.setFont(fieldFontdel);
      delPanel.add(fnameFielddel, gbcdel);

      // Last Name
      gbcdel.gridx = 0;
      gbcdel.gridy = 2;
      JLabel lnameLabeldel = new JLabel("Last Name:");
      lnameLabeldel.setFont(labelFontdel);
      delPanel.add(lnameLabeldel, gbcdel);

      gbcdel.gridx = 1;
      JTextField lnameFielddel = new JTextField(15);
      lnameFielddel.setFont(fieldFontdel);
      delPanel.add(lnameFielddel, gbcdel);

      // Plot Number
      gbcdel.gridx = 0;
      gbcdel.gridy = 3;
      JLabel plotLabeldel = new JLabel("Plot Number:");
      plotLabeldel.setFont(labelFontdel);
      delPanel.add(plotLabeldel, gbcdel);

      gbcdel.gridx = 1;
      JTextField plotFielddel = new JTextField(15);
      plotFielddel.setFont(fieldFontdel);
      delPanel.add(plotFielddel, gbcdel);

      // Delete Button
      gbcdel.gridx = 0;
      gbcdel.gridy = 4;
      gbcdel.gridwidth = 2;
      gbcdel.anchor = GridBagConstraints.CENTER;
      JButton deleteBtn1del = new JButton("Delete Client");
      deleteBtn1del.setPreferredSize(new Dimension(180, 40));
      deleteBtn1del.setFont(new Font("Segoe UI", Font.BOLD, 18));
      deleteBtn1del.setBackground(Color.RED);
      deleteBtn1del.setForeground(Color.WHITE);
      deleteBtn1del.setFocusPainted(false);
      delPanel.add(deleteBtn1del, gbcdel);

      deleteBtn1del.addActionListener(e -> {
          String firstnameclientstStringdel = fnameFielddel.getText().toLowerCase().trim();
          String lastnameStringdel = lnameFielddel.getText().toLowerCase().trim();
          String Plotnumberdel = plotFielddel.getText();
          int plotnumbervaluedel = 0;

          try {
              plotnumbervaluedel = Integer.parseInt(Plotnumberdel);
          } catch (NumberFormatException e2) {
              JOptionPane.showMessageDialog(this, "Error in converting plot number into integer", "Invalid Plot Number", JOptionPane.ERROR_MESSAGE);
              return;
          }

          // Confirmation dialog
          int confirmdel = JOptionPane.showConfirmDialog(this,
                  "Are you sure you want to delete this client?",
                  "Confirm Deletion",
                  JOptionPane.YES_NO_OPTION,
                  JOptionPane.WARNING_MESSAGE);

          if (confirmdel == JOptionPane.YES_OPTION) {
              //calling the function from client manager
              clientmanager.delClient(firstnameclientstStringdel, lastnameStringdel, plotnumbervaluedel);
              JOptionPane.showMessageDialog(this, "Your client is successfully deleted", "Client Deleted", JOptionPane.INFORMATION_MESSAGE);
          }
      });

      dynamicPanel.add(delPanel, "Delete");

     // ---- Search Client Panel ----
        JPanel searchClientPanel = new JPanel(new GridBagLayout());
        searchClientPanel.setBackground(Color.WHITE);

        GridBagConstraints searchlayout = new GridBagConstraints();
        searchlayout.insets = new Insets(15, 15, 15, 15);
        searchlayout.anchor = GridBagConstraints.WEST;
        searchlayout.fill = GridBagConstraints.HORIZONTAL;

        // ====== HEADING ======
        searchlayout.gridx = 0;
        searchlayout.gridy = 0;
        searchlayout.gridwidth = 2;
        JLabel heading = new JLabel("Fill the data below to search any client");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
        heading.setForeground(Color.DARK_GRAY);
        searchClientPanel.add(heading, searchlayout);

        // ====== Fonts ======
        Font labelFont = new Font("Segoe UI", Font.BOLD, 24);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 20);

        // ====== PLOT NUMBER ======
        searchlayout.gridy++;
        searchlayout.gridx = 0;
        searchlayout.gridwidth = 1;
        JLabel plotLabel = new JLabel("Enter Plot Number:");
        plotLabel.setFont(labelFont);
        searchClientPanel.add(plotLabel, searchlayout);

        searchlayout.gridx = 1;
        JTextField plotnusearch = new JTextField(15);
        plotnusearch.setFont(inputFont);
        searchClientPanel.add(plotnusearch, searchlayout);

        // ====== FIRST NAME ======
        searchlayout.gridy++;
        searchlayout.gridx = 0;
        JLabel fnameLabel = new JLabel("Enter First Name:");
        fnameLabel.setFont(labelFont);
        searchClientPanel.add(fnameLabel, searchlayout);

        searchlayout.gridx = 1;
        JTextField fnamesearch = new JTextField(15);
        fnamesearch.setFont(inputFont);
        searchClientPanel.add(fnamesearch, searchlayout);

        // ====== LAST NAME ======
        searchlayout.gridy++;
        searchlayout.gridx = 0;
        JLabel lnameLabel = new JLabel("Enter Last Name:");
        lnameLabel.setFont(labelFont);
        searchClientPanel.add(lnameLabel, searchlayout);

        searchlayout.gridx = 1;
        JTextField lnamesearch = new JTextField(15);
        lnamesearch.setFont(inputFont);
        searchClientPanel.add(lnamesearch, searchlayout);

        // ====== SEARCH BUTTON ======
        searchlayout.gridy++;
        searchlayout.gridx = 0;
        searchlayout.gridwidth = 2;
        searchlayout.anchor = GridBagConstraints.CENTER;
        JButton searchclientnow = new JButton("Search Client");
        searchclientnow.setFont(new Font("Segoe UI", Font.BOLD, 24));
        searchclientnow.setBackground(new Color(30, 136, 229)); // 🔷 Blue button
        searchclientnow.setForeground(Color.WHITE);
        searchclientnow.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchClientPanel.add(searchclientnow, searchlayout);

        // ====== RESULT PANEL ======
        searchlayout.gridy++;
        searchlayout.gridwidth = 2;
        searchlayout.anchor = GridBagConstraints.WEST;
        JPanel clientResultPanel = new JPanel();
        clientResultPanel.setLayout(new BoxLayout(clientResultPanel, BoxLayout.Y_AXIS));
        clientResultPanel.setBackground(Color.WHITE);
        searchClientPanel.add(clientResultPanel, searchlayout);

        // ====== Add to Dynamic Panel ======
        dynamicPanel.add(searchClientPanel, "SearchClient");

        // ====== Sidebar Action ======
        searchClientBtn.addActionListener(e -> {
            CardLayout c = (CardLayout) dynamicPanel.getLayout();
            c.show(dynamicPanel, "SearchClient");
        });

        // ====== Search Logic ======
        searchclientnow.addActionListener(e -> {
            String plotText = plotnusearch.getText().trim();
            String fnameText = fnamesearch.getText().trim().toLowerCase();

            if (plotText.isEmpty() || fnameText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both Plot Number and First Name.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int plotNumber;
            try {
                plotNumber = Integer.parseInt(plotText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Plot Number must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Client foundClient = clientmanager.searchClient(plotNumber, fnameText);
            clientResultPanel.removeAll();

            if (foundClient != null) {
                Font resultFont = new Font("Segoe UI", Font.PLAIN, 20);
                Font titleFont = new Font("Segoe UI", Font.BOLD, 22);

                JLabel headingofresult = new JLabel("Client Found:");
                headingofresult.setFont(titleFont);
                headingofresult.setForeground(Color.BLUE);
                clientResultPanel.add(headingofresult);

                JLabel nameLabel = new JLabel("Name: " + foundClient.getFirstName() + " " + foundClient.getLastname());
                nameLabel.setFont(resultFont);
                clientResultPanel.add(nameLabel);

                JLabel plotnoresultJLabel = new JLabel("Plot Number: " + foundClient.getPlotnumber());
                plotnoresultJLabel.setFont(resultFont);
                clientResultPanel.add(plotnoresultJLabel);

                JLabel amountLabel = new JLabel("Total Amount: " + foundClient.getTotalmount());
                amountLabel.setFont(resultFont);
                clientResultPanel.add(amountLabel);

                JLabel cnicLabel = new JLabel("CNIC: " + (foundClient.getCnic() != null ? foundClient.getCnic() : "N/A"));
                cnicLabel.setFont(resultFont);
                clientResultPanel.add(cnicLabel);

                JLabel areaLabel = new JLabel("Area of Plot: " + foundClient.getAreaplot());
                areaLabel.setFont(resultFont);
                clientResultPanel.add(areaLabel);
            } else {
                JOptionPane.showMessageDialog(this, "Client not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }

            clientResultPanel.revalidate();
            clientResultPanel.repaint();
        });




     // Main display panel for all clients
        JPanel displayClientJPanel = new JPanel();
        displayClientJPanel.setLayout(new BorderLayout());
        displayClientJPanel.setBackground(Color.white);
        dynamicPanel.add(displayClientJPanel, "Display All Client");

        // Panel to hold all client panels vertically
        JPanel clientAlllistJPanel = new JPanel();
        clientAlllistJPanel.setLayout(new BoxLayout(clientAlllistJPanel, BoxLayout.Y_AXIS));
        clientAlllistJPanel.setBackground(Color.WHITE);

        // Scroll panel
        JScrollPane scrollClientlistJScrollPane = new JScrollPane(clientAlllistJPanel);
        scrollClientlistJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollClientlistJScrollPane.setBorder(null);
        displayClientJPanel.add(scrollClientlistJScrollPane, BorderLayout.CENTER);

        // --- Add client data from listClient() ---
        ArrayList<Client> allClients = clientmanager.listClient();
        if (allClients != null) {
            Font labelFontdisplay = new Font("Segoe UI", Font.PLAIN, 18);

            for (Client c : allClients) {
                JPanel clientPanel = new JPanel();
                clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.Y_AXIS));
                clientPanel.setBackground(new Color(240, 248, 255)); // Light blueish
                clientPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                clientPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
                clientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                clientPanel.setOpaque(true);
                clientPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // Add client details
                clientPanel.add(new JLabel("Name: " + c.getFirstName() + " " + c.getLastname()));
                clientPanel.add(new JLabel("Plot Number: " + c.getPlotnumber()));
                clientPanel.add(new JLabel("Total Amount: " + c.getTotalmount()));
                clientPanel.add(new JLabel("CNIC: " + (c.getCnic() != null ? c.getCnic() : "N/A")));
                clientPanel.add(new JLabel("Area of Plot: " + c.getAreaplot()));

                // Set font
                for (Component comp : clientPanel.getComponents()) {
                    if (comp instanceof JLabel) {
                        comp.setFont(labelFontdisplay);
                    }
                }

                clientAlllistJPanel.add(clientPanel);
                clientAlllistJPanel.add(Box.createVerticalStrut(10)); // space between cards
            }
        } else {
            JLabel emptyLabel = new JLabel("No clients found.");
            emptyLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            emptyLabel.setForeground(Color.RED);
            clientAlllistJPanel.add(emptyLabel);
        }

  
        JPanel updateClientPanel = new JPanel();
        updateClientPanel.setBackground(Color.white);
        updateClientPanel.setLayout(new BorderLayout()); // Set layout to position title at top

        JLabel titleLabel = new JLabel("Update Client Information", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(new Color(0, 102, 204)); // Deep blue

        updateClientPanel.add(titleLabel, BorderLayout.NORTH); 
        // creating inner panel for the inpts of update so no changes
        JPanel innerClientUpdateJPanel=new JPanel(new GridBagLayout());
        updateClientPanel.add(innerClientUpdateJPanel, BorderLayout.CENTER);
        innerClientUpdateJPanel.setOpaque(false);// to keep white background
        GridBagConstraints updateBagConstraints = new GridBagConstraints();
        updateBagConstraints.insets = new Insets(5,10, 10, 10); // top, left, bottom, right
        updateBagConstraints.anchor = GridBagConstraints.WEST;// tell the layout if not fill where to put the content if it's smaller than its cell
        
        //PLot number needed
updateBagConstraints.gridx=0;//first col
updateBagConstraints.gridy=0;//first row

        JLabel plotnumberupdateJLabel=new JLabel("Enter the Plot number:");
                dynamicPanel.add(updateClientPanel, "Update client info");
                plotnumberupdateJLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
innerClientUpdateJPanel.add(plotnumberupdateJLabel,updateBagConstraints);
// the textfield of plot number
updateBagConstraints.gridx=1;

JTextField plotnumberupdaTextField=new JTextField(10);
plotnumberupdaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
innerClientUpdateJPanel.add(plotnumberupdaTextField,updateBagConstraints);

// ====== Field to Update (Dropdown) ======
updateBagConstraints.gridx = 0;//first col
updateBagConstraints.gridy = 1;//second row
JLabel fieldLabel = new JLabel("Field to Update:");
fieldLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
innerClientUpdateJPanel.add(fieldLabel, updateBagConstraints);

updateBagConstraints.gridx = 1;//second col
String[] fieldsTpchangeStrings = { "FirstName", "LastName", "CNIC", "TotalAmount", "AreaPlot" };//string for adding into combo box
JComboBox<String> fieldDropdown = new JComboBox<>(fieldsTpchangeStrings);
fieldDropdown.setFont(new Font("Segoe UI", Font.PLAIN, 18));
innerClientUpdateJPanel.add(fieldDropdown, updateBagConstraints);

// ====== New Value ======
updateBagConstraints.gridx = 0;//first col
updateBagConstraints.gridy = 2;//third row
JLabel newValueLabel = new JLabel("New Value:");
newValueLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
innerClientUpdateJPanel.add(newValueLabel, updateBagConstraints);

updateBagConstraints.gridx = 1;
JTextField newValueField = new JTextField(15);
newValueField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
innerClientUpdateJPanel.add(newValueField, updateBagConstraints);

// ====== Update Button ======
updateBagConstraints.gridx = 0;
updateBagConstraints.gridy = 3;
updateBagConstraints.gridwidth = 2;
updateBagConstraints.anchor = GridBagConstraints.CENTER;
JButton updateBtn = new JButton("Update Info");
updateBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
updateBtn.setBackground(new Color(135, 206, 235)); // Sky blue
updateBtn.setForeground(Color.WHITE);
updateBtn.setFocusPainted(false);
updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
updateBtn.setPreferredSize(new Dimension(180, 40));

// to display messgeases
JLabel messageLabel = new JLabel("");
messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

updateBtn.addActionListener(e -> {
    updateBtn.setBackground(new Color(0, 102, 204)); // Deep blue on press
    String plotStr = plotnumberupdaTextField.getText().trim();
    String selectedField = (String) fieldDropdown.getSelectedItem();
    String newValue = newValueField.getText().trim();

    int plotNumber;
    try {
        plotNumber = Integer.parseInt(plotStr);
    } catch (NumberFormatException ex) {
        messageLabel.setText("Invalid plot number please try again.");
        messageLabel.setForeground(Color.RED);
        return;
    }

    boolean success = clientmanager.updateClientInfo(plotNumber, selectedField, newValue);
    if (success) {
        messageLabel.setText("Update successful!");
        messageLabel.setForeground(new Color(0, 128, 0)); // Green
        return;
    } else {
        messageLabel.setText("Update failed. Please check inputs.");
        messageLabel.setForeground(Color.RED);
    return;
    }
});

innerClientUpdateJPanel.add(updateBtn, updateBagConstraints);
//====== Message Label ======
updateBagConstraints.gridy = 4;//firts row
updateBagConstraints.anchor = GridBagConstraints.WEST;
innerClientUpdateJPanel.add(messageLabel, updateBagConstraints);

//====== Add to Dynamic Panel ======
dynamicPanel.add(updateClientPanel, "Update client info");


// Button Actions
        addClientBtn.addActionListener(e -> cl.show(dynamicPanel, "Add Client"));
        deleteClientBtn.addActionListener(e -> cl.show(dynamicPanel, "Delete"));
        searchClientBtn.addActionListener(e -> cl.show(dynamicPanel, "Search"));
        displayAllClientsBtn.addActionListener(e -> cl.show(dynamicPanel, "Display All Client"));
        updateClientBtn.addActionListener(e -> cl.show(dynamicPanel, "Update client info"));
        backBtn.addActionListener(e -> cards.show(cardContainer, "DASHBOARD"));
            }
}


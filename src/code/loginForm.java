package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Connection.connectionLaundry;

public class loginForm extends JFrame {
    private JPanel panels;
    private JLabel loginBanner;
    private JTextField usernameFields;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton cancelButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton backButton;
    private JComboBox<String> chooseLabel;
    private JLabel chooserLabel;
    private JLabel logos;
    private JTextField usernameField;
    /**
     * The login form class for user authentication.
     */
    private connectionLaundry connectionLaundry;

    public loginForm() {
        connectionLaundry = new connectionLaundry();

        setTitle("Login");
        setContentPane(panels);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 600));
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src/image/laundry.png");
        setIconImage(icon.getImage());

        chooseLabel.addItem("User");
        chooseLabel.addItem("Admin");

        signInButton.addActionListener(new ActionListener() {
            // Get the input values
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String userType = chooseLabel.getSelectedItem().toString();
                // Check login credentials
                boolean loggedIn = connectionLaundry.checkLogin(username, password, userType);

                if (loggedIn) {
                    JOptionPane.showMessageDialog(panels, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Open the main menu form
                    menuForm menuForm = new menuForm();
                    menuForm.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(panels, "Invalid! Please Check It Again!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            // Open the registration form
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationForm registrationForms = new registrationForm();
                registrationForms.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        loginForm form = new loginForm();
    }
}

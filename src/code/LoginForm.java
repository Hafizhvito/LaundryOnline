package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Connection.ConnectionLaundry;


/**
 *
 */
public class LoginForm extends JFrame {
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
    private JTextField usernameField;
    private JPanel sidePanelLogin;
    private JLabel sideImagineLog;
    private JLabel sideTextLogin;
    private JLabel authImage;
    /**
     * The login form class for user authentication.
     */
    private ConnectionLaundry connectionLaundry;
    private String userType;
    private String username;

    public LoginForm() {
        connectionLaundry = new ConnectionLaundry();

        setTitle("Login");
        setContentPane(panels);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 650));
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src/image/laundry.png");
        setIconImage(icon.getImage());

        chooseLabel.addItem("User");
        chooseLabel.addItem("Admin");
        /**
         * Handles the action when the sign-in button is clicked.
         * Gets the input values and checks the login credentials.
         * If the login is successful, displays a success message and opens the main menu form.
         * If the login fails, displays an error message.
         */
        signInButton.addActionListener(new ActionListener() {
            // Get the input values
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText(); // Menggunakan usernameField.getText() untuk mengambil nilai username
                String password = new String(passwordField.getPassword());
                String userType = chooseLabel.getSelectedItem().toString();
                // Check login credentials
                boolean loggedIn = connectionLaundry.checkLogin(username, password, userType);

                if (loggedIn) {
                    JOptionPane.showMessageDialog(panels, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Open the main menu form
                    MenuForm menuForm = new MenuForm();
                    menuForm.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(panels, "Invalid! Please Check It Again!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        /**
         * Handles the action when the back button is clicked.
         * Opens the registration form.
         */
        backButton.addActionListener(new ActionListener() {
            // Open the registration form
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registrationForms = new RegistrationForm();
                registrationForms.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        LoginForm form = new LoginForm();
    }
}
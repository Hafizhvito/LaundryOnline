package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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

    public loginForm() {
        setTitle("Login");
        setContentPane(panels);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(450, 550));
        setResizable(false);
        setLocationRelativeTo(null);

        // Set icon logo
        ImageIcon icon = new ImageIcon("info.png");
        setIconImage(icon.getImage());

        // ComboBox
        chooseLabel.addItem("User");
        chooseLabel.addItem("Admin");

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameFields.getText();
                String password = new String(passwordField.getPassword());
                boolean loggedIn = checkLogin(username, password);

                if (loggedIn) {
                    // Login berhasil
                    JOptionPane.showMessageDialog(panels, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Lanjutkan ke halaman dashboard atau tindakan selanjutnya
                } else {
                    // Login gagal
                    JOptionPane.showMessageDialog(panels, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationForm registrationForms = new registrationForm();
                registrationForms.setVisible(true);
                dispose(); // Close the LoginForm
            }
        });
        setVisible(true);
    }


    private boolean checkLogin(String username, String password) {
        boolean loggedIn = false;
        String url = "jdbc:mysql://localhost:3306/library";

        try {
            // Membuat koneksi ke database
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Membuat statement SQL untuk melakukan pengecekan username dan password
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Mengeksekusi statement SQL
            ResultSet resultSet = statement.executeQuery();

            // Mengecek apakah hasil query menghasilkan baris data atau tidak
            if (resultSet.next()) {
                // Username dan password cocok
                loggedIn = true;
            }

            // Menutup koneksi dan sumber daya yang digunakan
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedIn;
    }
    public static void main(String[] args) {

        loginForm form = new loginForm();
    }
}

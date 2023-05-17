package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrationForm extends JFrame {
    private JPanel panel;
    private JLabel registrationLabel;
    private JLabel usernameLabel;
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton registerButton;
    private JButton exitButton;
    private JButton haveAccountButton;
    private JTextField addressField;
    private JLabel addressLabel;
    private JLabel registrationLogo;
    private JTextField teleponField;
    private JLabel teleponLabel;
    private JLabel passwordLabel;

    public registrationForm() {
        setTitle("Registration");
        setContentPane(panel);
        setMinimumSize(new Dimension(450, 550));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // menambahkan validasi pada inputan username dan password sebelum registerButton ditekan!
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String address = addressField.getText();
                String telepon = teleponField.getText();

                // Bagian ini adalah bagian untuk mengecek apakah field sudah terisi dengan benar atau belum
                boolean hasUppercase = false;
                for (char c : username.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        hasUppercase = true;
                        break;
                    }
                }

                // Mengecek apakah "Nomor Telepon" hanya berisi angka
                boolean isNumeric = telepon.matches("\\d+");

                if (username.isEmpty() || password.isEmpty() || address.isEmpty() || telepon.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all the required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isNumeric) {
                    JOptionPane.showMessageDialog(panel, "Nomor Telepon must contain only numeric characters!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (password.length() < 8) {
                    JOptionPane.showMessageDialog(panel, "Password must be at least 8 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!hasUppercase) {
                    JOptionPane.showMessageDialog(panel, "Username must include at least one uppercase letter!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Congratulations, you have successfully registered your account!", "Error", JOptionPane.ERROR_MESSAGE);
                    loginForm loginForm = new loginForm();
                    loginForm.setVisible(true);
                    setVisible(false);
                }
            }
        });

        // menambahkan ikon pada exitButton
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Opsi ketika memilih exit
                int confirm = JOptionPane.showConfirmDialog(panel, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // menambahkan fungsi pada tombol haveAccountButton agar dapat mengarahkan user ke halaman login!
        haveAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginForm loginForm = new loginForm();
                loginForm.setVisible(true);
                setVisible(false);
            }
        });
        setVisible(true);
    }
}


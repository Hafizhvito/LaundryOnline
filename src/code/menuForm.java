package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuForm extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel buttonPanel;
    private JPanel parentPanel;
    private JButton profileButton;
    private JButton dashboardButton;
    private JButton orderButton;
    private JButton informationButton;
    private JPanel cardOnePanel;
    private JPanel cardTwoPanel;
    private JPanel cardThreePanel;
    private JPanel cardFourPanel;
    private JLabel profileLabel;
    private JLabel dashboardLabel;
    private JLabel orderLabel;
    private JLabel informationLabel;
    private CardLayout cardLayout;

    public menuForm() {
        setTitle("Home");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 650));
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        parentPanel.setLayout(cardLayout);

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "cardOnePanel"); // Menampilkan cardOnePanel
            }
        });

        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "cardTwoPanel"); // Menampilkan cardTwoPanel
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "cardThreePanel"); // Menampilkan cardThreePanel
            }
        });

        informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "cardFourPanel"); // Menampilkan cardFourPanel
            }
        });

        // Tambahkan panel-panel ke parentPanel dengan nama yang sesuai
        parentPanel.add(cardOnePanel, "cardOnePanel");
        parentPanel.add(cardTwoPanel, "cardTwoPanel");
        parentPanel.add(cardThreePanel, "cardThreePanel");
        parentPanel.add(cardFourPanel, "cardFourPanel");

        ImageIcon icon = new ImageIcon("src/image/laundry.png");
        setIconImage(icon.getImage());

        setVisible(true);
    }
}

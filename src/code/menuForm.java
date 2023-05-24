package code;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;

import Connection.connectionLaundry;

public class menuForm extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel buttonPanel;
    private JPanel parentPanel;
    private JButton profileButton;
    private JButton jenisCucianButton;
    private JButton orderButton;
    private JButton informationButton;
    private JPanel cardOnePanel;
    private JPanel cardTwoPanel;
    private JPanel cardThreePanel;
    private JPanel cardFourPanel;
    private JPanel botPanelDasboard;
    private JPanel botPanelProfile;
    private JTextField nameFieldProfile;
    private JTextField passwordFieldProfile;
    private JTextField phoneNumberField;
    private JButton addingButtonPro;
    private JButton deleteButtonPro;
    private JButton changeButtonPro;
    private JButton saveButtonPro;
    private JLabel idProfile;
    private JLabel namaProfile;
    private JLabel addressPro;
    private JLabel phoneNumbPro;
    private JLabel textProfile;
    private JTextField addressFieldProfile;
    private JLabel passwordPro;
    private JComboBox accessBoxPro;
    private JLabel registAsPro;
    private JPanel botPanelOrder;
    private JLabel textOrder;
    private JTextField noOrderField;
    private JTextField costumerField;
    private JComboBox boxLaundryType;
    private JTextField totalField;
    private JTextField payField;
    private JTextField rmField;
    private JTextField statusField;
    private JButton addOrderButton;
    private JButton saveOrderButtton;
    private JLabel noOrder;
    private JLabel costumerOrder;
    private JLabel laundryTypeOrder;
    private JLabel weightOrder;
    private JComboBox boxWeight;
    private JLabel totalOrder;
    private JLabel paydepoOrder;
    private JLabel remainingBalance;
    private JLabel statusOrder;
    private JTable profileTable;
    private JScrollPane scrollpaneProfile;
    private JPanel profileTablePanel;
    private JPanel laundryTypePanel;
    private JTable laundryTypeTable;
    private JScrollPane scrollpaneLaundryType;
    private JPanel orderTablePanel;
    private JScrollPane scrollpaneOrder;
    private JTable orderTable;
    private JButton refreshButton;
    private JTextField autoGenerateTextField;
    private JTextField autoGenerateField;
    private JTextField laundryTypeField;
    private JTextField laundryPriceField;
    private JButton addButtonLaundry;
    private JButton deleteButtonLaundry;
    private JButton refreshButtonLaundry;
    private JButton changeButtonLaundry;
    private JButton saveButtonLaundry;
    private JLabel textLaundryType;
    private JLabel topText;
    private JLabel idLaundryType;
    private JLabel laundryTypeLabel;
    private JLabel laundryPrice;
    private CardLayout cardLayout;
    private JComboBox<String> accessComboBox;
    private ProfileManager profileManager;
    private LaundryTypeManager laundryTypeManager;
    private Connection connection;


    public menuForm() {
        setTitle("Home");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 800));
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        parentPanel.setLayout(cardLayout);

        connectionLaundry connection = new connectionLaundry();
        this.profileManager = new ProfileManager(connection.getConnection());

        LaundryTypeManager laundryTypeManager = new LaundryTypeManager(connection.getConnection());
        this.laundryTypeManager = laundryTypeManager;

        initializeProfileTable();

        initializeLaundryTypeTable();

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "cardOnePanel"); // Menampilkan cardOnePanel
            }
        });

        jenisCucianButton.addActionListener(new ActionListener() {
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
        addingButtonPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProfile();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshProfileTable();
            }
        });

        deleteButtonPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProfile();
            }
        });
        changeButtonPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeProfile();
            }
        });

        saveButtonPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProfile();
            }
        });

        addButtonLaundry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLaundryType();
            }
        });

        refreshButtonLaundry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshLaundryTypeTable();
            }
        });

        deleteButtonLaundry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLaundryType();
            }
        });

        changeButtonLaundry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLaundryType();
            }
        });

        saveButtonLaundry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLaundryType();
            }
        });

        setVisible(true);
    }

    private void addLaundryType() {
        String laundryType = laundryTypeField.getText();
        String priceString = laundryPriceField.getText();

        if (laundryType.isEmpty() || priceString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price = Double.parseDouble(priceString);
        LaundryType newLaundryType = new LaundryType(laundryType, price);
        laundryTypeManager.addLaundryType(newLaundryType);

        DefaultTableModel laundryTypeTableModel = (DefaultTableModel) laundryTypeTable.getModel();
        laundryTypeTableModel.addRow(new Object[]{newLaundryType.getId(), laundryType, price});

        laundryTypeField.setText("");
        laundryPriceField.setText("");
    }


    private void deleteLaundryType() {
        int selectedRow = laundryTypeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select data from the table.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel laundryTypeTableModel = (DefaultTableModel) laundryTypeTable.getModel();
        int laundryTypeId = Integer.parseInt(laundryTypeTableModel.getValueAt(selectedRow, 0).toString());
        laundryTypeTableModel.removeRow(selectedRow);
        laundryTypeManager.deleteLaundryType(laundryTypeId);
    }


    private void changeLaundryType() {
        int selectedRow = laundryTypeTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel laundryTypeTableModel = (DefaultTableModel) laundryTypeTable.getModel();
            int laundryTypeId = (int) laundryTypeTableModel.getValueAt(selectedRow, 0);
            String laundryType = laundryTypeTableModel.getValueAt(selectedRow, 1).toString();
            String price = laundryTypeTableModel.getValueAt(selectedRow, 2).toString();

            laundryTypeField.setText(laundryType);
            laundryPriceField.setText(price);
        }
    }

    private void saveLaundryType() {
        DefaultTableModel laundryTypeTableModel = (DefaultTableModel) laundryTypeTable.getModel();
        int rowCount = laundryTypeTableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int laundryTypeId = Integer.parseInt(laundryTypeTableModel.getValueAt(i, 0).toString());
            String laundryType = laundryTypeTableModel.getValueAt(i, 1).toString();
            String priceString = laundryTypeTableModel.getValueAt(i, 2).toString();
            double price = Double.parseDouble(priceString);

            LaundryType existingLaundryType = laundryTypeManager.getLaundryTypeById(laundryTypeId);
            if (existingLaundryType != null) {
                existingLaundryType.setLaundryType(laundryType);
                existingLaundryType.setPrice(price);
                laundryTypeManager.updateLaundryType(existingLaundryType);
            } else {
                LaundryType newLaundryType = new LaundryType(laundryType, price);
                laundryTypeManager.addLaundryType(newLaundryType);
            }
        }
    }


    private void initializeLaundryTypeTable() {
        DefaultTableModel laundryTypeTableModel = new DefaultTableModel();
        laundryTypeTableModel.addColumn("ID");
        laundryTypeTableModel.addColumn("Laundry Type");
        laundryTypeTableModel.addColumn("Price");

        laundryTypeTable.setModel(laundryTypeTableModel);

        refreshLaundryTypeTable();
    }

    private void refreshLaundryTypeTable() {
        DefaultTableModel laundryTypeTableModel = (DefaultTableModel) laundryTypeTable.getModel();
        laundryTypeTableModel.setRowCount(0);

        List<LaundryType> laundryTypes = laundryTypeManager.getAllLaundryTypes();

        for (LaundryType laundryType : laundryTypes) {
            laundryTypeTableModel.addRow(new Object[]{laundryType.getId(), laundryType.getLaundryType(), laundryType.getPrice()});
        }
    }

    private void addProfile() {
        String name = nameFieldProfile.getText();
        String address = addressFieldProfile.getText();
        String phoneNumber = phoneNumberField.getText();
        String password = passwordFieldProfile.getText();
        String access = accessComboBox.getSelectedItem().toString();

        // Validasi field kosong
        if (name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validasi username dengan huruf kapital
        if (!name.matches(".*[A-Z].*")) {
            JOptionPane.showMessageDialog(this, "Username must contain at least one capital letter.");
            return;
        }

        // Validasi password minimal 8 karakter
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long.");
            return;
        }

        // Validasi nomor telepon hanya angka
        if (!phoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter digits only.");
            return;
        }

        // Semua validasi berhasil, tambahkan data ke tabel dan kosongkan input fields
        Profile profile = new Profile(name, address, phoneNumber, password, access);
        profileManager.addProfile(profile);

        DefaultTableModel profileTableModel = (DefaultTableModel) profileTable.getModel();
        profileTableModel.addRow(new Object[]{profile.getId(), name, address, phoneNumber, password, access});

        nameFieldProfile.setText("");
        addressFieldProfile.setText("");
        phoneNumberField.setText("");
        passwordFieldProfile.setText("");
        accessComboBox.setSelectedIndex(0);
    }

    private void deleteProfile() {
        int selectedRow = profileTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select data from the table.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel profileTableModel = (DefaultTableModel) profileTable.getModel();
        int profileId = Integer.parseInt(profileTableModel.getValueAt(selectedRow, 0).toString());
        profileTableModel.removeRow(selectedRow);
        profileManager.deleteProfile(profileId);
    }

    private void changeProfile() {
        int selectedRow = profileTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel profileTableModel = (DefaultTableModel) profileTable.getModel();
            int profileId = (int) profileTableModel.getValueAt(selectedRow, 0);
            String name = profileTableModel.getValueAt(selectedRow, 1).toString();
            String address = profileTableModel.getValueAt(selectedRow, 2).toString();
            String phoneNumber = profileTableModel.getValueAt(selectedRow, 3).toString();
            String password = profileTableModel.getValueAt(selectedRow, 4).toString();
            String access = profileTableModel.getValueAt(selectedRow, 5).toString();

            // Validate password length
            if (password.length() >= 8) {
                // Validate username with capital letters
                if (name.matches(".*[A-Z].*")) {
                    // Validate phoneNumber with digits only
                    if (phoneNumber.matches("\\d+")) {
                        // Validate access from comboBox
                        String selectedAccess = accessComboBox.getSelectedItem().toString();
                        if (selectedAccess.equals("User") || selectedAccess.equals("Admin")) {
                            // Update the values in the table
                            profileTableModel.setValueAt(name, selectedRow, 1);
                            profileTableModel.setValueAt(address, selectedRow, 2);
                            profileTableModel.setValueAt(phoneNumber, selectedRow, 3);
                            profileTableModel.setValueAt(password, selectedRow, 4);
                            profileTableModel.setValueAt(selectedAccess, selectedRow, 5);

                            // Update the profile in ProfileManager
                            Profile profile = new Profile(profileId, name, address, phoneNumber, password, selectedAccess);
                            profileManager.updateProfile(profile);
                        } else {
                            // Access is invalid
                            JOptionPane.showMessageDialog(this, "Invalid access selection. Please select 'User' or 'Admin'.");
                        }
                    } else {
                        // phoneNumber is invalid
                        JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter digits only.");
                    }
                } else {
                    // username does not contain capital letters
                    JOptionPane.showMessageDialog(this, "Username must contain at least one capital letter.");
                }
            } else {
                // password is too short
                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long.");
            }
        }
    }


    private void saveProfile() {
        DefaultTableModel profileTableModel = (DefaultTableModel) profileTable.getModel();
        int rowCount = profileTableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int profileId = Integer.parseInt(profileTableModel.getValueAt(i, 0).toString());

            // Check if profileId already exists in the data source
            Profile existingProfile = profileManager.getProfileById(profileId);
            if (existingProfile == null) {
                String name = profileTableModel.getValueAt(i, 1).toString();
                String address = profileTableModel.getValueAt(i, 2).toString();
                String phoneNumber = profileTableModel.getValueAt(i, 3).toString();
                String password = profileTableModel.getValueAt(i, 4).toString();
                String access = profileTableModel.getValueAt(i, 5).toString();

                Profile profile = new Profile(name, address, phoneNumber, password, access);
                profileManager.addProfile(profile);
            }
        }
    }


    private void initializeProfileTable() {
        DefaultTableModel profileTableModel = new DefaultTableModel();
        profileTableModel.addColumn("ID");
        profileTableModel.addColumn("Name");
        profileTableModel.addColumn("Address");
        profileTableModel.addColumn("Phone Number");
        profileTableModel.addColumn("Password");
        profileTableModel.addColumn("Access");

        profileTable.setModel(profileTableModel);

        accessComboBox = new JComboBox<>(new String[]{"User", "Admin"}); // Pindahkan inisialisasi ke sini
        TableColumn accessColumn = profileTable.getColumnModel().getColumn(5);
        accessColumn.setCellEditor(new DefaultCellEditor(accessComboBox));

        refreshProfileTable();
    }


    private void refreshProfileTable() {
        DefaultTableModel profileTableModel = (DefaultTableModel) profileTable.getModel();
        profileTableModel.setRowCount(0);

        List<Profile> profiles = profileManager.getAllProfiles();

        for (Profile profile : profiles) {
            profileTableModel.addRow(new Object[]{profile.getId(), profile.getName(), profile.getAddress(), profile.getPhoneNumber(), profile.getPassword(), profile.getAccess()});
        }
    }
}

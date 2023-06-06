package code;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;
import Connection.ConnectionLaundry;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Represents a menu form in a laundry management system.
 * This form displays the menu options and handles user input.
 */
public class MenuForm extends JFrame {
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
    private JTextField idOrderField;
    private JTextField customerField;
    private JTextField totalField;
    private JTextField paymentField;
    private JTextField remainingBalanceField;
    private JTextField statusField;
    private JButton addOrderButton;
    private JButton saveOrderButtton;
    private JLabel idOrder;
    private JLabel customerOrder;
    private JLabel laundryTypeOrder;
    private JLabel weightOrder;
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
    private JButton deleteOrderButton;
    private JButton refreshOrderButton;
    private JButton changeOrderButton;
    private CardLayout cardLayout;
    private ProfileManager profileManager;
    private LaundryTypeManager laundryTypeManager;
    private OrderManager orderManager;
    private Connection connection;
    private JTextField weightOrderField;
    private JComboBox<String> boxLaundryType;
    private JButton button1;
    private JTextPane laundrykuAdalahSebuahAplikasiTextPane;

    public MenuForm() {
        setTitle("Home");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 800));
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        parentPanel.setLayout(cardLayout);

        ConnectionLaundry connection = new ConnectionLaundry();
        this.profileManager = new ProfileManager(connection.getConnection());

        LaundryTypeManager laundryTypeManager = new LaundryTypeManager(connection.getConnection());
        this.laundryTypeManager = laundryTypeManager;

        OrderManager orderManager = new OrderManager(connection.getConnection());
        this.orderManager = orderManager;

        orderManager.refreshLaundryTypeComboBox(boxLaundryType);


        accessBoxPro.addItem("User");
        accessBoxPro.addItem("Admin");

        initializeProfileTable();

        initializeLaundryTypeTable();

        initializeOrderTable();

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

        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrderButton();
            }
        });

        deleteOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteOrderButton();
            }
        });

        refreshOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshOrderTable();
            }
        });

        changeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeOrderButton();
            }
        });

        saveOrderButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveOrderButton();
            }
        });

        setVisible(true);
<<<<<<< HEAD
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
                setVisible(false);
            }
        });
    }

    // Fungsi untuk halaman Order
=======
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                LoginForm loginForm = new LoginForm();
//                loginForm.setVisible(true);
//                setVisible(false);
//            }
//        });
    }

    // untuk halaman order
>>>>>>> main
    private void addOrderButton() {
        String customer = customerField.getText();
        String weight = weightOrderField.getText();
        String payment = paymentField.getText();

        if (customer.isEmpty() || weight.isEmpty() || payment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String selectedLaundryTypeName = (String) boxLaundryType.getSelectedItem();
            String[] parts = selectedLaundryTypeName.split(" - ");
            String laundryType = parts[0];
            double price = Double.parseDouble(parts[1]);
            double weightValue = Double.parseDouble(weight);
            double paymentValue = Double.parseDouble(payment);
            int total = (int) (weightValue * price);
            int remainingBalance = (int) (paymentValue - total);

            String status = (remainingBalance < 0) ? "Unpaid" : "Settled";

            // Menambahkan order ke database menggunakan OrderManager
            Order order = new Order(customer, laundryType, weight, String.valueOf(total), payment,
                    String.valueOf(remainingBalance), status);
            orderManager.addOrder(order);

            // Mendapatkan ID yang baru dibuat
            int newOrderId = order.getId();

            DefaultTableModel orderTableModel = (DefaultTableModel) orderTable.getModel();
            Object[] rowData = {
                    newOrderId,
                    customer,
                    selectedLaundryTypeName,
                    weight,
                    String.valueOf(total),
                    payment,
                    String.valueOf(remainingBalance),
                    status
            };
            orderTableModel.addRow(rowData);

            JOptionPane.showMessageDialog(this, "Order added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteOrderButton() {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select data from the table.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this order?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        DefaultTableModel orderTableModel = (DefaultTableModel) orderTable.getModel();
        String id = orderTableModel.getValueAt(selectedRow, 0).toString();
        orderTableModel.removeRow(selectedRow);
        orderManager.deleteOrder(id);
    }

    private void changeOrderButton() {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel orderTableModel = (DefaultTableModel) orderTable.getModel();
            String id = orderTableModel.getValueAt(selectedRow, 0).toString();
            String customer = orderTableModel.getValueAt(selectedRow, 1).toString();
            String laundryType = orderTableModel.getValueAt(selectedRow, 2).toString();
            String weight = orderTableModel.getValueAt(selectedRow, 3).toString();
            String total = orderTableModel.getValueAt(selectedRow, 4).toString();
            String payment = orderTableModel.getValueAt(selectedRow, 5).toString();
            double remainingBalance = Double.parseDouble(orderTableModel.getValueAt(selectedRow, 6).toString());
            String status = orderTableModel.getValueAt(selectedRow, 7).toString();

            idOrderField.setText(id);
            customerField.setText(customer);
            boxLaundryType.setSelectedItem(laundryType);
            weightOrderField.setText(weight);
            totalField.setText(total);
            paymentField.setText(payment);
            remainingBalanceField.setText(String.valueOf(remainingBalance));
            statusField.setText(status);

            // Jika remainingBalance < 0 dan status unpaid, dan payment sesuai dengan total
            if (remainingBalance < 0 && status.equals("Unpaid") && Double.parseDouble(payment) == Double.parseDouble(total)) {
                remainingBalanceField.setText("0");
                statusField.setText("Settled");
            } else {
                double updatedRemainingBalance = Double.parseDouble(payment) - Double.parseDouble(total);
                remainingBalanceField.setText(String.valueOf(updatedRemainingBalance));
                statusField.setText(updatedRemainingBalance < 0 ? "Unpaid" : "Settled");
            }
        }
    }

    private void saveOrderButton() {
        String idText = idOrderField.getText();
        String customer = customerField.getText();
        String laundryType = boxLaundryType.getSelectedItem().toString();
        String weight = weightOrderField.getText();
        String payment = paymentField.getText();
        String total = totalField.getText();
        double remainingBalance = Double.parseDouble(remainingBalanceField.getText());
        String status = remainingBalance < 0 ? "Unpaid" : "Settled";

        if (customer.isEmpty() || laundryType.isEmpty() || weight.isEmpty() || payment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Order order;
            if (!idText.isEmpty()) {
                int id = Integer.parseInt(idText);
                order = orderManager.getOrderById(id);
                if (order == null) {
                    JOptionPane.showMessageDialog(this, "Order not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                order = new Order(customer, laundryType, weight, total, payment, String.valueOf(remainingBalance), status);
            }

            order.setCustomer(customer);
            order.setLaundryType(laundryType);
            order.setWeight(weight);
            order.setTotal(total);
            order.setPayment(payment);
            order.setRemainingBalance(String.valueOf(remainingBalance));
            order.setStatus(status);

            if (order.getId() == 0) {
                orderManager.addOrder(order);
            } else {
                orderManager.updateOrder(order);
            }

            JOptionPane.showMessageDialog(this, "Order saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

            refreshOrderTable();

            idOrderField.setText("");
            customerField.setText("");
            boxLaundryType.setSelectedIndex(0);
            weightOrderField.setText("");
            paymentField.setText("");
            totalField.setText("");
            remainingBalanceField.setText("");
            statusField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initializeOrderTable() {
        DefaultTableModel orderTableModel = new DefaultTableModel();
        orderTableModel.addColumn("ID");
        orderTableModel.addColumn("Customer");
        orderTableModel.addColumn("Laundry Type");
        orderTableModel.addColumn("Weight");
        orderTableModel.addColumn("Total");
        orderTableModel.addColumn("Payment");
        orderTableModel.addColumn("Outstanding Payment");
        orderTableModel.addColumn("Status");

        orderTable.setModel(orderTableModel);

        refreshOrderTable();
    }

    private void refreshOrderTable() {
        DefaultTableModel orderTableModel = (DefaultTableModel) orderTable.getModel();
        orderTableModel.setRowCount(0);

        List<Order> orders = orderManager.getAllOrders();
        for (Order order : orders) {
            String status = (Double.parseDouble(order.getRemainingBalance()) < 0) ? "Unpaid" : "Settled";
            order.setStatus(status);

            Object[] rowData = {
                    order.getId(),
                    order.getCustomer(),
                    order.getLaundryType(),
                    order.getWeight(),
                    order.getTotal(),
                    order.getPayment(),
                    order.getRemainingBalance(),
                    order.getStatus()
            };
            orderTableModel.addRow(rowData);
        }
<<<<<<< HEAD
    }

=======

        // Mendapatkan semua tipe Laundry dari laundryTypeManager
        List<LaundryType> laundryTypes = laundryTypeManager.getAllLaundryTypes();

        // Menghapus semua item pada BoxLaundryType
        boxLaundryType.removeAllItems();

        // Menambahkan tipe Laundry ke BoxLaundryType
        for (LaundryType laundryType : laundryTypes) {
            boxLaundryType.addItem(laundryType.getLaundryType() + " - " + laundryType.getPrice());
        }
    }


>>>>>>> main
    private void calculateTotalAndRemainingBalance() {
        String weight = weightOrderField.getText();
        String payment = paymentField.getText();

        if (!weight.isEmpty() && !payment.isEmpty()) {
            try {
                double weightValue = Double.parseDouble(weight);
                double paymentValue = Double.parseDouble(payment);

                double total = weightValue * calculateLaundryTypePrice();
                double remainingBalance = paymentValue - total;

                totalField.setText(String.valueOf(total));
                remainingBalanceField.setText(String.valueOf(remainingBalance));

                String status = (remainingBalance < 0) ? "Unpaid" : "Settled";
                statusField.setText(status);
            } catch (NumberFormatException e) {
                totalField.setText("");
                remainingBalanceField.setText("");
                statusField.setText("");
            }
        } else {
            totalField.setText("");
            remainingBalanceField.setText("");
            statusField.setText("");
        }
    }

    private double calculateLaundryTypePrice() {
        return 0;
    }

<<<<<<< HEAD
    // Fungsi Untuk halaman LaundryType
=======
    // Untuk halaman LaundryType
>>>>>>> main
    private void addLaundryType() {
        String laundryType = laundryTypeField.getText();
        String priceString = laundryPriceField.getText();

        if (laundryType.isEmpty() || priceString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String formattedPrice = String.valueOf(price); // Mengkonversi harga menjadi string tanpa perubahan format
        LaundryType newLaundryType = new LaundryType(laundryType, formattedPrice);
        laundryTypeManager.addLaundryType(newLaundryType);

        DefaultTableModel laundryTypeTableModel = (DefaultTableModel) laundryTypeTable.getModel();
        laundryTypeTableModel.addRow(new Object[]{newLaundryType.getId(), laundryType, formattedPrice});

        laundryTypeField.setText("");
        laundryPriceField.setText("");

        JOptionPane.showMessageDialog(this, "Laundry type added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    private void deleteLaundryType() {
        int selectedRow = laundryTypeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select data from the table.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this laundry type?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
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

            LaundryType existingLaundryType = laundryTypeManager.getLaundryTypeById(laundryTypeId);
            if (existingLaundryType != null) {
                existingLaundryType.setLaundryType(laundryType);
                existingLaundryType.setPrice(priceString); // Menggunakan kembali format harga yang ada pada tabel
                laundryTypeManager.updateLaundryType(existingLaundryType);
            } else {
                LaundryType newLaundryType = new LaundryType(laundryType, priceString);
                laundryTypeManager.addLaundryType(newLaundryType);
            }
        }
        // Clear the fields
        laundryTypeField.setText("");
        laundryPriceField.setText("");
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

        // Hapus semua baris yang ada pada tabel
        laundryTypeTableModel.setRowCount(0);

        // Format angka tanpa titik
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        DecimalFormatSymbols symbols = decimalFormat.getDecimalFormatSymbols();
        symbols.setGroupingSeparator('\0'); // Menghapus simbol grup
        decimalFormat.setDecimalFormatSymbols(symbols);

        // Tambahkan data dari database ke dalam tabel
        List<LaundryType> laundryTypes = laundryTypeManager.getAllLaundryTypes();
        for (LaundryType laundryType : laundryTypes) {
            String formattedPrice = decimalFormat.format(Double.parseDouble(laundryType.getPrice()));
            Object[] rowData = new Object[]{
                    laundryType.getId(),
                    laundryType.getLaundryType(),
                    formattedPrice
            };
            laundryTypeTableModel.addRow(rowData);
        }
    }

<<<<<<< HEAD
    // Fungsi untuk halaman Profile

=======
    // Untuk halaman Profile
>>>>>>> main
    private void addProfile() {
        String name = nameFieldProfile.getText();
        String address = addressFieldProfile.getText();
        String phoneNumber = phoneNumberField.getText();
        String password = passwordFieldProfile.getText();
        String access = accessBoxPro.getSelectedItem().toString();

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
        accessBoxPro.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Profile added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    private void deleteProfile() {
        int selectedRow = profileTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select data from the table.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this profile?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
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
            int profileId = Integer.parseInt(profileTableModel.getValueAt(selectedRow, 0).toString());
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
                        String selectedAccess = accessBoxPro.getSelectedItem().toString();
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

        refreshProfileTable();
        // Clear the fields
        nameFieldProfile.setText("");
        addressFieldProfile.setText("");
        phoneNumberField.setText("");
        passwordFieldProfile.setText("");
        accessBoxPro.setSelectedIndex(0);
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

        TableColumn accessColumn = profileTable.getColumnModel().getColumn(5);
<<<<<<< HEAD
        JComboBox<String> accessBoxPro = new JComboBox<>(new String[]{"User", "Admin"});
        accessColumn.setCellEditor(new DefaultCellEditor(accessBoxPro));
=======
        accessBoxPro = new JComboBox<>(new String[]{"User", "Admin"}); // Declare accessBoxPro at the class level
        accessColumn.setCellEditor(new DefaultCellEditor(accessBoxPro));

        // Add a TableModelListener to detect changes in the table
        profileTableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                if (column == 5) {
                    String selectedAccess = profileTableModel.getValueAt(row, column).toString();
                    accessBoxPro.setSelectedItem(selectedAccess);
                }
            }
        });
>>>>>>> main

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
<<<<<<< HEAD
}

=======
}
>>>>>>> main

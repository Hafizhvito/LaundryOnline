package code;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderManager {
    private Connection connection;
    private LaundryTypeManager laundryTypeManager;
    public OrderManager(Connection connection) {
        this.connection = connection;
    }

    public void addOrder(Order order) {
        String query = "INSERT INTO orders (customer, laundry_type, weight, total_price, payment, remaining_balance, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, order.getCustomer());
            statement.setString(2, order.getLaundryType());
            statement.setString(3, String.valueOf(order.getWeight()));
            statement.setString(4, order.getTotal());
            statement.setString(5, order.getPayment());
            statement.setString(6, order.getRemainingBalance());
            statement.setString(7, order.getStatus());
            statement.executeUpdate();

            // Mendapatkan ID yang baru dibuat
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                order.setId(generatedId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
    }

    public void updateOrder(Order order) {
        String query = "UPDATE orders SET customer = ?, laundry_type = ?, weight = ?, total_price = ?, payment = ?, " +
                "remaining_balance = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, order.getCustomer());
            statement.setString(2, order.getLaundryType());
            statement.setString(3, String.valueOf(order.getWeight()));
            statement.setString(4, order.getTotal());
            statement.setString(5, order.getPayment());
            statement.setString(6, order.getRemainingBalance());
            statement.setString(7, order.getStatus());
            statement.setInt(8, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(String id) {
        String query = "DELETE FROM orders WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String customer = resultSet.getString("customer");
                String laundryType = resultSet.getString("laundry_type");
                String weight = resultSet.getString("weight");
                String total = resultSet.getString("total_price");
                String payment = resultSet.getString("payment");
                String remainingBalance = resultSet.getString("remaining_balance");
                String status = resultSet.getString("status");
                Order order = new Order(id, customer, laundryType, weight, total, payment, remainingBalance, status);

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order getOrderById(int id) {
        String query = "SELECT * FROM orders WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String customer = resultSet.getString("customer");
                String laundryType = resultSet.getString("laundry_type");
                String weight = resultSet.getString("weight");
                String total = resultSet.getString("total_price");
                String payment = resultSet.getString("payment");
                String remainingBalance = resultSet.getString("remaining_balance");
                String status = resultSet.getString("status");
                return new Order(id, customer, laundryType, weight, total, payment, remainingBalance, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void refreshLaundryTypeComboBox(JComboBox<String> boxLaundryType) {
        // Hapus semua item yang ada pada combobox
        boxLaundryType.removeAllItems();

        // Tambahkan data dari tabel LaundryType ke dalam boxLaundryType
        try {
            String query = "SELECT laundry_type, price FROM laundry_types";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String laundryType = resultSet.getString("laundry_type");
                String price = resultSet.getString("price");
                boxLaundryType.addItem(laundryType + " - "  + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
=======
>>>>>>> main
    }

    public void updateOrder(Order order) {
        String query = "UPDATE orders SET customer = ?, laundry_type = ?, weight = ?, total_price = ?, payment = ?, " +
                "remaining_balance = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, order.getCustomer());
            statement.setString(2, order.getLaundryType());
            statement.setString(3, String.valueOf(order.getWeight()));
            statement.setString(4, order.getTotal());
            statement.setString(5, order.getPayment());
            statement.setString(6, order.getRemainingBalance());
            statement.setString(7, order.getStatus());
            statement.setInt(8, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(String id) {
        String query = "DELETE FROM orders WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String customer = resultSet.getString("customer");
                String laundryType = resultSet.getString("laundry_type");
                String weight = resultSet.getString("weight");
                String total = resultSet.getString("total_price");
                String payment = resultSet.getString("payment");
                String remainingBalance = resultSet.getString("remaining_balance");
                String status = resultSet.getString("status");
                Order order = new Order(id, customer, laundryType, weight, total, payment, remainingBalance, status);

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order getOrderById(int id) {
        String query = "SELECT * FROM orders WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String customer = resultSet.getString("customer");
                String laundryType = resultSet.getString("laundry_type");
                String weight = resultSet.getString("weight");
                String total = resultSet.getString("total_price");
                String payment = resultSet.getString("payment");
                String remainingBalance = resultSet.getString("remaining_balance");
                String status = resultSet.getString("status");
                return new Order(id, customer, laundryType, weight, total, payment, remainingBalance, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void refreshLaundryTypeComboBox(JComboBox<String> boxLaundryType) {
        // Hapus semua item yang ada pada combobox
        boxLaundryType.removeAllItems();

        // Tambahkan data dari tabel LaundryType ke dalam boxLaundryType
        try {
            String query = "SELECT laundry_type, price FROM laundry_types";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String laundryType = resultSet.getString("laundry_type");
                String price = resultSet.getString("price");
                boxLaundryType.addItem(laundryType + " - "  + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
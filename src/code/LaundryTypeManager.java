package code;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaundryTypeManager {
    private Connection connection;

    public LaundryTypeManager(Connection connection) {
        this.connection = connection;
    }

    public void addLaundryType(LaundryType laundryType) {
        String query = "INSERT INTO laundry_types (laundry_type, price) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, laundryType.getLaundryType());
            statement.setString(2, laundryType.getPrice());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                laundryType.setId(generatedId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLaundryType(int id) {
        String query = "DELETE FROM laundry_types WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<LaundryType> getAllLaundryTypes() {
        List<LaundryType> laundryTypes = new ArrayList<>();
        String query = "SELECT * FROM laundry_types";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String laundryType = resultSet.getString("laundry_type");
                double price = Double.parseDouble(resultSet.getString("price"));
                LaundryType lt = new LaundryType(id, laundryType, String.valueOf(price));
                laundryTypes.add(lt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laundryTypes;
    }

    public LaundryType getLaundryTypeById(int id) {
        String query = "SELECT * FROM laundry_types WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String laundryType = resultSet.getString("laundry_type");
                double price = Double.parseDouble(resultSet.getString("price"));
                return new LaundryType(id, laundryType, String.valueOf(price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateLaundryType(LaundryType laundryType) {
        String query = "UPDATE laundry_types SET laundry_type = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, laundryType.getLaundryType());
            statement.setString(2, laundryType.getPrice());
            statement.setInt(3, laundryType.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
 }
=======
}
>>>>>>> main

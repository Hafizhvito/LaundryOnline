package code;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileManager {
    private Connection connection;

    public ProfileManager(Connection connection) {
        this.connection = connection;
    }

    public void addProfile(Profile profile) {
        try {
            String sql = "INSERT INTO users (username, password, address, telepon, userType) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, profile.getName());
            statement.setString(2, profile.getPassword());
            statement.setString(3, profile.getAddress());
            statement.setString(4, profile.getPhoneNumber());
            statement.setString(5, profile.getAccess());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                profile.setId(generatedId);
            }
            statement.close(); // Close the statement after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProfile(Profile profile) {
        try {
            String sql = "UPDATE users SET username = ?, password = ?, address = ?, telepon = ?, userType = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, profile.getName());
            statement.setString(2, profile.getPassword());
            statement.setString(3, profile.getAddress());
            statement.setString(4, profile.getPhoneNumber());
            statement.setString(5, profile.getAccess());
            statement.setInt(6, profile.getId());
            statement.executeUpdate();
            statement.close(); // Close the statement after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProfile(int profileId) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, profileId);
            statement.executeUpdate();
            statement.close(); // Close the statement after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getTotalData() {
        String sql = "SELECT COUNT(*) FROM users";
        int totalData = 0;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                totalData = resultSet.getInt(1);
            }
            resultSet.close();
            statement.close(); // Close the statement after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalData;
    }
// kode ini hanya untuk opsional

    public Object[][] selectProfile() {
        Object[][] data = null;
        try {
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int totalData = getTotalData();
            data = new Object[totalData][6];

            int angka = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("telepon");
                String access = resultSet.getString("userType");
                data[angka] = new Object[]{id, name, password, address, phoneNumber, access};
                angka++;
            }

            resultSet.close();
            statement.close(); // Close the statement after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("telepon");
                String access = resultSet.getString("userType");
                Profile profile = new Profile(id, name, address, phoneNumber, password, access);
                profiles.add(profile);
            }
            resultSet.close();
            statement.close(); // Close the statement after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    public Profile getProfileById(int profileId) {
        Profile profile = null;
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, profileId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("telepon");
                String access = resultSet.getString("userType");
                profile = new Profile(profileId, name, address, phoneNumber, password, access);
            }

            resultSet.close();
            statement.close(); // Close the statement after use
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profile;
    }
<<<<<<< HEAD
}

=======
}
>>>>>>> main

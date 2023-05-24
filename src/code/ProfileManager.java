package code;

import code.Profile;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProfile(int profileId) {
        try {
            if (profileId != 0) {
                String sql = "DELETE FROM users WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, profileId);
                statement.executeUpdate();
            } else {
                System.out.println("Profile ID is not available");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }
    public Profile getProfileById(int profileId) {
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
                Profile profile = new Profile(profileId, name, address, phoneNumber, password, access);
                resultSet.close();
                statement.close();
                return profile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Mengembalikan null jika profil tidak ditemukan
    }
    public void updateLaundryType(LaundryType laundryType) {
        String query = "UPDATE laundry_types SET laundry_type = ?, price = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, laundryType.getLaundryType());
            statement.setDouble(2, laundryType.getPrice());
            statement.setInt(3, laundryType.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

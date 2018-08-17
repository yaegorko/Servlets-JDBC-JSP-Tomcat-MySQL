package dao;

import model.User;
import util.DbHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplJDBC implements UserDao<User> {
    private static final String SQL_CREATE = "INSERT INTO users (name, password) VALUES (?,?)";
    private static final String SQL_GET_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String SQL_GET_ALL = "SELECT * FROM users";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM users WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE users SET name=?, password=? WHERE id=?";

    private static UserDao userDao;
    private static Connection connection = DbHelper.getDbConnection();

    private UserDaoImplJDBC() {

    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImplJDBC();
        }
        return userDao;
    }

    public void addNewUser(User user) {
        try (PreparedStatement stmn = connection.prepareStatement(SQL_CREATE)) {
            stmn.setString(1, user.getName());
            stmn.setString(2, user.getPassword());
            stmn.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        User user = new User();
        try (PreparedStatement stmn = connection.prepareStatement(SQL_GET_BY_ID)) {
            stmn.setInt(1, id);
            ResultSet resultSet = stmn.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUserById(int id) {
        try (PreparedStatement stmn = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            stmn.setInt(1, id);
            stmn.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try (PreparedStatement stmn = connection.prepareStatement(SQL_UPDATE)) {
            stmn.setString(1, user.getName());
            stmn.setString(2, user.getPassword());
            stmn.setInt(3, user.getId());
            stmn.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();

        try (PreparedStatement stmn = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = stmn.executeQuery();
            while (resultSet.next()) {
                usersList.add(new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
}

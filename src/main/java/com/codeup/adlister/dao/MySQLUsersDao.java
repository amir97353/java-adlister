package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {

    private Connection connection ;
    public MySQLUsersDao(Config config) {
        try {
            //How we establish connection goes here, but we're not actually establishing the connection here. We're doing it in the Daofactory that's whey in the Daofactory you have MySqlUsers.Dao with the config as an argument.
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }







    @Override
    public User findByUsername(String username) {
       try {
           String findUsernameQuery = "SELECT * FROM users WHERE username = ?";
           PreparedStatement stmt = connection.prepareStatement(findUsernameQuery);
           stmt.setString(1, username);

           ResultSet rs = stmt.executeQuery();
           rs.next();
           User newUser = new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
           return newUser;
       }catch (Exception e){
           throw new RuntimeException("Error finding user");
       }


    }

    @Override
    public Long insert(User user) {
        try {
            String insertUserQuery = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertUserQuery, Statement.RETURN_GENERATED_KEYS);
            // insertUserQuery is what you need from Mysql
            //prepared statement is establishing the Mysql connection nad using the variable insert query

            // Set the values of the ?'s
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding to the database");
        }

    }


}

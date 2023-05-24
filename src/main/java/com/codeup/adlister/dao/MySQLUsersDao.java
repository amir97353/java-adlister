package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {

    private Connection connection = null;
    public MySQLUsersDao(Config config) {
        try {
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
           String userSelected = "SELECT * FROM users WHERE username = ?";
           PreparedStatement stmt = connection.prepareStatement(userSelected);
           stmt.setString(1,username);
           ResultSet rs =stmt.executeQuery();

           User selectedUser = null;

           while (rs.next()){
               selectedUser = (new User(rs.getString(username)));
           }
           return selectedUser;
       }catch (Exception e){
           throw new RuntimeException("Error finding user");
       }


    }

    @Override
    public Long insert(User user) {
        return null;
    }
}

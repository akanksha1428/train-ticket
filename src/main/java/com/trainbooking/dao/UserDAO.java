package com.trainbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.trainbooking.model.User;
import com.trainbooking.util.DBConnection;

public class UserDAO {

    public boolean registerUser(User user) {
    	
    	System.out.println("user inside userdao " + user);
        String sql = "INSERT INTO users (username, password, fullname, email, phone, active) VALUES (?, ?, ?, ?, ?, true)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
   
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFullname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        public User validateUser(String username, String password){
            String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND active = true";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, username);
                stmt.setString(2, password);

                var rs = stmt.executeQuery();
                if (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt("user_id")); 
                    user.setUsername(rs.getString("username"));
                    user.setFullname(rs.getString("fullname"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone"));
                    user.setActive(rs.getBoolean("active"));
                    return user;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }


package com.trainbooking.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.trainbooking.model.Train;
import com.trainbooking.util.DBConnection;

public class TrainDAO {

    // Search trains by origin, destination and journey date
    public List<Train> searchTrains(String origin, String destination, Date journeyDate) {
        List<Train> trains = new ArrayList<>();
        String sql = "SELECT * FROM trains WHERE origin = ? AND destination = ? AND journey_date = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, origin);
            stmt.setString(2, destination);
            stmt.setDate(3, journeyDate);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Train train = new Train();
                train.setTrainId(rs.getInt("train_id"));
                train.setTrainName(rs.getString("train_name"));
                train.setOrigin(rs.getString("origin"));
                train.setDestination(rs.getString("destination"));
              
                train.setJourneyDate(rs.getDate("journey_date")); // ✅ Pass java.sql.Date directly

                train.setDepartureTime(rs.getString("departure_time"));
                train.setArrivalTime(rs.getString("arrival_time"));
                train.setAvailableAcSeats(rs.getInt("available_ac_seats"));
                train.setAvailableSleeperSeats(rs.getInt("available_sleeper_seats"));
                trains.add(train);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trains;
    }

    // Add a new train (admin)
    public boolean addTrain(Train train) {
        String sql = "INSERT INTO trains (train_name, origin, destination, journey_date, departure_time, arrival_time, available_ac_seats, available_sleeper_seats) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, train.getTrainName());
            stmt.setString(2, train.getOrigin());
            stmt.setString(3, train.getDestination());
        
            stmt.setDate(4, new java.sql.Date(train.getJourneyDate().getTime()));

            stmt.setString(5, train.getDepartureTime());
            stmt.setString(6, train.getArrivalTime());
            stmt.setInt(7, train.getAvailableAcSeats());
            stmt.setInt(8, train.getAvailableSleeperSeats());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   

    // Update train details by train_id (admin)
    public boolean updateTrain(Train train) {
        String sql = "UPDATE trains SET train_name=?, origin=?, destination=?, journey_date=?, departure_time=?, arrival_time=?, available_ac_seats=?, available_sleeper_seats=? WHERE train_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, train.getTrainName());
            stmt.setString(2, train.getOrigin());
            stmt.setString(3, train.getDestination());
            stmt.setDate(4, new java.sql.Date(train.getJourneyDate().getTime()));
            stmt.setString(5, train.getDepartureTime());
            stmt.setString(6, train.getArrivalTime());
            stmt.setInt(7, train.getAvailableAcSeats());
            stmt.setInt(8, train.getAvailableSleeperSeats());
            stmt.setInt(9, train.getTrainId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a train by train_id (admin)
    public boolean deleteTrain(int trainId) {
        String sql = "DELETE FROM trains WHERE train_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, trainId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Optional: get a train by ID (useful for update forms)
    public Train getTrainById(int trainId) {
        String sql = "SELECT * FROM trains WHERE train_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, trainId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Train train = new Train();
                train.setTrainId(rs.getInt("train_id"));
                train.setTrainName(rs.getString("train_name"));
                train.setOrigin(rs.getString("origin"));
                train.setDestination(rs.getString("destination"));
                train.setJourneyDate(rs.getDate("journey_date"));
                train.setDepartureTime(rs.getString("departure_time"));
                train.setArrivalTime(rs.getString("arrival_time"));
                train.setAvailableAcSeats(rs.getInt("available_ac_seats"));
                train.setAvailableSleeperSeats(rs.getInt("available_sleeper_seats"));
                return train;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

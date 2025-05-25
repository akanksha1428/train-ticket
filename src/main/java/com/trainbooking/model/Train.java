package com.trainbooking.model;

import java.util.Date;

public class Train {
    private int trainId;
    private String trainName;
    private String origin;
    private String destination;
    private Date journeyDate;
    private String departureTime;
    private String arrivalTime;
    private int availableAcSeats;
    private int availableSleeperSeats;

    // No-argument constructor
    public Train() {}

    // Parameterized constructor (optional)
    public Train(int trainId, String trainName, String origin, String destination, Date journeyDate, String departureTime, String arrivalTime, int availableAcSeats, int availableSleeperSeats) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.origin = origin;
        this.destination = destination;
        this.journeyDate = journeyDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableAcSeats = availableAcSeats;
        this.availableSleeperSeats = availableSleeperSeats;
    }

    // Getters and Setters

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getAvailableAcSeats() {
        return availableAcSeats;
    }

    public void setAvailableAcSeats(int availableAcSeats) {
        this.availableAcSeats = availableAcSeats;
    }

    public int getAvailableSleeperSeats() {
        return availableSleeperSeats;
    }

    public void setAvailableSleeperSeats(int availableSleeperSeats) {
        this.availableSleeperSeats = availableSleeperSeats;
    }
}

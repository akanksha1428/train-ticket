package com.trainbooking.servlet; 


import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainbooking.model.Train; // Replace with the actual path of your Train class
import com.trainbooking.dao.TrainDAO; // Replace with the actual path of your TrainDAO class
@WebServlet("/admin/AddTrainServlet")
public class AddTrainServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String trainName = request.getParameter("trainName");
    String origin = request.getParameter("origin");
    String destination = request.getParameter("destination");
    Date journeyDate = Date.valueOf(request.getParameter("journeyDate"));
    String departureTime = request.getParameter("departureTime");
    String arrivalTime = request.getParameter("arrivalTime");

    int availableAcSeats = Integer.parseInt(request.getParameter("availableAcSeats"));
    int availableSleeperSeats = Integer.parseInt(request.getParameter("availableSleeperSeats"));

    Train train = new Train();
    train.setTrainName(trainName);
    train.setOrigin(origin);
    train.setDestination(destination);
    train.setJourneyDate(journeyDate);
    train.setDepartureTime(departureTime);
    train.setArrivalTime(arrivalTime);
    train.setAvailableAcSeats(availableAcSeats);
    train.setAvailableSleeperSeats(availableSleeperSeats);

    TrainDAO dao = new TrainDAO();
    boolean result = dao.addTrain(train);

    if (result) {
        response.sendRedirect("adminDashboard.jsp");
    } else {
        response.getWriter().println("Failed to add train.");
    }
}
}


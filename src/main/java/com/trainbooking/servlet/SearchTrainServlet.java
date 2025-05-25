package com.trainbooking.servlet;

import com.trainbooking.dao.TrainDAO;
import com.trainbooking.model.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/searchTrain")
public class SearchTrainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String journeyDateStr = request.getParameter("journeyDate");

        Date journeyDate = null;
        try {
            journeyDate = Date.valueOf(journeyDateStr);
        } catch (IllegalArgumentException e) {
            // Invalid date format, you could set an error attribute here
            request.setAttribute("error", "Invalid date format");
        }

        TrainDAO trainDAO = new TrainDAO();
        List<Train> trains = trainDAO.searchTrains(origin, destination, journeyDate);

        request.setAttribute("trainList", trains);

        // Forward to JSP to show results
        request.getRequestDispatcher("/customer/searchResults.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Optionally redirect GET to search page or show error
        response.sendRedirect(request.getContextPath() + "/customer/searchTrain.jsp");
    }
}

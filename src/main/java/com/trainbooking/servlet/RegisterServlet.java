package com.trainbooking.servlet;

import com.trainbooking.dao.UserDAO;
import com.trainbooking.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User();
        user.setFullname(fullname);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setActive(true);

        UserDAO userDAO = new UserDAO();
        System.out.println("user dao " + userDAO);
        boolean success = userDAO.registerUser(user);
        
        System.out.println("success " + success);

        if (success) {
            response.sendRedirect("customer/login.jsp");
        } else {
            response.sendRedirect("customer/error.jsp");
        }
    }
}


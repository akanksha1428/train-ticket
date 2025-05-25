/* package com.trainbooking.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainbooking.dao.UserDAO;
import com.trainbooking.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.validateUser(username, password);

        if (user != null) {
            // Store user info in session
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUsername());
            session.setAttribute("fullName", user.getFullname());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("phone", user.getPhone());

            response.sendRedirect("customer/customerDashboard.jsp");

        } else {
            // Login failed
            request.setAttribute("errorMessage", "Wrong username or password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
} */
package com.trainbooking.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.trainbooking.dao.UserDAO;
import com.trainbooking.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    // Hardcoded admin credentials (you can later move this to config or DB)
    private static final String ADMIN_EMAIL = "admin@bookmytrain.com";
    private static final String ADMIN_PASSWORD = "Admin1234_";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if admin login
        if (ADMIN_EMAIL.equals(username) && ADMIN_PASSWORD.equals(password)) {
            // Admin login successful
            HttpSession session = request.getSession();
            session.setAttribute("adminEmail", ADMIN_EMAIL);
            // Redirect to admin dashboard page
            response.sendRedirect("admin/adminDashboard.jsp");
            return;
        }

        // Normal user login
        UserDAO userDAO = new UserDAO();
        User user = userDAO.validateUser(username, password);

        if (user != null) {
            // Store user info in session
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUsername());
            session.setAttribute("fullName", user.getFullname());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("phone", user.getPhone());

            response.sendRedirect("customer/customerDashboard.jsp");

        } else {
            // Login failed
            request.setAttribute("errorMessage", "Wrong username or password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}


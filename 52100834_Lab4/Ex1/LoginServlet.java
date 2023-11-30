package com.yourpackage; // Replace with your package name

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Define a HashMap to store pre-built accounts (username and password)
    private HashMap<String, String> accounts = new HashMap<>();
    
    public LoginServlet() {
        super();
        
        // Add some sample accounts to the HashMap (replace with your actual accounts)
        accounts.put("user1", "password1");
        accounts.put("user2", "password2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect back to the index.jsp page when accessed using the GET method
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the submitted form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the username exists in the HashMap and the password is correct
        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            // Successful login, you can redirect to a welcome page or perform other actions
            response.getWriter().println("Login Successful! Welcome, " + username);
        } else {
            // Invalid login, you can redirect to an error page or display an error message
            response.getWriter().println("Invalid username or password. Please try again.");
        }
    }
}
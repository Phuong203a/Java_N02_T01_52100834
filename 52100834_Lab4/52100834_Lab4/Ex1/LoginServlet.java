package com.lab04.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private HashMap<String, String> account = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1> Login </h1>");

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        System.out.println(username);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (account.containsKey(username) && account.get(username).equals(password)) {
            out.println("<h1>Username/ Password Match</h1>");
        } else {
            out.println("<h1>Username/Password not match </h1>");
        }

        out.flush();
        out.close();
    }

    @Override
    public void init() throws ServletException {
        account.put("admin", "admin");
        account.put("user", "user");
        super.init();
    }
}
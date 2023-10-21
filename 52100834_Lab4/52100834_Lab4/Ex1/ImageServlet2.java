package com.lab04.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ImageServlet2", value = "/ImageServlet2")
public class ImageServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    force client download image2.png
        response.setContentType("image/png");
        response.setHeader("Content-Disposition", "attachment; filename=\"image2.png\"");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(getServletContext().getResourceAsStream("/WEB-INF/images/image2.png").readAllBytes());
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
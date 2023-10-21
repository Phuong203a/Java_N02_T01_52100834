package edu.tdtu;



import java.io.*;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if query string not found  or file name not exist then return <h1> File not found
        String queryString = request.getQueryString();
        if (queryString == null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1> Query string not found </h1>");
            out.flush();
            out.close();
            return;
        }
        String fileName = queryString.split("=")[1];
        System.out.println(fileName);
        System.out.println(getServletContext().getRealPath("/WEB-INF/" + fileName));
        if (!Path.of(getServletContext().getRealPath("/WEB-INF/" + fileName)).toFile().exists()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1> File not found </h1>");
            out.flush();
            out.close();
            return;
        }

//        force client download file
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        ServletOutputStream outputStream = response.getOutputStream();

        getServletContext().getResourceAsStream("/WEB-INF/" + fileName).transferTo(outputStream);

        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
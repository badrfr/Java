package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/DisplayCustomers")
public class DisplayCustomersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Database connection details
            String url = "jdbc:mysql://127.0.0.1:3306/inventory?useSSL=false";
            String user = "root";
            String password = "root";

            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                Statement stmt = conn.createStatement();
                String query = "SELECT customer_id, cust_name, city, grade, salesman_id FROM customer";
                ResultSet rs = stmt.executeQuery(query);

                // Start HTML output
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Customer List</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Customer List</h1>");
                out.println("<table border='1'>");
                out.println("<tr><th>Customer ID</th><th>Name</th><th>City</th><th>Grade</th><th>Salesman ID</th></tr>");

                // Loop through the result set and create table rows
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getInt("customer_id") + "</td>"
                                + "<td>" + rs.getString("cust_name") + "</td>"
                                + "<td>" + rs.getString("city") + "</td>"
                                + "<td>" + rs.getInt("grade") + "</td>"
                                + "<td>" + rs.getInt("salesman_id") + "</td></tr>");
                }

                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


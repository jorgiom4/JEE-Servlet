package com.instancia2.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ConnectToDBServlet", urlPatterns = "/dbtest")
public class ConnectToDBServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dbConnector = "jdbc:mysql://localhost:8889/";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(dbConnector,"root","root");

            Statement st = con.createStatement();

            String query = "CREATE DATABASE IF NOT EXISTS cice";
            String query1 = "USE cice";
            String query2 = "CREATE TABLE mi_tabla (id INT AUTO_INCREMENT NOT NULL, titulo VARCHAR(255), PRIMARY KEY (id))";

            st.execute(query);
            st.execute(query1);
            st.execute(query2);

            st.close();

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

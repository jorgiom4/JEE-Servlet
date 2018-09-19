package com.instancia2.controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "CicloVidaServlet", urlPatterns = "/ciclovida")
public class CicloVidaServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("---- Dentro del init del servlet");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        System.out.println("---- Dentro del service del servlet ssessionTimeout: " + servletContext.getSessionTimeout());
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("---- Dentro del destroy del servlet");
    }

}

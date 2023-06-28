package com.example.ti_lab7.controller;

import com.example.ti_lab7.model.MrUser;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.ti_lab7.service.UserService;

@WebServlet(name = "MRController", value = "/MRController")
public class MRController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        MrUser user = (MrUser) session.getAttribute("uzytkownik");

        out.println(user);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final HttpSession session = request.getSession();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        final PrintWriter out = response.getWriter();

        String login = request.getParameter("username");
        final String password = request.getParameter("password");

        if (request.getParameter("logout") != null) {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "?strona=glowna");
        }

        if (request.getParameter("login") != null && login != null && password != null) {
            login = login.trim().toLowerCase();

            MrUser mrUser = userService.userAuthorization(login, password);
            session.setAttribute("uzytkownik", mrUser);
            response.sendRedirect(request.getContextPath() + "?strona=glowna");
        }
        out.close();
    }
}

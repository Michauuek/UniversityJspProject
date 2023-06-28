package com.example.ti_lab7.controller;

import com.example.ti_lab7.model.MrUser;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SettingsController", value = "/SettingsController")
public class SettingsController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        final HttpSession session = request.getSession();
        final MrUser user = (MrUser) session.getAttribute("uzytkownik");

        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final int age = Integer.parseInt(request.getParameter("age"));

        if (request.getParameter("zapisz") != null) {
            user.setName(name);
            user.setSurname(surname);
            user.setAge(age);

            session.setAttribute("uzytkownik", user);
            response.sendRedirect(request.getContextPath() + "?strona=ustawienia");
        }
    }
}

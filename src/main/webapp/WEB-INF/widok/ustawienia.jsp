<%--
  Created by IntelliJ IDEA.
  User: rzemi
  Date: 27.04.2023
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.ti_lab7.model.MrUser" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="uzytkownik" class="com.example.ti_lab7.model.MrUser" scope="session"/>

<form action="/ti_lab7_war_exploded/SettingsController" method="POST">
    <div class="container">
        <label>Name : </label>
        <label>
            <input type="text" value="${uzytkownik.name}" name="name" required>
        </label>
        <br>
        <label>Surname : </label>
        <label>
            <input type="text" value="${uzytkownik.surname}" name="surname" required>
        </label>
        <br>
        <label>Age : </label>
        <label>
            <input type="number" value="${uzytkownik.stringAge}" name="age" min="0" required>
        </label>
        <br>
        <button type="submit" name="zapisz">Save</button>
    </div>
</form>
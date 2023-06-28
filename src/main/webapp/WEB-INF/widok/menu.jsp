<%--
  Created by IntelliJ IDEA.
  User: rzemi
  Date: 27.04.2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.ti_lab7.model.MrUser" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    MrUser user = (MrUser) session.getAttribute("uzytkownik");
    if(user == null){
        user = new MrUser();
        session.setAttribute("uzytkownik", user);
    }
%>

<input type="checkbox" id="toggle">
<label for="toggle" class="hamburger">&#9776;</label>
<ul id="nav">

    <li><a href="?strona=glowna">Strona Główna</a></li>
    <li><a href="?strona=kwadratowe">kwadratowe</a></li>
    <li><a href="?strona=pierwsze">pierwsze</a></li>
    <li><a href="?strona=glowna">Link3</a></li>

    <%
        if (user.getPrivileges() > 0) {
    %>
    <li><a href="?strona=ustawienia">Ustawienia</a></li>
    <%
        }
    %>

</ul>
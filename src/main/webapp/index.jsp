<%@ page import="com.example.ti_lab7.model.MrUser" %>
<%@ page import="com.example.ti_lab7.service.Tools" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    MrUser user = (MrUser) session.getAttribute("uzytkownik");
    if (user == null){
        user = new MrUser();
        session.setAttribute("uzytkownik", user);
    }
    String strona = request.getParameter("strona");

    if (user.getPrivileges() == 1) {
        strona = Tools.parsujStrone(strona, "glowna;kwadratowe;trzecia;ustawienia");
    }
    else {
        strona = Tools.parsujStrone(strona, "glowna;kwadratowe;trzecia;");
    }

%>

<jsp:useBean id="uzytkownik" class="com.example.ti_lab7.model.MrUser" scope="session"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Lab7</title>
    <link rel="stylesheet" type="text/css" href="styl.css"/>
    <script type="text/javascript" src="skrypt.js"></script>
</head>
<body onload="funkcje(); zegarek(); setInterval(zegarek, 1000)">
<div id="kontener">
    <div id="naglowek">
        <jsp:include page="/WEB-INF/widok/naglowek.jsp"/>
    </div>
    <div id="menu">
        <jsp:include page="/WEB-INF/widok/menu.jsp"/>
    </div>
    <div id="srodek">

        <div id="tresc">
            <jsp:include page="/WEB-INF/widok/tresc.jsp">
                <jsp:param name="jaka_strona" value="<%=strona%>"/>
            </jsp:include>
        </div>
        <div id="newsy">
            <p id="news1"></p>
            <p id="news2"></p>

            <%
                if (user.getPrivileges() < 0) {
            %>
            <jsp:include page="/WEB-INF/widok/formularz.jsp"/>
            <%
                }
            %>

            <%
                if (user.getPrivileges() > 0) {
            %>
            <form action="MRController" method="POST">
                <div id="logout">
                    Jesteś zalogowany<br>
                    <button type="submit" name="logout">Wyloguj</button>
                </div>
            </form>
            <%
                }
            %>
        </div>

    </div>
    <div id="stopka">
        <jsp:include page="/WEB-INF/widok/stopka.jsp"/>
    </div>
</div>
</body>
</html>
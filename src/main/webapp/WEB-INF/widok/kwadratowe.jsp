<%--
  Created by IntelliJ IDEA.
  User: rzemi
  Date: 03.05.2023
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
skrypt.js;kwadratowe.js
podpiecie(); zegarek(); funkcje();  setInterval(zegarek,1000);
<form id="dane" name="dane">
    <input placeholder="a" type="number" id="wsp_a" name="wa">x<sup>2</sup>+
    <input placeholder="b" type="number" id="wsp_b" name="wb">x+
    <input placeholder="c" type="number" id="wsp_c" name="wc"><br/>
    <div id="przycisk">
        <input type="button" id="licz" value="Oblicz">

    </div>
</form>
<div id="lista"></div>

<%--
  Created by IntelliJ IDEA.
  User: rzemi
  Date: 03.05.2023
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<% String jakaStrona = "/WEB-INF/widok/" + request.getParameter("jaka_strona")+".jsp"; %>
<jsp:include page="<%=jakaStrona%>"/>
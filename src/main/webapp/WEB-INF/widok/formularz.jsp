<%--
  Created by IntelliJ IDEA.
  User: rzemi
  Date: 27.04.2023
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<form action="MRController" method="POST">
  <div class="container">
    <label>Username : </label> <br>
    <label>
      <input type="text" placeholder="Enter Username" name="username" required>
    </label> <br>
    <label>Password : </label> <br>
    <label>
      <input type="password" placeholder="Enter Password" name="password" required>
    </label>
    <button type="submit" name="login">Login</button>
  </div>
</form>

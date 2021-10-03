<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 17-09-2021
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Show my computer</title>
  </head>
  <body>
  <h3>Welcome to my computer basic</h3>
  <form action="/answer" method="get">
    a &nbsp;<input type="number" name="a" value="${a}" required><br>
    b &nbsp;<input type="number" name="b" value="${b}" required>
<br>
    <input type="submit" name="action" value="+">
    <input type="submit" name="action" value="-">
    <input type="submit" name="action" value="*">
    <input type="submit" name="action" value="/"><br>
    <p>${Result}</p>
  </form>


  </body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 17-09-2021
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Add seasonning with sandwich</title>
  </head>
  <body>
<h2>Sandwich Condiments</h2>
<form action="/save" method="get">
  <table>

    <c:forEach items="${list}" var="listi">
      <tr>
        <td>${listi}</td>
        <td><input name="condiment" value="${listi}" type="checkbox"></td>
      </tr>

    </c:forEach>
    <hr>

  </table>
  <button type="submit">Create</button>
</form>

  </body>
</html>

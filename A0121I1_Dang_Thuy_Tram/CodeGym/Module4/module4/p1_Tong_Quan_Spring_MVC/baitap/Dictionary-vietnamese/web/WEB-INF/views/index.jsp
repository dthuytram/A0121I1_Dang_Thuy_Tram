<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 14-09-2021
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
<form method="post">
  <table>
    <tr><td>Word</td>
    <td><input type="text" name="wordEng" value="${wordEng}"></td></tr>
    <tr>
      <td colspan="2"><input type="submit" value="Translate VietNamese"></td></tr>
    <tr>
      <td colspan="2">Result : ${result} ${message}</tr>
  </table>
</form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/6/2021
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Cover Money</title>
    <link rel="stylesheet" href="Bootstrap4/css/bootstrap.css"/>
  </head>
  <body>
  <div class="container text-center">
    <form action="/covert.jsp" method="post">
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text">Rate</span>

        </div>
        <input type="text" name="rate" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
      </div>
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text">USA</span>

        </div>
        <input type="text" name="usd" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
      </div>
      <input type="submit" class="btn btn-success align-content-center" value="Covert"/>
    </form>
  </div>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/8/2021
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
    <title>Simple basic</title>
  </head>
  <body>
  <div class="container">
  <form action="/result" method="post"  >
    <div class="form-group">
      <label > First operand :</label>
      <input type="text" class="form-control " name="first" required>
    </div>
    <div class="form-group">
      <label >Example select</label>
      <select class="form-control" name="choice" >
        <option >+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>

      </select>
    </div>
    <div class="form-group">
      <label>Second operand</label>
      <input type="text" pattern="[a-Z]" class="form-control" name="second" required>
    </div>

    <button type="submit" class="btn btn-light">Submit</button>
  </form>
  </div>
  <script >
    // function check() {
    //   var second = document.getElementsByName("second").value;
    //   var first = document.getElementsByName("first").value;
    //   if (first == "" || first == null ||second == "" || second == null ) {
    //     alert("Vui lòng nhập đủ thông tin");
    //     return false;
    //   }
    // }
  </script>
  </body>
</html>

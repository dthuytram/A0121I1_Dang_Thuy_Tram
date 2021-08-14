<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>BirthDay</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
   <c:forEach var="customer" items="${customerList}">
       <tr>
       <td >${customer.id}</td>
       <td >${customer.name}</td>
       <td >${customer.birthday}</td>
       <td >${customer.address}</td>
       <td ><img src="${customer.image}" width="80px" height="80px"></td>
   </tr>
   </c:forEach>

    </tbody>
</table>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

</body>
</html>
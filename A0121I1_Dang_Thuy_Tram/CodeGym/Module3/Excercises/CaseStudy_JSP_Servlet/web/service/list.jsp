<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/3/2021
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assert/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/css/style.css">
</head>
<body>

<div class="container viewList">
    <div class="row">

        <div class="col">
            <div class="d-flex">
                <input class="form-control mr-sm-2" aria-label="Search" type="text" id="nameSearch">
                <button type="button" class="btn btn-outline-success" id="search">Search</button>
            </div>
        </div>

        <div class="col">
            <a class="btn btn-outline-secondary" href="customer?action=create" role="button">Create new customer</a>
        </div>

        <div class="col">
            <a class="btn btn-outline-secondary" href="customer?action=viewCustomerUseService" role="button">View Customer Use Service</a>
        </div>

        <div class="col">
            <a class="btn btn-outline-secondary" href="furama" role="button">Back to home</a>
        </div>

    </div>
</div>
<hr>

<div id="result" class="container-lg">
    <table class="table table-Secondary resultList">
        <tr class="table-dark">
            <th>ID</th>
            <th>Name</th>
            <th>Type Customer</th>
            <th>Information</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach items="${customerDTOList}" var="customerDTO">
            <tr>
                <td>${customerDTO.id}</td>
                <td>${customerDTO.name}</td>
                <td>${customerDTO.nameTypeCustomer}</td>
                <td><a class="btn btn-outline-info btn-sm" role="button" aria-pressed="true"
                       href="customer?action=view&id=${customerDTO.id}">Information</a></td>
                <td><a class="btn btn-outline-warning btn-sm" role="button" aria-pressed="true"
                       href="customer?action=edit&id=${customerDTO.id}">Edit</a></td>
                <td><a class="btn btn-outline-danger btn-sm delete" role="button" aria-pressed="true"
                       href="customer?action=delete&id=${customerDTO.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript" src="assert/Jquery/jquery.js"></script>
<script type="text/javascript" src="assert/js/searchCustomer.js"></script>
<script type="text/javascript" src="assert/css/bootstrap/js//bootstrap.js"></script>
</body>
</html>
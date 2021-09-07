<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/3/2021
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assert/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"

</head>
<body>
<div class="create">
    <form action="customer" method="post">
        <div class="container viewCreateCustomer">

            <div class="form-group row">
                <label for="id" class="col-sm-2 col-form-label">ID</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="id" name="id" value="${customer.id}">
                </div>
            </div>

            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="name" name="name" value="${customer.name}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Type Customer</label>
                <div class="col-sm">
                    <select name="TypeCustomer" class="form-select" aria-label="Default select example">
                        <c:forEach items="${typeCustomerList}" var="TypeCustomer">
                            <c:choose>
                                <c:when test="${TypeCustomer.id == customer.idTypeCustomer}">
                                    <option value="${TypeCustomer.id}" selected>${TypeCustomer.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${TypeCustomer.id}">${TypeCustomer.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="birthday" class="col-sm-2 col-form-label">Birthday</label>
                <div class="col-sm">
                    <input type="date" class="form-control" id="birthday" name="birthday" value="${customer.birthday}">
                </div>
            </div>

            <div class="form-group row">
                <label for="gender" class="col-sm-2 col-form-label">Gender</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="gender" name="gender" value="${customer.gender}">
                </div>
            </div>

            <div class="form-group row">
                <label for="id_card" class="col-sm-2 col-form-label">Identity</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="id_card" name="id_card" value="${customer.id_card}">
                </div>
            </div>

            <div class="form-group row">
                <label for="phone_number" class="col-sm-2 col-form-label">Phone Number</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="phone_number" name="phone_number"
                           value="${customer.phoneNumber}">
                    <c:if test="${errorPhoneNumber != null}">
                        <p style="color: red"><c:out value="${errorPhoneNumber}"/></p>
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="email" name="email" value="${customer.email}">
                    <c:if test="${errorEmail != null}">
                        <p style="color: #ff0000"><c:out value="${errorEmail}"/></p>
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="address" class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="address" name="address" value="${customer.address}">
                </div>
            </div>

            <hr>
            <input type="submit" class="btn btn-outline-success" value="Create">
            <a class="btn btn-outline-secondary" href="/customer" role="button">Back</a>
        </div>
        <input type="hidden" name="action" value="create">
    </form>

    <script type="text/javascript" src="assert/Jquery/jquery.js"></script>
    <script type="text/javascript" src="assert/js/search.js"></script>
    <script type="text/javascript" src="assert/css/bootstrap/js//bootstrap.js"></script>
</div>
</body>
</html>
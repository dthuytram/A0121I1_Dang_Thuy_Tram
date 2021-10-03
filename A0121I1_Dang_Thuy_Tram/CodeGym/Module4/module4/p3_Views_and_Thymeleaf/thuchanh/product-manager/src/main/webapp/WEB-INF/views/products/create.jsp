<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/11/2021
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<button class="btn btn-warning" type="button" onclick="window.location.href='/products'">Quay lại </button>
<div>
    <c:if test='${message != null}'>
    <div class="alert alert-success" role="alert">
        <span class="message">${message}</span>
    </div>
    </c:if>
</div>

<form method="post">
    <fieldset>
        <legend>Form Create </legend>

    <table class="table table-striped table-inverse table-responsive">
        <tbody>
        <tr>
            <td>Name :
            </td>
            <td><input type="text" class="form-control" name="nameProduct"> </td>

        </tr>
        <tr>
            <td>Description :
            </td>
            <td><input type="text" class="form-control" name="description"> </td>

        </tr>
        <tr>
            <td>Price Product :
            </td>
            <td><input type="text" class="form-control" name="price"> </td>

        </tr>
        <tr>
            <td>Producer :
            </td>
            <td><input type="text" class="form-control" name="producer"> </td>

        </tr>
        <tr>
            <td colspan="2" class="text-center"><button type="submit" class="btn btn-danger">Create</button></td>
        </tr>
        </tbody>
    </table>
    </fieldset>
</form>
</body>
</html>

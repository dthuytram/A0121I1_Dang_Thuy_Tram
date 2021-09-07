<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/3/2021
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assert/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/css/style.css">
</head>
<body>
<div class="edit">
    <form action="employee" method="post">
        <div class="container viewEditEmployee">

            <div class="form-group row">
                <label for="id" class="col-sm-2 col-form-label">ID</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="id" name="id" value="${employee.id}" readonly>
                </div>
            </div>

            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="name" name="name" value="${employee.name}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Level</label>
                <div class="col-sm">
                    <select name="levelEmployee" class="form-select" aria-label="Default select example">
                        <c:forEach items="${levelEmployeeList}" var="level">
                            <c:choose>
                                <c:when test="${level.id == employee.idLevelEmployee}">
                                    <option value="${level.id}" selected>${level.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${level.id}">${level.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Department</label>
                <div class="col-sm">
                    <select name="departmentEmployee" class="form-select" aria-label="Default select example">
                        <c:forEach items="${departmentEmployeeList}" var="department">
                            <c:choose>
                                <c:when test="${department.id == employee.idDepartmentEmployee}">
                                    <option value="${department.id}" selected>${department.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${department.id}">${department.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Position</label>
                <div class="col-sm">
                    <select name="positionEmployee" class="form-select" aria-label="Default select example">
                        <c:forEach items="${positionEmployeeList}" var="position">
                            <c:choose>
                                <c:when test="${position.id == employee.idPositionEmployee}">
                                    <option value="${position.id}" selected>${position.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${position.id}">${position.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="birthday" class="col-sm-2 col-form-label">Birthday</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="birthday" name="birthday" value="${employee.birthday}">
                </div>
            </div>

            <div class="form-group row">
                <label for="identity" class="col-sm-2 col-form-label">Identity</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="identity" name="identity" value="${employee.identity}">
                </div>
            </div>

            <div class="form-group row">
                <label for="phoneNumber" class="col-sm-2 col-form-label">Phone Number</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                           value="${employee.phoneNumber}">
                </div>
            </div>

            <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="email" name="email" value="${employee.email}">
                </div>
            </div>

            <div class="form-group row">
                <label for="Salary" class="col-sm-2 col-form-label">Salary</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="Salary" name="salary" value="${employee.salary}">
                </div>
            </div>

            <hr>
            <input type="submit" class="btn btn-outline-success" value="Update">
            <a class="btn btn-outline-secondary" href="employee" role="button">Back</a>
        </div>
        <input type="hidden" name="action" value="edit">
    </form>
</div>

<script type="text/javascript" src="assert/Jquery/jquery.js"></script>
<script type="text/javascript" src="assert/js/search.js"></script>
<script type="text/javascript" src="assert/css/bootstrap/js//bootstrap.js"></script>
</body>
</html>

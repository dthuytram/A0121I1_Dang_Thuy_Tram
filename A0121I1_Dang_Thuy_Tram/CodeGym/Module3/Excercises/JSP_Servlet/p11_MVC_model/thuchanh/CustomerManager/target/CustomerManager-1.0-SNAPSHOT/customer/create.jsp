<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table class="table table-striped table-inverse table-responsive">

            <tbody>
            <tr>
                <td >Name : </td>
                <td><input type="text" name="name" id="name"></td>

            </tr><tr>
                <td >Email : </td>
                <td><input type="text" name="email" id="email"></td>

            </tr><tr>
                <td >Address : </td>
                <td><input type="text" name="address" id="address"></td>

            </tr><tr>
                <td >Name : </td>
                <td><input type="submit" value="Create customer"></td>

            </tr>

            </tbody>
        </table>


    </fieldset>
</form>
</body>
</html>
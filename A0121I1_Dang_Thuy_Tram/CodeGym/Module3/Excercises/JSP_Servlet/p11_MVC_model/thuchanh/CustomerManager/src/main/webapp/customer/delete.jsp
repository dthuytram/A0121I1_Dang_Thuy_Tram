<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<h1>Deleting customer</h1>
<p>
    <a href="/customers">Back to customer</a>
</p>
<form method="post">
    <fieldset>
        <legend>ARE YOU SURE ?</legend>
        <table class="table table-striped table-inverse table-responsive">

            <tbody>
            <tr>
                <td >Name : </td>
                <td>${customer.getName()}</td>

            </tr>

            <tr>
                <td >Email : </td>
                <td>${customer.getEmail()}"</td>
            </tr>
            <tr>
                <td >Address : </td>
                <td>${customer.getAddress()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>
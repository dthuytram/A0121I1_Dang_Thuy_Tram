<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 14-09-2021
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>chuyển đổi tiền tệ</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td><span>Số lượng</span></td>
            <td><span><input type="text" name="usa" value="${usa}"></span></td>
        </tr>
        <tr>
            <td><span>Tỉ giá</span></td>
            <td><span><input type="text" name="rate" value="${rate}"></span></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Chuyển đổi"/></td>
        </tr>
        <tr>
            <td colspan="2"><span>Kết quả ${kq}</span></td>
        </tr>
    </table>

</form>
</body>
</html>

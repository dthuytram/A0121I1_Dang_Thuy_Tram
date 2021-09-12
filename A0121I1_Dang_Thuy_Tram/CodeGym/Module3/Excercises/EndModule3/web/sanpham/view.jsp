<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assert/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert//css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"

</head>
<body>
<div class="container viewSanPham">
    <table border="1px" class="table table-dark">
        <tr>
            <th>ID Sản phẩm</th>
            <td>${sanpham.id_sanpham}</td>
        </tr>
<%--        <tr>--%>
<%--            <th>Name</th>--%>
<%--            <td>${sanpham.ten_sanpham} </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Tên loại sản phẩm</th>--%>
<%--            <td>${loai.ten_loai} </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Giá cả</th>--%>
<%--            <td>${sanpham.gia}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Số lượng</th>--%>
<%--            <td>${sanpham.soluong}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Màu sắc</th>--%>
<%--            <td>${sanpham.mausac}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Mô tả</th>--%>
<%--            <td>${sanpham.mota}</td>--%>
<%--        </tr>--%>
    </table>
    <hr>
    <a class="btn btn-outline-secondary" href="sanpham" role="button">Trở lại</a>
</div>

<script type="text/javascript" src="assert/Jquery/jquery.js"></script>
<script type="text/javascript" src="assert/css/bootstrap/js//bootstrap.js"></script>
</body>
</html>

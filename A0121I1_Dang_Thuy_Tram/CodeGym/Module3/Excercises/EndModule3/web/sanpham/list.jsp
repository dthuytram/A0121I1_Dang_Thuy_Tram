<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assert/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"

</head>
<body>
<div class="container viewList">
    <div class="row">
        <div class="mb-2 bg-success text-white rounded">${requestScope.message}</div>
        <div class="col">
            <form action="sanpham?action=search" method="post">
                <input class="form-control mr-sm-2" aria-label="Search" type="text" id="nameSearch" name="nameSearch">
                <button type="submit" class="btn btn-outline-success" id="search">Search</button>
            </form>

            </div>
        </div>

        <div class="col">
            <a class="btn btn-outline-secondary" href="sanpham?action=create" role="button">Tạo sản phẩm mới</a>
        </div>

        <div class="col">
            <a class="btn btn-outline-secondary" href="sanpham" role="button">Trở về</a>
        </div>

    </div>
</div>
<hr>

<div id="result" class="container-lg">
    <table class="table table-Secondary resultList">
        <tr class="table-dark">
            <th>ID Sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Giá sản phẩm</th>
            <th>Số lượng sản phẩm</th>
            <th>Màu sắc</th>
            <th>Mô tả</th>
            <th>Tên loại sản phẩm</th>
<%--            <th>Thông tin</th>--%>
            <th>Chỉnh sửa</th>
            <th>Xóa</th>
        </tr>

        Số lượng tổng trong database: <c:out value="${sanPhamDTOList.size()}"></c:out>
    </br>
        <c:forEach items="${sanPhamDTOList}" var="sanPhamDTOList">
            <tr>
                <td>${sanPhamDTOList.id_sanpham}</td>
                <td>${sanPhamDTOList.ten_sanpham}</td>
                <td>${sanPhamDTOList.gia}</td>
                <td>${sanPhamDTOList.soluong}</td>
                <td>${sanPhamDTOList.mausac}</td>
                <td>${sanPhamDTOList.mota}</td>
                <td>${sanPhamDTOList.ten_loai}</td>
<%--                <td><a class="btn btn-outline-info btn-sm" role="button" aria-pressed="true"--%>
<%--                       href="sanpham?action=view&id=${sanPhamDTOList.id_sanpham}">Thông tin</a></td>--%>
                <td><a class="btn btn-outline-warning btn-sm" role="button" aria-pressed="true"
                       href="sanpham?action=edit&id=${sanPhamDTOList.id_sanpham}">Chỉnh sửa</a></td>
                <td><a class="btn btn-outline-danger btn-sm delete" onclick="return confirm('Bạn có chắc chắn xóa không?');" role="button" aria-pressed="true"
                       href="sanpham?action=delete&id=${sanPhamDTOList.id_sanpham}">Xóa</a></td>
            </tr>
        </c:forEach>
    </table>
</div>


<script type="text/javascript" src="assert/Jquery/jquery.js"></script>
<script type="text/javascript" src="assert/js/search.js"></script>
<script type="text/javascript" src="assert/css/bootstrap/js//bootstrap.js"></script>
</body>
</html>

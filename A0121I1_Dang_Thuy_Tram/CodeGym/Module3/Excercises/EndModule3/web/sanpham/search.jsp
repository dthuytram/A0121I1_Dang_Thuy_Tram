<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>kết quả Search</title>
</head>
<body>

<table class="table table-secondary resultList">
    <tr class="table-dark">
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Màu sắc</th>
        <th>Mô tả</th>
        <th>Chỉnh sửa</th>
        <th>Xóa</th>
    </tr>

    Từ tìm kiếm:  <div class="mb-2 bg-success text-white rounded">${requestScope.tenSearch}</div>
        <c:forEach items="${sanPhamDTOList}" var="sanPhamSearchList">
            <tr>
                <td>${sanPhamSearchList.id_sanpham}</td>
                <td>${sanPhamSearchList.ten_sanpham}</td>
                <td>${sanPhamSearchList.gia}</td>
                <td>${sanPhamSearchList.soluong}</td>
                <td>${sanPhamSearchList.mausac}</td>
                <td>${sanPhamSearchList.mota}</td>
                <td>${sanPhamSearchList.ten_loai}</td>
                <td><a class="btn btn-outline-warning btn-sm" role="button" aria-pressed="true"
                       href="house?action=edit&id=${sanPhamSearchList.id_sanpham}">Sửa</a></td>
                <td><a class="btn btn-outline-danger btn-sm delete" role="button" aria-pressed="true"
                       href="house?action=delete&id=${sanPhamSearchList.id_sanpham}">Xóa</a></td>
            </tr>
        </c:forEach>
<%--    </c:otherwise>--%>
</table>
</body>
</html>

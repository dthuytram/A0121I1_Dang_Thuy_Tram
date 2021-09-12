
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo mới sản phẩm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assert/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>

<div class="create">
    <form action="sanpham" method="post">
        <div class="container viewCreateSanpham">

            <div class="form-group row">
                <label for="id_sanpham" class="col-sm-2 col-form-label">ID Sản Phẩm</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="id_sanpham" name="id_sanpham" value="${sanpham.id_sanpham}" required>
                    <c:if test="${errorId != null}">
                        <p style="color: red"><c:out value="${errorId}"/></p>
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="ten_sanpham" class="col-sm-2 col-form-label">Tên sản phẩm</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="ten_sanpham" name="ten_sanpham" value="${sanpham.ten_sanpham}" required>
                    <c:if test="${errorTen != null}">
                        <p style="color: red"><c:out value="${errorTen}"/></p>
                    </c:if>
                </div>
            </div>

<%--            <div class="form-group row">--%>
<%--                <label for="phone" class="col-sm-2 col-form-label">Phone Number</label>--%>
<%--                <div class="col-sm">--%>
<%--                    <input type="text" class="form-control" id="phone" name="phone"--%>
<%--                           value="${house.phone}">--%>
<%--                    <c:if test="${errorPhoneNumber != null}">--%>
<%--                        <p style="color: red"><c:out value="${errorPhoneNumber}"/></p>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--            </div>--%>

            <div class="form-group row">
                <label for="gia" class="col-sm-2 col-form-label">Giá sản phẩm</label>
                <div class="col-sm">
                    <input type="number" min="10000000" step="15000" class="form-control" id="gia" name="gia" value="${sanpham.gia}" required>
                    <c:if test="${errorGia != null}">
                        <p style="color: red"><c:out value="${errorGia}"/></p>
                    </c:if>
                </div>
            </div>
            <div class="form-group row">
                <label for="soluong" class="col-sm-2 col-form-label">Số lượng sản phẩm</label>
                <div class="col-sm">
                    <input type="number"  class="form-control" id="soluong" name="soluong" value="${sanpham.soluong}" required>
                    <c:if test="${errorSoluong != null}">
                        <p style="color: red"><c:out value="${errorSoluong}"/></p>
                    </c:if>
                </div>
            </div>
            <div class="form-group row">
                <label for="mausac" class="col-sm-2 col-form-label">Màu sắc sản phẩm</label>
                <div class="col-sm">
<%--                    <input type="text" class="form-control" id="mausac" name="mausac" value="${sanpham.mausac}">--%>
                    <select name="mausac" id="mausac" >
                        <option value="Den">Đen</option>
                        <option value="Do">Đỏ</option>
                        <option value="Hong">Hồng</option>
                        <option value="Tim">Tím</option>
                        <option value="Trang">Trắng</option>
                    </select>

                </div>
            </div>

            <div class="form-group row">
                <label for="mota" class="col-sm-2 col-form-label">Mô tả sản phẩm</label>
                <div class="col-sm">
                    <input type="text" class="form-control" id="mota" name="mota" value="${sanpham.mota}" required>
                    <c:if test="${errorMoTa != null}">
                        <p style="color: red"><c:out value="${errorMoTa}"/></p>
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Tên loại sản phẩm</label>
                <div class="col-sm">
                    <select name="id_loai" class="form-select" aria-label="Default select example">
                        <c:forEach items="${loaiList}" var="costList">
                            <c:choose>
                                <c:when test="${costList.id_loai == sanpham.id_loai}">
                                    <option value="${costList.id_loai}" selected>${costList.ten_loai}</option>
                                    <c:out value="${costList.id_loai}"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <option value="${costList.id_loai}">${costList.ten_loai}</option>
                                    <c:out value="${costList.id_loai}"></c:out>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </div>
            </div>

            <hr>
            <input type="submit" class="btn btn-outline-success" value="Tạo mới">
            <a class="btn btn-outline-secondary" href="sanpham" role="button">Trở lại</a>
        </div>
        <input type="hidden" name="action" value="create">
    </form>
</div>

<script type="text/javascript" src="assert/Jquery/jquery.js"></script>
<script type="text/javascript" src="assert/js/search.js"></script>
<script type="text/javascript" src="assert/css/bootstrap/js//bootstrap.js"></script>
</body>
</html>

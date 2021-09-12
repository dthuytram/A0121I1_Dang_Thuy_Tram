
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <nav>
        <div class="row container">
            <article class="col-sm-3">
                <a class="nav-link " href="/sanpham">Xem danh sách sản phẩm</a>
                <a class="nav-link " href="/sanpham?action=create">Thêm mới sản phẩm</a>
            </article>
            <article class="col-sm-9">
                <div class="container">
                    <form method="post" id="edit" class="form" >
                        <div class="form-group">
                            <label class="form-lable">Id sản phẩm</label>
                            <input type="text" name="id_sanpham" class="form-control" id="id_sanpham"  value="${sanPham.getId_sanpham()}"  readonly>
                        </div>
                        <div class="form-group">
                            <label class="form-lable">Tên</label>
                            <input type="text" name="ten_sanpham" class="form-control" id="ten_sanpham"  value="${sanPham.ten_sanpham}" >

                        </div>
                        <div class="form-group">
                            <label >Gia:</label>
                            <input type="text"  name="gia" class="form-control" id="gia" value="${sanPham.gia}" >
                        </div>
                        <div class="form-group">
                            <label >số lượng:</label>
                            <input type="text"  name="soluong" class="form-control" id="soluong"  value="${sanPham.soluong}" >
                        </div>
                        <div class="form-group">
                            <label >Màu sắc:</label>
                            <input type="text"  name="mausac" class="form-control"  id="mausac" value="${sanPham.mausac}" >

                        </div>
                        <div class="form-group">
                            <label  class="form-lable" >mo ta:</label>
                            <input type="text"  name="mota" class="form-control" id="mota"  value="${sanPham.mota}" >

                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Tên loại sản phẩm</label>
                            <div class="col-sm">
                                <select name="id_loai" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${loaiList}" var="loaiList">
                                        <c:choose>
                                            <c:when test="${loaiList.id_loai == sanPham.id_loai}">
                                                <option value="${loaiList.id_loai}" selected>${loaiList.ten_loai}</option>
                                                <c:out value="${loaiList.id_loai}"></c:out>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${loaiList.id_loai}">${loaiList.ten_loai}</option>
                                                <c:out value="${loaiList.id_loai}"></c:out>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <button type="submit" name="submit" class="btn btn-primary">Chỉnh sửa</button>
                                <input type="hidden" name="action" value="edit">
                            </div>
                        </div>
                    </form>

                </div>
            </article>
        </div>
    </nav>
</div>
</body>
</html>

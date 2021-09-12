<%@ page import="service.ITiecCuoiService" %>
<%@ page import="service.TiecCuoiService" %>
<%@ page import="bean.DichVu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 8/30/2021
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3 style="text-align: center">Quản lý Thông Tin Tiệc Cưới</h3>
<button type="button" name="" onclick="window.location.href='/thongtin?action=create'" id="" class="btn btn-primary">Đăng kí</button>

<table class="table table-bordered m-10">
    <thead class="thead-dark">
    <tr>
        <th>ngay to chuc</th>
        <th>Ten co dau</th>
        <th>ten chu re</th>
        <th>dich vu di kiem</th>
        <th>ngay dat coc</th>
        <th>ngay thanh toan</th>
        <th>trang thai</th>
        <th>hoat dong</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${thongtins}" var="thongtin">
        <tr>
            <td>${thongtin.ngayToChuc}</td>
            <td>${thongtin.tenCoDau}</td>
            <td>${thongtin.tenChuRe}</td>
            <td>
                <c:set var="myTest" value="${thongtin.getDichVuDiKem()}"/>
                <% int id = (int) pageContext.getAttribute("myTest"); %>
                <%
                    ITiecCuoiService iServiceThongtin = new TiecCuoiService();
                    DichVu dv= iServiceThongtin.selectByIdDichVu(id);
                    out.print(dv.getTenDichVu());
                %>     </td>
            <td>${thongtin.ngayDatCoc}</td>
            <td>${thongtin.ngayThanhToan}</td>
            <td>${thongtin.trangThai}</td>
            <td>
                <button class="btn btn-secondary" onclick="window.location.href='/thongtin?action=update&id=${thongtin.id}'">Sửa</button>
                <button class="btn btn-warning" onclick="window.location.href='/thongtin?action=delete&id=${thongtin.id}'">Xóa</button>
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModalx${thongtin.id}">
                    Xem
                </button>
                <!-- Modal -->
                <div class="modal fade bg-dark" id="exampleModalx${thongtin.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabelx${thongtin.id}">Xem chi tiết</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <table class="table">
                                    <tbody>

                                    <tr>
                                        <th>ngay to chuc</th>
                                        <td>   <input type="date" class="form-control" id="name" name="ngayToChuc" value="${thongtin.getNgayToChuc()}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>Ten co dau</th>
                                        <td>   <input type="text" class="form-control" name="tenCoDau" value="${thongtin.tenCoDau}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>ten chu re</th>
                                        <td>   <input type="text" class="form-control"  name="tenChuRe" value="${thongtin.tenChuRe}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>so luong</th>
                                        <td>   <input type="number" class="form-control"  name="soLuongBan" value="${thongtin.soLuongBan}" readonly> </td>
                                    </tr>

                                    <tr>
                                        <th>don gia</th>
                                        <td>   <input type="number" class="form-control"  name="donGia" value="${thongtin.donGia}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>dich vu di kiem</th>
                                        <td>
                                            <select class="form-control" name="dichVuDiKem" readonly>
                                                <c:forEach items="${dichVus}" var="dichVu">
                                                    <c:if test="${dichVu.idDichVu == thongtin.getDichVuDiKem()}">
                                                        <option selected value="${dichVu.idDichVu}">${dichVu.tenDichVu}</option>
                                                    </c:if>
                                                    <c:if test="${dichVu.idDichVu != thongtin.getDichVuDiKem()}">
                                                        <option disabled value="${dichVu.idDichVu}">${dichVu.tenDichVu}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>tien no dat coc</th>
                                        <td>   <input type="number" class="form-control" name="tienNoDatCoc" value="${thongtin.tenNoDatCoc}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>tien no thanh toan</th>
                                        <td>   <input type="number" class="form-control"  name="TienNoThanhToan" value="${thongtin.tienNoThanhToan}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>ngay dat coc</th>
                                        <td>   <input type="date" class="form-control"name="ngayDatCoc" value="${thongtin.ngayDatCoc}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>ngay thanh toan</th>
                                        <td>   <input type="date" class="form-control"  name="NgayThanhToan" value="${thongtin.ngayThanhToan}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>ghi chu</th>
                                        <td>   <input type="text" class="form-control"name="ghichu" value="${thongtin.ghiChu}" readonly> </td>
                                    </tr>
                                    <tr>
                                        <th>trang thai</th>
                                        <td>   <input type="text" class="form-control"  name="trangThai" value="${thongtin.trangThai}" readonly > </td>
                                    </tr>

                                    </tbody>
                                </table>


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">OK</button>

                            </div>
                        </div>
                    </div>
                </div>



            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>





<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
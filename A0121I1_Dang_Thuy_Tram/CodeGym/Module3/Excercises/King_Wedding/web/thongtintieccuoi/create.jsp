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
    <title>Tạo thông tin tiệc cưới</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

</head>
<body>
<div class="container">
    <h2 class="text-primary font-weight-bolder">Đăng kí tiệc cưới</h2>
    <form method="post bg-dark m-10 ">
        <table class="table">
            <tr>
                <th>Ngày tổ chức</th>
                <td>   <input type="date" class="form-control" id="name" name="ngayToChuc" required > </td>
            </tr>
            <tr>
                <th>Tên cô dâu</th>
                <td>   <input type="text" class="form-control" name="tenCoDau"required > </td>
            </tr>
            <tr>
                <th>Tên chú rể</th>
                <td>   <input type="text" class="form-control"  name="tenChuRe" required> </td>
            </tr>
            <tr>
                <th>Số lượng</th>
                <td>   <input type="text" min="1" max="10" step="2"  class="form-control"  name="soLuongBan" required> </td>
            </tr>

            <tr>
                <th>Đơn giá</th>
                <td>   <input type="number" min="10000" max="100000" step="1000"  class="form-control"  name="donGia"required > </td>
            </tr>
            <tr>
                <th>Dịch vụ đi kèm</th>
                <td>
                    <select name="dichVuDiKem " class="form-control">
                        <c:forEach items="${dichvu}" var="dichVu">
                            <option value="${dichVu.idDichVu}">${dichVu.tenDichVu}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Tiền nợ đặt cọc</th>
                <td>   <input type="number" min="10000" max="100000" step="1000"  class="form-control" name="tienNoDatCoc" required > </td>
            </tr>
            <tr>
                <th>Tiền nợ thanh toán</th>
                <td>   <input type="number" min="10000" max="100000" step="1000"  class="form-control"  name="TienNoThanhToan"  required> </td>
            </tr>
            <tr>
                <th>Ngày đặt cọc</th>
                <td>   <input type="date" class="form-control"name="ngayDatCoc"required > </td>
            </tr>
            <tr>
                <th>Ngày thanh toán</th>
                <td>   <input type="date" class="form-control"  name="NgayThanhToan" required> </td>
            </tr>
            <tr>
                <th>Ghi chú</th>
                <td>   <input type="text" class="form-control"name="ghichu"required > </td>
            </tr>
            <tr>
                <th>Trạng thái</th>
                <td>   <input type="text" class="form-control"  name="trangThai"required > </td>
            </tr>
        </table>
        <div class="float-right">
            <button class="btn-secondary btn" type="submit">Đăng kí</button>
            <button class="btn btn-primary " onclick="window.location.href='/thongtin'">Back Trang thông tin</button>

        </div>
    </form>
</div>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</body>
</html>

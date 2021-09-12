package controller;

import bean.DichVu;
import bean.ThongTinTiecCuoi;
import service.ITiecCuoiService;
import service.TiecCuoiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet({"","/thongtin"})
public class ThongTinServlet extends HttpServlet {
    ITiecCuoiService thongtin = new TiecCuoiService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreate(request, response);
                break;
            case "update":
                formUpdate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "search":
//                   searchById(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
//            case "search":
//                //   searchById(request, response);
//                break;
            default:
                showList(request, response);
        }
    }

//    Form Create
private void formCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String ngayToChuc = request.getParameter("ngayToChuc");
    String tenCoDau = request.getParameter("tenCoDau");
    String tenChuRe = request.getParameter("tenChuRe");
    int soLuongBan = Integer.parseInt(request.getParameter("soLuongBan"));
    int donGia = Integer.parseInt(request.getParameter("donGia"));
    int dichVuDiKem = Integer.parseInt(request.getParameter("dichVuDiKem"));
    int tenNoDatCoc = Integer.parseInt(request.getParameter("tienNoDatCoc"));
    int tienNoThanhToan = Integer.parseInt(request.getParameter("tienNoThanhToan"));
    String ngayDatCoc = request.getParameter("ngayDatCoc");
    String ngayThanhToan = request.getParameter("ngayThanhToan");
    String ghiChu = request.getParameter("ghiChu");
    String trangThai = request.getParameter("trangThai");

    thongtin.createThongtin(new ThongTinTiecCuoi(ngayToChuc, tenCoDau, tenChuRe, soLuongBan, donGia, dichVuDiKem, tenNoDatCoc, tienNoThanhToan, ngayDatCoc, ngayThanhToan, ghiChu, trangThai));
    if(thongtin!=null) {
        request.setAttribute("message", "Bạn đã thêm thành công");
    }else {
        request.setAttribute("message", "Bạn thêm  không thành công");

    }
    request.getRequestDispatcher("thongtintieccuoi/create.jsp").forward(request, response);

    }

    private void formUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ngayToChuc = request.getParameter("ngayToChuc");
        String tenCoDau = request.getParameter("tenCoDau");
        String tenChuRe = request.getParameter("tenChuRe");
        int soLuongBan = Integer.parseInt(request.getParameter("soLuongBan"));
        int donGia = Integer.parseInt(request.getParameter("donGia"));
        int dichVuDiKem = Integer.parseInt(request.getParameter("dichVuDiKem"));
        int tenNoDatCoc = Integer.parseInt(request.getParameter("tienNoDatCoc"));
        int tienNoThanhToan = Integer.parseInt(request.getParameter("tienNoThanhToan"));
        String ngayDatCoc = request.getParameter("ngayDatCoc");
        String ngayThanhToan = request.getParameter("ngayThanhToan");
        String ghiChu = request.getParameter("ghiChu");
        String trangThai = request.getParameter("trangThai");

        thongtin.update(new ThongTinTiecCuoi(ngayToChuc, tenCoDau, tenChuRe, soLuongBan, donGia, dichVuDiKem, tenNoDatCoc, tienNoThanhToan, ngayDatCoc, ngayThanhToan, ghiChu, trangThai),id);
        response.sendRedirect("/thongtin");

    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DichVu> dichVus = thongtin.dichVuList();
        request.setAttribute("dichVus", dichVus);
        request.getRequestDispatcher("thongtintieccuoi/create.jsp").forward(request, response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThongTinTiecCuoi> thongtinTiecCuois = thongtin.thongtinList();
        List<DichVu> dichVus = thongtin.dichVuList();
        request.setAttribute("dichVus", dichVus);
        request.setAttribute("thongtins", thongtinTiecCuois);
        request.getRequestDispatcher("thongtintieccuoi/list.jsp").forward(request, response);

    }
    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ThongTinTiecCuoi thongtinTiecCuoi = thongtin.selectById(id);
        List<DichVu> dichVus = thongtin.dichVuList();
        request.setAttribute("dichVus", dichVus);
        request.setAttribute("thongtin", thongtinTiecCuoi);
        request.getRequestDispatcher("thongtintieccuoi/update.jsp").forward(request, response);

    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        thongtin.delete(id);
        if(thongtin.delete(id)!=false) {
            request.setAttribute("message", "Bạn đã xóa thành công");
        }else {
            request.setAttribute("message", "Bạn xóa  không thành công");

        }
        response.sendRedirect("/thongtin");
    }
}

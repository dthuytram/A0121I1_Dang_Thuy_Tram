package controller;

import common.Validate;
import model.Loai;
import model.Sanpham;
import model.SanphamDTO;
import service.ILoaiService;
import service.ISanphamService;
import service.impl.LoaiServiceImpl;
import service.impl.SanphamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.jar.JarOutputStream;

@WebServlet(name = "SanphamServlet", urlPatterns = {"", "/sanpham"})
public class SanphamServlet extends HttpServlet {
    private ISanphamService sanphamService = new SanphamServiceImpl();
    private ILoaiService loaiService = new LoaiServiceImpl();

    private void listSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<SanphamDTO> sanPhamDTOList = this.sanphamService.getAllSanPhamDTO();
        request.setAttribute("sanPhamDTOList", sanPhamDTOList);
        request.getRequestDispatcher("sanpham/list.jsp").forward(request, response);
    }

    private void viewCreateSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Loai> loaiList = this.loaiService.getAllLoai();
        request.setAttribute("loaiList", loaiList);
        request.getRequestDispatcher("sanpham/create.jsp").forward(request, response);
    }

    private void searchSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("nameSearch");
        request.setAttribute("tenSearch", name);
        if(name!=null) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
            List<SanphamDTO> sanPhamDTOList = name == null ? this.sanphamService.getAllSanPhamDTO() : this.sanphamService.searchByName(name);
            request.setAttribute("sanPhamDTOList", sanPhamDTOList);
            request.getRequestDispatcher("sanpham/search.jsp").forward(request, response);

    }

    private void createSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id_sanpham = request.getParameter("id_sanpham");
        String ten_sanpham = request.getParameter("ten_sanpham");
        String gia_1 = request.getParameter("gia");
        float gia = Float.parseFloat(gia_1);
        String soluong_1 = request.getParameter("soluong");
        int soluong = Integer.parseInt(soluong_1);
        String mausac = request.getParameter("mausac");
        System.out.println(mausac);
        String mota = request.getParameter("mota");
        String id_loai = request.getParameter("id_loai");
        Sanpham sanpham = new Sanpham(id_sanpham, ten_sanpham, gia, soluong, mausac, mota, id_loai);

        String errorTen = null;
        String errorId = null;
        String errorPhoneNumber = null, errorMoTa = null;
        String errorSoluong = null, errorGia = null, errorMausac = null;

        boolean flag = true;

        if (soluong <= 0 ) {
            errorSoluong = "Soluong phải là số nguyên dương ";
            flag = false;
        }

        if (id_sanpham.isEmpty()) {
            errorId = "Trường id_sanpham không để trống";
            flag = false;
        }

        if (ten_sanpham.isEmpty()) {
            errorTen = "Trường tên không để trống";
            flag = false;
        }
        if (mausac.isEmpty()) {
            errorMausac = "Trường màu không để trống";
            flag = false;

        }
        if (mota.isEmpty()) {
            errorMoTa = "Trường mô tả không để trống";
            flag = false;
        }
        if (gia_1.isEmpty()) {
            errorGia = "Trường giá không để trống";
            flag = false;

        }

        if (!flag) {
            request.setAttribute("sanpham", sanpham);
            request.setAttribute("errorMoTa", errorMoTa);
            request.setAttribute("errorMausac", errorMausac);
//            request.setAttribute("errorPhoneNumber", errorPhoneNumberrPhoneNumber);
            request.setAttribute("errorId", errorId);
            request.setAttribute("errorTen", errorTen);
            request.setAttribute("errorSoluong", errorSoluong);
            request.setAttribute("errorGia", errorGia);
        } else {
            this.sanphamService.saveSanPham(new Sanpham(id_sanpham, ten_sanpham, gia, soluong, mausac, mota, id_loai));
            request.setAttribute("message", "Thêm mới thành công!");
            listSanPham(request, response);
        }
        viewCreateSanPham(request, response);
    }


    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        this.sanphamService.deleteSanPham(id);
        request.setAttribute("message", "Xóa thành công!");
        listSanPham(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createSanPham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    searchSanPham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editSanpham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listSanPham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editSanpham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("id_sanpham");
        String name = request.getParameter("ten_sanpham");
        String idLoai = request.getParameter("id_loai");
        float gia = Float.parseFloat(request.getParameter("gia"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String mausac = request.getParameter("mausac");
        String mota = request.getParameter("mota");


        this.sanphamService.updateSanPham(new Sanpham(id, name, gia, soluong, mausac, mota, idLoai), id);
        listSanPham(request, response);
    }

    private void viewEditSanpham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = "";
        try {
            request.getParameter("id_sanpham");
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        System.out.println(id);
        List<Loai> loaiList = this.loaiService.getAllLoai();
        Sanpham sanPham = this.sanphamService.getSanPhamById(id);
        request.setAttribute("loaiList", loaiList);
        request.setAttribute("sanPham", sanPham);
        request.getRequestDispatcher("sanpham/edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    viewCreateSanPham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteSanPham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    viewEditSanpham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                try {
                    listSanPham(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}

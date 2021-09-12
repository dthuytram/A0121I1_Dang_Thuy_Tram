package dao;

import model.Sanpham;

import java.sql.SQLException;
import java.util.List;

public interface ISanphamDAO {
    void saveSanPham(Sanpham sanpham) throws SQLException;

    Sanpham getSanPhamById(String id) throws SQLException;

    List<Sanpham> getAllSanPham() throws SQLException;

    boolean deleteSanPham(String id) throws SQLException;

    boolean updateSanPham(Sanpham sanpham) throws SQLException;
}

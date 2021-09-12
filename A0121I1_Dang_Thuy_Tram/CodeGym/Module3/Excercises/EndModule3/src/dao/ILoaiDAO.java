package dao;

import model.Loai;

import java.sql.SQLException;
import java.util.List;

public interface ILoaiDAO {

    void saveLoai(Loai loai) throws SQLException;

    Loai getLoaiById(String id) throws SQLException;

    List<Loai> getAllLoai() throws SQLException;

    boolean deleteLoai(String id) throws SQLException;

    boolean updateLoai(Loai loai) throws SQLException;
}

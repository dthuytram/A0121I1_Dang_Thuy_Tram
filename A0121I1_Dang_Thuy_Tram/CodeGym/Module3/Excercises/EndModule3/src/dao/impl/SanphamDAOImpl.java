package dao.impl;

import common.DBConnection;
import dao.ISanphamDAO;
import model.Sanpham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanphamDAOImpl implements ISanphamDAO {
    public static Connection connection = DBConnection.getConnection();
    public static final String INSERT_HOUSE = "insert into sanpham(idsanpham, ten_sanpham, gia, soluong, mausac,mota, id_loai) value(?, ?, ?, ?, ?,?, ?)";
    public static final String GET_HOUSE_BY_ID = "select * from sanpham where idsanpham = ?";
    public static final String GET_ALL_HOUSE = "select * from sanpham";
    public static final String DELETE_HOUSE = "delete from sanpham where idsanpham = ?";
    public static final String UPDATE_HOUSE = "update sanpham set ten_sanpham = ?, gia = ?, soluong = ?, mausac = ?, mota = ?, id_cost = ? where idsanpham = ?";


    @Override
    public void saveSanPham(Sanpham sanpham) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOUSE);
        preparedStatement.setString(1, sanpham.getId_sanpham());
        preparedStatement.setString(2, sanpham.getTen_sanpham());
        preparedStatement.setFloat(3, sanpham.getGia());
        preparedStatement.setInt(4, sanpham.getSoluong());
        preparedStatement.setString(5, sanpham.getMausac());
        preparedStatement.setString(6, sanpham.getMota());
        preparedStatement.setString(7, sanpham.getId_loai());
        preparedStatement.executeUpdate();
    }

    @Override
    public Sanpham getSanPhamById(String id) throws SQLException {
        Sanpham sanpham = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_HOUSE_BY_ID);
        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String ten_sanpham = resultSet.getString("ten_sanpham");
            Float gia = Float.parseFloat(resultSet.getString("gia"));
            int soluong = Integer.parseInt(resultSet.getString("soluong"));
            String mausac = resultSet.getString("mausac");
            String mota = resultSet.getString("mota");
            String id_loai = resultSet.getString("id_loai");
            sanpham = new Sanpham(id, ten_sanpham, gia, soluong, mausac, mota,id_loai );
        }
        return sanpham;
    }

    @Override
    public List<Sanpham> getAllSanPham() throws SQLException {
        List<Sanpham> sanphamList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_HOUSE);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("idsanpham");
            String ten_sanpham = resultSet.getString("ten_sanpham");
            Float gia = Float.parseFloat(resultSet.getString("gia"));
            int soluong = Integer.parseInt(resultSet.getString("soluong"));
            String mausac = resultSet.getString("mausac");
            String mota = resultSet.getString("mota");
            String id_loai = resultSet.getString("id_loai");
            sanphamList.add(new Sanpham(id, ten_sanpham, gia, soluong, mausac, mota,id_loai) );

        }
        return sanphamList;
    }

    @Override
    public boolean deleteSanPham(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_HOUSE);
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateSanPham(Sanpham sanpham) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOUSE);
        preparedStatement.setString(1, sanpham.getTen_sanpham());
        preparedStatement.setFloat(3, sanpham.getGia());
        preparedStatement.setInt(4, sanpham.getSoluong());
        preparedStatement.setString(5, sanpham.getMausac());
        preparedStatement.setString(6, sanpham.getMota());
        preparedStatement.setString(6, sanpham.getId_sanpham());
        preparedStatement.setString(7, sanpham.getId_loai());
        return preparedStatement.executeUpdate() > 0;
    }
}

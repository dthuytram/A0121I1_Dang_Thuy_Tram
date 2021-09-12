package dao.impl;

import common.DBConnection;
import dao.ILoaiDAO;
import model.Loai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiDAOImpl implements ILoaiDAO {
    public static Connection connection = DBConnection.getConnection();
    public static final String INSERT_COST = "insert into loai(id_loai, ten_loai) value(?, ?)";
    public static final String GET_COST_BY_ID = "select * from loai where id_loai = ?";
    public static final String GET_ALL_COST = "select * from loai";
    public static final String DELETE_COST = "delete from loai where id_loai = ?";
    public static final String UPDATE_COST = "update loai set ten_loai = ? where id_loai = ?";



    @Override
    public void saveLoai(Loai loai) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COST);
        preparedStatement.setString(1, loai.getId_loai());
        preparedStatement.setString(2, loai.getTen_loai());
        preparedStatement.executeUpdate();
    }

    @Override
    public Loai getLoaiById(String id) throws SQLException {
        Loai loai = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_COST_BY_ID);
        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("ten_loai");
            loai = new Loai(id, name);
        }
        return loai;
    }

    @Override
    public List<Loai> getAllLoai() throws SQLException {
        List<Loai> costList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_COST);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id_loai");
            String name = resultSet.getString("ten_loai");
            costList.add( new Loai(id, name));
        }
        return costList;
    }

    @Override
    public boolean deleteLoai(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COST);
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateLoai(Loai cost) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COST);
        preparedStatement.setString(1, cost.getTen_loai());
        preparedStatement.setString(2, cost.getId_loai());
        return preparedStatement.executeUpdate() > 0;
    }
}


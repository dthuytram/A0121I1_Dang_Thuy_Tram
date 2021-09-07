package service.service_type_Service;

import common.DBConnection;
import dao.service_typeDAO.IServiceTypeDAO;
import model.service.Rent_Type;
import model.service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service_Type implements IService_Type {
    public static Connection connection = DBConnection.getConnection();
    public static final String INSERT_TYPE_SERVICE = "insert into sv_type_services(id, name) value(?, ?)";
    public static final String GET_TYPE_SERVICE_BY_ID = "select * from sv_type_services where id = ?";
    public static final String GET_ALL_TYPE_SERVICE = "select * from sv_type_services";
    public static final String DELETE_TYPE_SERVICE = "delete from sv_type_services where id = ?";
    public static final String UPDATE_TYPE_SERVICE = "update sv_type_services set name = ?  where id = ?";

    @Override
    public void saveTypeService(model.service.Service_Type typeService) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TYPE_SERVICE);
        preparedStatement.setInt(1, typeService.getId());
        preparedStatement.setString(2, typeService.getName());
        preparedStatement.executeUpdate();
    }

    @Override
    public model.service.Service_Type getTypeServiceById(int id) throws SQLException {
        model.service.Service_Type typeService = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPE_SERVICE_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            typeService = new model.service.Service_Type(id, name);
        }
        return typeService;
    }

    @Override
    public List<model.service.Service_Type> getAllTypeService() throws SQLException {
        List<model.service.Service_Type> typeServices = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TYPE_SERVICE);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            typeServices.add(new model.service.Service_Type(id, name));
        }
        return typeServices;
    }

    @Override
    public boolean deleteTypeService(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TYPE_SERVICE);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateTypeService(model.service.Service_Type typeService) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TYPE_SERVICE);
        preparedStatement.setString(1, typeService.getName());
        preparedStatement.setInt(2, typeService.getId());
        return preparedStatement.executeUpdate() > 0;
    }
}



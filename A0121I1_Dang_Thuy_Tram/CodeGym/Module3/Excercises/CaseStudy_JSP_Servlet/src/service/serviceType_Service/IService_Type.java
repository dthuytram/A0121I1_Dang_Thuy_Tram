package service.service_type_Service;

import model.service.Rent_Type;

import java.sql.SQLException;
import java.util.List;

public interface IService_Type {
    void saveTypeService(model.service.Service_Type typeService) throws SQLException;

    model.service.Service_Type getTypeServiceById(int id) throws SQLException;

    List<model.service.Service_Type> getAllTypeService() throws SQLException;

    boolean deleteTypeService(int id) throws SQLException;

    public boolean updateTypeService(model.service.Service_Type typeService) throws SQLException;
}

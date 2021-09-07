package service.service_typeRent_Service;

import model.service.Rent_Type;

import java.sql.SQLException;
import java.util.List;

public interface IRent_Type {
    void saveTypeRentService(Rent_Type typeRent) throws SQLException;

    Rent_Type getTypeRentServiceById(int id) throws SQLException;

    List<Rent_Type> getAllTypeRentService() throws SQLException;

    boolean deleteTypeRentService(int id) throws SQLException;

    boolean updateTypeRentService(Rent_Type typeRent, int id) throws SQLException;
}

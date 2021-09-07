package service.service_typeRent_Service;

import common.DBConnection;
import dao.service_typeRentDAO.IServiceTypeRentDAO;
import dao.service_typeRentDAO.ServiceTypeRentDAO;
import model.service.Rent_Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Rent_TypeImpl implements IRent_Type {
    @Override
    public List<Rent_Type> findAll() {
        return null;
    }

    @Override
    public void save(Rent_Type kieuthue) {

    }

    @Override
    public List<Rent_Type> findByName(String name) {
        return null;
    }

    @Override
    public Rent_Type update(int id, Rent_Type kieuthue) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Rent_Type findById(int id) {
        return null;
    }
}

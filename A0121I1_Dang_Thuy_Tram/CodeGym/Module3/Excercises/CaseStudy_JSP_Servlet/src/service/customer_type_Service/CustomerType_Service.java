package service.customer_type_Service;

import dao.customer_typeDAO.CustomerTypeDAO;
import dao.customer_typeDAO.ICustomerTypeDAO;
import model.customer.Customer_Type;

import java.sql.SQLException;
import java.util.List;

public class Customer_Service implements ICustomer_Service {
    private ICustomerTypeDAO typeCustomerDAO = new CustomerTypeDAO();

    @Override
    public void saveTypeCustomer(Customer_Type typeCustomer) throws SQLException {
        this.typeCustomerDAO.saveTypeCustomer(typeCustomer);
    }

    @Override
    public Customer_Type getTypeCustomerById(int id) throws SQLException {
        return this.typeCustomerDAO.getTypeCustomerById(id);
    }

    @Override
    public List<Customer_Type> getAllTypeCustomer() throws SQLException {
        return this.typeCustomerDAO.getAllTypeCustomer();
    }

    @Override
    public boolean deleteTypeCustomer(int id) throws SQLException {
        return this.typeCustomerDAO.deleteTypeCustomer(id);
    }

    @Override
    public boolean updateTypeCustomer(Customer_Type typeCustomer, int id) throws SQLException {
        return this.typeCustomerDAO.updateTypeCustomer(typeCustomer);
    }
}

package dao.customer_typeDAO;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    void saveCustomer(Customer customer) throws SQLException;

    Customer getCustomerById(int id) throws SQLException;

    List<Customer> getAllCustomer() throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

//    List<CS_CustomerUseDTO> getAllCustomerUseService() throws SQLException;
}

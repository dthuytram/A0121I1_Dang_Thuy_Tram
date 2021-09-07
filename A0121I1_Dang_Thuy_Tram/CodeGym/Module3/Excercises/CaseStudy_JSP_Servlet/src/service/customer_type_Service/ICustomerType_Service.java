package service.customer_type_Service;

import dao.customer_typeDAO.CustomerTypeDAO;
import dao.customer_typeDAO.ICustomerTypeDAO;
import model.customer.Customer;
import model.customer.Customer_Type;

import java.sql.SQLException;
import java.util.List;

public interface ICustomer_Service {

    void saveCustomer(Customer customer) throws SQLException;

    Customer getCustomerById(int id) throws SQLException;

    List<Customer> getAllCustomer() throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer customer, int id) throws SQLException;

//    List<CustomerDTO> getAllCustomerDTO() throws SQLException;

//    List<CustomerDTO> searchCustomerDTO(String name) throws  SQLException;

//    List<CS_CustomerUseDTO> getAllCustomerUseService() throws SQLException;
}

package dao.customer_typeDAO;

import common.DBConnection;
import model.customer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    public static Connection connection = DBConnection.getConnection();
    public static final String INSERT_CUSTOMER = "insert into cs_customer(id, name, birthday, gender, identity, phone_number, email, address, id_type_customer) value(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_CUSTOMER_BY_ID = "select * from cs_customer where id = ?";
    public static final String GET_ALL_CUSTOMER = "select * from cs_customer";
    public static final String DELETE_CUSTOMER = "delete from cs_customer where id = ?";
    public static final String UPDATE_CUSTOMER = "update cs_customer set name = ?, birthday = ?, gender = ?, identity = ?, phone_number = ?, email = ?, address = ?, id_type_customer = ? where id = ?";
    public static final  String GET_CUSTOMER_USE_SERVICE = "     select cs_customer.id as idCustomer, cs_customer.name, cs_type_customer.id as idTypeCustomer, cs_type_customer.name as nameTypeCustomer, ct_services_include.name as nameServiceInclude\n" +
            "     from cs_customer\n" +
            "     join ct_contract on cs_customer.id = ct_contract.id_customer\n" +
            "     join ct_contract_detail on ct_contract.id = ct_contract_detail.id_contract\n" +
            "     join ct_services_include on ct_services_include.id = ct_contract_detail.id_services_include\n" +
            "\tjoin cs_type_customer on cs_customer.id_type_customer = cs_type_customer.id\n" +
            "     \n" +
            "     ";

    @Override
    public void saveCustomer(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
        preparedStatement.setInt(1, customer.getId());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setString(3, customer.getBirthday());
        preparedStatement.setString(4, customer.getGender());
        preparedStatement.setString(5, customer.getId_card());
        preparedStatement.setString(6, customer.getPhoneNumber());
        preparedStatement.setString(7, customer.getEmail());
        preparedStatement.setString(8, customer.getAddress());
        preparedStatement.setInt(9, customer.getIdTypeCustomer());
        preparedStatement.executeUpdate();
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        Customer customer = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String gender = resultSet.getString("gender");
            String identity = resultSet.getString("identity");
            String phone_number = resultSet.getString("phone_number");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            int id_type_customer = resultSet.getInt("id_type_customer");
            customer = new Customer(id, name, birthday, gender, identity, phone_number, email, address, id_type_customer);
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String gender = resultSet.getString("gender");
            String identity = resultSet.getString("identity");
            String phone_number = resultSet.getString("phone_number");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            int id_type_customer = resultSet.getInt("id_type_customer");
            customerList.add(new Customer(id, name, birthday, gender, identity, phone_number, email, address, id_type_customer));
        }
        return customerList;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getBirthday());
        preparedStatement.setString(3, customer.getGender());
        preparedStatement.setString(4, customer.getId_card());
        preparedStatement.setString(5, customer.getPhoneNumber());
        preparedStatement.setString(6, customer.getEmail());
        preparedStatement.setString(7, customer.getAddress());
        preparedStatement.setInt(8, customer.getIdTypeCustomer());
        preparedStatement.setInt(9, customer.getId());
        return preparedStatement.executeUpdate() > 0;
    }

//    @Override
//    public List<CS_CustomerUseDTO> getAllCustomerUseService() throws SQLException {
//        List<CS_CustomerUseDTO> customerList = new ArrayList<>();
//        PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_USE_SERVICE);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            int idCustomer = resultSet.getInt("idCustomer");
//            String name = resultSet.getString("name");
//            int idTypeCustomer = resultSet.getInt("idTypeCustomer");
//            String nameTypeCustomer = resultSet.getString("nameTypeCustomer");
//            String nameServiceInclude = resultSet.getString("nameServiceInclude");
//
//            CS_CustomerUseDTO customerUse = new CS_CustomerUseDTO(idCustomer, name, idTypeCustomer, nameTypeCustomer, nameServiceInclude);
//            customerList.add(customerUse);
//        }
//        return customerList;
//    }
//}
}

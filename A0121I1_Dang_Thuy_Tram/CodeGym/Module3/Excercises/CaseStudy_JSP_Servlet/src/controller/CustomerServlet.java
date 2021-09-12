package controller;

import common.Validate;
import model.customer.Customer;
import model.customer.Customer_Type;
import service.customer_Service.Customer_Service;
import service.customer_Service.ICustomer_Service;
import service.customer_type_Service.CustomerType_Service;
import service.customer_type_Service.ICustomerType_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/customer"})
public class CustomerServlet extends HttpServlet {
    ICustomer_Service customerService = new Customer_Service();
    ICustomerType_Service typeCustomerService = new CustomerType_Service();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                try {
                    editCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "create":
                try {
                    createCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    searchCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    //===================
    // Các hàm của doPost

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NumberFormatException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Customer customer = this.customerService.getCustomerById(id);
        if(customer!=null) {
            Customer_Type typeCustomer = this.typeCustomerService.getTypeCustomerById(customer.getIdTypeCustomer());
            request.setAttribute("typeCustomer", typeCustomer);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("customer/view.jsp").forward(request, response);
        }
        else {
            System.out.println("Error");
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String name = request.getParameter("name");
        int idTypeCustomer = 0;
        try {
            idTypeCustomer = Integer.parseInt(request.getParameter("typeCustomer"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//        int idTypeCustomer = Integer.parseInt(request.getParameter("idTypeCustomer"));
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String identity = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        this.customerService.updateCustomer(new Customer(id, name, birthday, gender, identity, phoneNumber, email, address, idTypeCustomer), id);
        viewCustomer(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String identity = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idTypeCustomer = 0;
        try {
            idTypeCustomer = Integer.parseInt(request.getParameter("TypeCustomer"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//        Customer customer = new Customer(id, name, birthday, gender, identity, phoneNumber, email, address, idTypeCustomer);

//        String errorPhoneNumber = null;
//        String errorEmail = null;
//        boolean check = true;
//        if (!Validate.checkPhoneNumber(phoneNumber)) {
//            errorPhoneNumber = "(xxxxxxxxxx)";
//            check = false;
//        }
//
//        if (!Validate.checkEmail(email)) {
//            errorEmail = "fail email";
//            check = false;
//        }

//        if (!check) {
//            request.setAttribute("customer", customer);
//            request.setAttribute("errorPhoneNumber", errorPhoneNumber);
//            request.setAttribute("errorEmail", errorEmail);
//        } else {
            this.customerService.saveCustomer(new Customer(id, name, birthday, gender, identity, phoneNumber, email, address, idTypeCustomer));
            listCustomer(request, response);
//        }
        viewCreateCustomer(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Customer> customerList = this.customerService.getAllCustomer();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("nameSearch");
//        System.out.println("Name: "+ name);
        List<Customer> customerList = name == null ? this.customerService.getAllCustomer() : this.customerService.searchCustomerDTO(name);
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/result.jsp").forward(request, response);
    }

    //==================
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    viewCreateCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    viewEditCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                try {
                    viewCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
//            case "viewCustomerUseService" :
//                try {
//                    viewCustomerUseService(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
            default:
                try {
                    listCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    //===================
    // Các hàm của doGet
    private void viewEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<Customer_Type> typeCustomerList = this.typeCustomerService.getAllTypeCustomer();
        Customer customer = this.customerService.getCustomerById(id);
        request.setAttribute("typeCustomerList", typeCustomerList);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
    }

    private void viewCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Customer_Type> typeCustomerList = this.typeCustomerService.getAllTypeCustomer();
        request.setAttribute("typeCustomerList", typeCustomerList);
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.customerService.deleteCustomer(id);
        listCustomer(request, response);
    }
    //===================
}

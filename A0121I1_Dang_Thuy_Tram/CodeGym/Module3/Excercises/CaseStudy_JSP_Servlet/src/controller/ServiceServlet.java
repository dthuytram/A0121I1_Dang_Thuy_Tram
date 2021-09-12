package controller;

import dao.service_typeDAO.IServiceTypeDAO;
import dao.service_typeDAO.ServiceTypeDAO;
import dao.service_typeRentDAO.IServiceTypeRentDAO;
import dao.service_typeRentDAO.ServiceTypeRentDAO;
import model.service.Rent_Type;
import model.service.Service;
import model.service.Service_Type;
import model.service.plus.ServiceDTO;
import service.service_Service.IService;
import service.service_Service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {
    private IService service = new ServiceImpl();
    private IServiceTypeDAO serviceType = new ServiceTypeDAO();
    private IServiceTypeRentDAO serviceTypeRent = new ServiceTypeRentDAO();

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<ServiceDTO> serviceDTOList = this.service.getAllServiceDTO();
        request.setAttribute("serviceDTOList", serviceDTOList);
        request.getRequestDispatcher("service/list.jsp").forward(request, response);
    }

    private void viewCreateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Rent_Type> typeRentList = this.serviceTypeRent.getAllTypeRentService();
        List<Service_Type> typeServiceList = this.serviceType.getAllTypeService();
        request.setAttribute("typeRentList", typeRentList);
        request.setAttribute("typeServiceList", typeServiceList);
        request.getRequestDispatcher("service/create.jsp").forward(request, response);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int idTypeRent = 0;
        try {
            idTypeRent = Integer.parseInt(request.getParameter("typeRent"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int idTypeService = 0;
        try {
            idTypeService = Integer.parseInt(request.getParameter("typeService"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String name = request.getParameter("name");
        int area = 0;
        try {
            area = Integer.parseInt(request.getParameter("area"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int floor = 0;
        try {
            floor = Integer.parseInt(request.getParameter("floor"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String amount = request.getParameter("amount");
        String price = request.getParameter("price");
        String status = request.getParameter("status");
        this.service.saveService(new model.service.Service(id, name, area, floor, amount, price, status, new Rent_Type(idTypeRent), new Service_Type(idTypeService)));
        listService(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String name = request.getParameter("name");
        int idTypeRent = 0;
        try {
            idTypeRent = Integer.parseInt(request.getParameter("typeRent"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int idTypeService = 0;
        try {
            idTypeService = Integer.parseInt(request.getParameter("typeService"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int area = 0;
        try {
            area = Integer.parseInt(request.getParameter("area"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int floor = 0;
        try {
            floor = Integer.parseInt(request.getParameter("floor"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String amount = request.getParameter("amount");
        String price = request.getParameter("price");
        String status = request.getParameter("status");
        this.service.updateService(new Service(id, name, area, floor, amount, price, status, new Rent_Type(idTypeRent), new Service_Type(idTypeService)),id);

       listService(request, response);
    }

    private void viewService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Service service = this.service.getServiceById(id);
        if(service!=null) {
            Service_Type typeService = this.serviceType.getTypeServiceById(service.getIdServiceType());
            request.setAttribute("typeService", typeService);
            request.setAttribute("service", service);
            request.getRequestDispatcher("service/view.jsp").forward(request, response);
        }
        else {
            System.out.println("Error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                try {
                    viewCreateService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                try {
                    viewService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    viewEditService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void viewEditService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<Service_Type> typeCustomerList = this.serviceType.getAllTypeService();
        List<Rent_Type> typeRentList = this.serviceTypeRent.getAllTypeRentService();
        Service service = this.service.getServiceById(id);
        request.setAttribute("typeServiceList", typeCustomerList);
        request.setAttribute("typeRentList", typeRentList);
        request.setAttribute("service", service);
        request.getRequestDispatcher("service/edit.jsp").forward(request, response);

    }
}
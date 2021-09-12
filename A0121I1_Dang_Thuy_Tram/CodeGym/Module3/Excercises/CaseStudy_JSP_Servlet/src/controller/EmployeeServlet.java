package controller;

import model.employee.Department_Employee;
import model.employee.Employee;
import model.employee.Level_Employee;
import model.employee.Position_Employee;
import model.employee.plus.EmployeeDTO;
import service.employeeDepart_Service.Employee_DepartImpl;
import service.employeeDepart_Service.IEmployee_DepartService;
import service.employeeLevel_Service.Employee_LevelImpl;
import service.employeeLevel_Service.IEmployee_LevelService;
import service.employeePosition_Service.Employee_PositionImpl;
import service.employeePosition_Service.IEmployee_PositionService;
import service.employee_Service.Employee_Impl;
import service.employee_Service.IEmployee_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.DesktopPaneUI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"","/employee"})
public class EmployeeServlet extends HttpServlet {
    private IEmployee_Service employeeService = new Employee_Impl();
    private IEmployee_LevelService employeeLevelService = new Employee_LevelImpl();
    private IEmployee_PositionService employeePositionService = new Employee_PositionImpl();
    private IEmployee_DepartService employeeDepartmentService = new Employee_DepartImpl();

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<EmployeeDTO> employeeDTOList = this.employeeService.getAllEmployeeDTO();
        request.setAttribute("employeeDTOList", employeeDTOList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.getEmployeeById(id);
        Level_Employee levelEmployee = this.employeeLevelService.getLevelEmployeeById(employee.getIdLevelEmployee());
        Position_Employee positionEmployee = this.employeePositionService.getPositionEmployeeById(employee.getIdPositionEmployee());
        Department_Employee departmentEmployee = this.employeeDepartmentService.getDepartmentEmployeeById(employee.getIdDepartmentEmployee());
        request.setAttribute("levelEmployee", levelEmployee);
        request.setAttribute("positionEmployee", positionEmployee);
        request.setAttribute("departmentEmployee", departmentEmployee);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee/view.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.employeeService.deleteEmployee(id);
        listEmployee(request, response);
    }

    private void viewCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Position_Employee> positionEmployeeList = this.employeePositionService.getAllPositionEmployee();
        List<Department_Employee> departmentEmployeeList = this.employeeDepartmentService.getAllDepartmentEmployee();
        List<Level_Employee> levelEmployeeList = this.employeeLevelService.getAllLevelEmployee();
        request.setAttribute("positionEmployeeList", positionEmployeeList);
        request.setAttribute("departmentEmployeeList", departmentEmployeeList);
        request.setAttribute("levelEmployeeList", levelEmployeeList);
        request.getRequestDispatcher("employee/create.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int  idLevel = Integer.parseInt(request.getParameter("levelEmployee"));
        int idDepartment = Integer.parseInt(request.getParameter("departmentEmployee"));
        int idPosition = Integer.parseInt(request.getParameter("positionEmployee"));
        String birthday = request.getParameter("birthday");
        String identity = request.getParameter("identity");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String salary = request.getParameter("salary");
        this.employeeService.saveEmployee(new Employee(id, idLevel, idPosition, idDepartment, name, birthday, identity, phoneNumber, email, salary));
        listEmployee(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("nameEmployeeSearch");
        List<EmployeeDTO> employeeDTOList = name == null ? this.employeeService.getAllEmployeeDTO() : this.employeeService.searchEmployeeDTO(name);
        request.setAttribute("employeeDTOList", employeeDTOList);
        request.getRequestDispatcher("employee/result.jsp").forward(request, response);
    }

    private void viewEditEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.getEmployeeById(id);
        List<Position_Employee> positionEmployeeList = this.employeePositionService.getAllPositionEmployee();
        List<Department_Employee> departmentEmployeeList = this.employeeDepartmentService.getAllDepartmentEmployee();
        List<Level_Employee> levelEmployeeList = this.employeeLevelService.getAllLevelEmployee();
        request.setAttribute("employee", employee);
        request.setAttribute("positionEmployeeList", positionEmployeeList);
        request.setAttribute("departmentEmployeeList", departmentEmployeeList);
        request.setAttribute("levelEmployeeList", levelEmployeeList);
        request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String name = request.getParameter("name");
        int idLevel = 0;
        try {
            idLevel = Integer.parseInt(request.getParameter("levelEmployee"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int idPosition = 0;
        try {
            idPosition = Integer.parseInt(request.getParameter("positionEmployee"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int idDepartment = 0;
        try {
            idDepartment = Integer.parseInt(request.getParameter("departmentEmployee"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String birthday = request.getParameter("birthday");
        String identity = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String salary = request.getParameter("salary");
        Employee employee = new Employee(id, idLevel, idPosition, idDepartment, name, birthday, identity, phoneNumber, email, salary);
        this.employeeService.updateEmployee(employee, employee.getId());
        viewEmployee(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                try {
                    editEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "create":
                try {
                    createEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    searchEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
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
                    viewCreateEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    viewEditEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                try {
                    viewEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}


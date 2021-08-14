package controller;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    private  static List<Customer> customerList;

    @Override
    public void init() throws ServletException {
        customerList =new ArrayList<>();
        customerList.add(new Customer( 1,"Nguyễn Văn Đạt","05-07-2000","Cần Thơ","/static/image/avatar1.jpg"));
        customerList.add(new Customer( 2,"Hồ Đức Bảo","08-05-1999","Hà Nội","/static/image/avatar2.jpg"));
        customerList.add(new Customer( 3,"Tạ Yến Như","15-10-1995","Sa Pa","/static/image/avatar3.jpg"));
        customerList.add(new Customer( 4,"Nguyễn Gia Huy","02-03-1895","Hồ Chí Minh","/static/image/avatar2.jpg"));
        customerList.add(new Customer( 5,"Huỳnh Nhã Kì","07-02-2001","Bình Định","/static/image/avatar1.jpg"));
        customerList.add(new Customer( 6,"Trần Thị Diệu Nhi","12-05-1997","Phú Quốc","/static/image/avatar3.jpg"));
        customerList.add(new Customer( 7,"Nguyễn ST","10-02-1995","Ninh Thuận","/static/image/avatar1.jpg"));
        customerList.add(new Customer( 8,"Nguyễn Thị Thu Uyên","11-11-2000","Quảng Ngãi","/static/image/avatar2.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("/customer/listCustomer.jsp").forward(request,response);
    }
}

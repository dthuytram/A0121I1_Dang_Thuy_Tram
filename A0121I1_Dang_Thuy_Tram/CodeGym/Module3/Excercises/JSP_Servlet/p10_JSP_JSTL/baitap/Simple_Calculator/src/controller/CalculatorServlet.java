package controller;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/result")
public class CalculatorServlet extends HttpServlet {
 private  static Calculator calculator;
    @Override
    public void init() throws ServletException {
        calculator =new Calculator();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            double numberfirst = Double.parseDouble(request.getParameter("first"));
            double numbersecond = Double.parseDouble(request.getParameter("second"));
             String openrator = request.getParameter("choice");


 String StrResult="";
        double result = 0 ;
        try {
            result = calculator.calculator(numberfirst,numbersecond,openrator);
            StrResult= numberfirst +" "+openrator+" "+numbersecond+" = "+result;
        } catch (Exception e) {
           StrResult= "ERROR :"+e.getMessage();
        }

        request.setAttribute("ketqua",StrResult);
             request.getRequestDispatcher("/calculator/resultCalculator.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

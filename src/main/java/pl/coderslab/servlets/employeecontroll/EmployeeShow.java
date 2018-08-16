package pl.coderslab.servlets.employeecontroll;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeShow", urlPatterns = "/admin/employee-show")
public class EmployeeShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employees = EmployeeDao.loadAll();
        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/employees.jsp").forward(request, response);
    }
}

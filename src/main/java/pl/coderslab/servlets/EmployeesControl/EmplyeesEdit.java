package pl.coderslab.servlets.EmployeesControl;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeesEdit", urlPatterns = "/employee-edit")
public class EmplyeesEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        String surname = request.getParameter("surname");

        String address = request.getParameter("address");

        String phone = request.getParameter("phone");

        String note = request.getParameter("note");

        float manhourValue = Float.parseFloat(request.getParameter("manhourValue"));


        Employee employee = new Employee(id, name, surname, address, phone, note, manhourValue);

        EmployeeDao.save(employee);


        response.sendRedirect("/employees-show");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        request.setAttribute("id",id);
        getServletContext().getRequestDispatcher("/EmployeeView/employeeEdit.jsp").forward(request,response);


    }
}

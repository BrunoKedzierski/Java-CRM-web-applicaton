package pl.coderslab.servlets.employeecontroll;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "EmployeeEdit", urlPatterns = "/admin/employee-edit")
public class EmployeeEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int id = (int) session.getAttribute("id");
        session.removeAttribute("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        float manhourValue = Float.parseFloat(request.getParameter("manhourValue"));

        Employee employee = new Employee(id, name, surname, address, phone, note, manhourValue);
        EmployeeDao.save(employee);

        response.sendRedirect("/employee-show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        Float manhourValue = Float.parseFloat(request.getParameter("manhourValue"));

        try {
            int id = Integer.parseInt(idStr);

            session.setAttribute("id", id);
            request.setAttribute("name", name);
            request.setAttribute("surname", surname);
            request.setAttribute("address", address);
            request.setAttribute("phone", phone);
            request.setAttribute("note", note);
            request.setAttribute("manhourValue", manhourValue);


            request.setAttribute("mode", "edit");
            getServletContext().getRequestDispatcher("/employeeform.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/employee-show");
        }

    }
}

package pl.coderslab.servlets.customercontroll;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet(name = "CustomerEdit", urlPatterns = "/customer-edit")
public class CustomerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthdayStr = request.getParameter("birthday");

        LocalDate birthday = null;
        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            try {
                birthday = LocalDate.parse(birthdayStr);
            } catch (DateTimeParseException ignored) {
            }
        }
        System.out.println(id);
        System.out.println(name);
        System.out.println(surname);
        System.out.println(birthday);

        Customer customer = new Customer(id, name, surname, birthday);
        CustomerDao.save(customer);

        response.sendRedirect("/customer-show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id  = Integer.parseInt(request.getParameter("id"));
       request.setAttribute("id",id);
       getServletContext().getRequestDispatcher("/CustomerView/customerEdit.jsp").forward(request,response);
    }
}

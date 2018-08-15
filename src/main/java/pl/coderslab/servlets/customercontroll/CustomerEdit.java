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

@WebServlet(name = "CustomerEdit", urlPatterns = "/admin/customer-edit")
public class CustomerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int id = (int) session.getAttribute("id");
        session.removeAttribute("id");
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

        Customer customer = new Customer(id, name, surname, birthday);
        CustomerDao.save(customer);

        response.sendRedirect("/customer-show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthdayStr = request.getParameter("birthday");

        try {
            int id = Integer.parseInt(idStr);

            session.setAttribute("id", id);
            request.setAttribute("name", name);
            request.setAttribute("surname", surname);

            if (birthdayStr != null) {
                try {
                    LocalDate birthday = LocalDate.parse(birthdayStr);
                    request.setAttribute("birthday", birthday);
                } catch (DateTimeParseException ignored) {
                }
            }

            request.setAttribute("mode", "edit");
            getServletContext().getRequestDispatcher("/customerform.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/customer-show");
        }

    }
}

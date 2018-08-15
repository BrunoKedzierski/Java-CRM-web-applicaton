package pl.coderslab.servlets.customercontroll;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerShow", urlPatterns = "/admin/customer-show")
public class CustomerShow extends HttpServlet {
    private static String mode;

    @Override
    public void init() throws ServletException {
        mode = "show";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("show".equals(mode)) {
            mode = "edit";
        } else {
            mode = "show";
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customers;
        String idStr = request.getParameter("id");
        if (idStr != null) {
            customers = new ArrayList<>();
            try {
                int id = Integer.parseInt(idStr);
                customers.add(CustomerDao.loadById(id));
            } catch (NumberFormatException ignored) {
            }
        } else {
            customers = CustomerDao.loadAll();
        }
        request.setAttribute("customers", customers);
        request.setAttribute("mode", mode);
        getServletContext().getRequestDispatcher("/customers.jsp").forward(request, response);
    }
}

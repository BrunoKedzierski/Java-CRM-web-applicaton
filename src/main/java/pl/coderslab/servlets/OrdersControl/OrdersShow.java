package pl.coderslab.servlets.OrdersControl;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdersShow", urlPatterns = "/orders-show")
public class OrdersShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <Order> orders = OrderDao.loadAll();
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/OrdersView/orders.jsp").forward(request,response);
    }
}

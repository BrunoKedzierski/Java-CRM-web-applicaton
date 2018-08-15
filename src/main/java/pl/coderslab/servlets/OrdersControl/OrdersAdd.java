package pl.coderslab.servlets.OrdersControl;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Employee;
import pl.coderslab.models.Order;
import pl.coderslab.models.Status;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrdersAdd", urlPatterns = "/orders-add")
public class OrdersAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate recieved = null;
        LocalDate planedBeginning = null;
        LocalDate begun = null;
        Float expenses = null;
        try {
            recieved = LocalDate.parse(request.getParameter("recieved"));
            planedBeginning = LocalDate.parse(request.getParameter("planedBeginning"));
            begun = LocalDate.parse(request.getParameter("begun"));
            expenses = Float.parseFloat(request.getParameter("expenses"));
        } catch (DateTimeException e) {

        } catch (NumberFormatException e){

        }
        String workerId = request.getParameter("workerId");
        String problemDescription = request.getParameter("problemDescription");
        String repairDescription = request.getParameter("repairDescription ");
        Status status = Status.valueOf(request.getParameter("status"));
        Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        Float price = Float.parseFloat(request.getParameter("price"));
        Float manhours = Float.parseFloat(request.getParameter("manhours"));
        Employee employee = EmployeeDao.loadById(Integer.parseInt(workerId));
        Vehicle vehicle = VehicleDao.loadById(vehicleId);
        Order order = new Order(recieved, planedBeginning, begun, employee, problemDescription, repairDescription, status, vehicle, price, expenses, manhours);
        OrderDao.save(order);
        response.sendRedirect("/orders-show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = VehicleDao.loadAll();
        ArrayList<Employee> employees = EmployeeDao.loadAll();

        request.setAttribute("employees", employees);
        request.setAttribute("vehicles", vehicles);

        getServletContext().getRequestDispatcher("/OrdersView/OrdersForm.jsp").forward(request, response);
    }
}
